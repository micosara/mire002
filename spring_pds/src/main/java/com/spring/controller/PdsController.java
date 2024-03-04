package com.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.PageMaker;
import com.spring.command.PdsModifyCommand;
import com.spring.command.PdsRegistCommand;
import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;
import com.spring.service.PdsService;

@Controller

public class PdsController {

	@Autowired
	private PdsService pdsService;

	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute PageMaker pageMaker, ModelAndView mnv) throws Exception {
		String url="/pds/list";
		
		List<PdsVO> pdsList = pdsService.searchList(pageMaker);
		
		mnv.addObject("pdsList",pdsList);
		mnv.setViewName(url);
		return mnv;
	}

	@GetMapping("/registForm")
	public ModelAndView registForm(ModelAndView mnv) throws Exception {
		String url="/pds/regist";
		mnv.setViewName(url);
		return mnv;
	}

	@Resource(name="pdsSavedFilePath")
	private String fileUploadPath;
	
	@PostMapping(value = "/regist", produces = "text/plain;charset=utf-8")
	public ModelAndView regist(PdsRegistCommand regCommand, ModelAndView mnv) throws Exception {
		String url="/pds/regist_success";
		
		List<MultipartFile> multiFiles = regCommand.getUploadFile();
		String savePath = this.fileUploadPath;	
		
		List<AttachVO> attachList = saveFileToAttaches(multiFiles,savePath);
		
		//DB 
		PdsVO pds = regCommand.toPdsVO();
		pds.setAttachList(attachList);
		
		pdsService.regist(pds);
		
		mnv.setViewName(url);
		return mnv;
	}

	@GetMapping("/detail")
	public ModelAndView detail(int pno, String from, ModelAndView mnv) throws Exception {
		String url="/pds/detail";
		
		PdsVO pds = null;
		if (from != null && from.equals("list")) {
			pdsService.increaseViewCnt(pno);
			url = "redirect:/detail?pno="+pno;
		} else {
			pds = pdsService.getPds(pno);
		}
		
		mnv.addObject("pds",pds);
		
		mnv.setViewName(url);
		return mnv;
	}
	
	@GetMapping("/modifyForm")
	public ModelAndView modifyForm(int pno, ModelAndView mnv)throws Exception{
		String url = "/pds/modify";
		
		PdsVO pds = pdsService.getPds(pno);
		
		mnv.addObject("pds",pds);
		mnv.setViewName(url);
		return mnv;
	}
	
	@PostMapping("/modify")
	public ModelAndView modify(PdsModifyCommand modifyCommand, ModelAndView mnv)throws Exception{
		String url = "/pds/modify_success";
		
		//파일삭제
		if(modifyCommand.getDeleteFile() != null && modifyCommand.getDeleteFile().length > 0) {
			for(int ano : modifyCommand.getDeleteFile()) {
				AttachVO attach = pdsService.getAttachByAno(ano);
				
				String savedPath = attach.getUploadPath().replace("/", File.separator);
				
				File deleteFile = new File(savedPath, attach.getFileName());
				
				if(deleteFile.exists()) {
					deleteFile.delete(); //파일삭제
				}
				pdsService.removeAttachByAno(ano); //DB삭제
			}
		}
		
		//파일저장
		List<AttachVO> attachList 
		= saveFileToAttaches(modifyCommand.getUploadFile(), fileUploadPath);
		
		//PdsVO setting
		PdsVO pds = modifyCommand.toPdsVO();
		pds.setAttachList(attachList);
		
		//DB 저장
		pdsService.modify(pds);
		
		mnv.setViewName(url);
		return mnv;
	}
	
	@GetMapping("/remove")
	public ModelAndView remove(int pno, ModelAndView mnv)throws Exception{
		String url="/pds/remove_success";
		
		//첨부파일 삭제
		List<AttachVO> attachList = pdsService.getPds(pno).getAttachList();
		if(attachList != null) {
			for(AttachVO attach : attachList) {
				File target = new File(attach.getUploadPath(), attach.getFileName());
				if(target.exists()) {
					target.delete();
				}
			}
		}
		
		pdsService.remove(pno);
		
		mnv.setViewName(url);
		return mnv;
	}
	
	@GetMapping("/getFile")
	public ModelAndView getFile(int ano,  ModelAndView mnv)throws Exception{
		String url="download";
		
		AttachVO attach = pdsService.getAttachByAno(ano);
		

		mnv.addObject("savedPath", attach.getUploadPath());
		mnv.addObject("fileName", attach.getFileName());		
		
		mnv.setViewName(url);
		return mnv;
	}
	
	
	private List<AttachVO> saveFileToAttaches(List<MultipartFile> multiFiles,
			  String savePath )throws Exception{
		
		if (multiFiles == null) return null;
		
		//저장 -> attachVO -> list.add
		List<AttachVO> attachList = new ArrayList<AttachVO>();
		for (MultipartFile multi : multiFiles) {
			String uuid = UUID.randomUUID().toString().replace("-", "");
			String fileName = uuid+"$$"+multi.getOriginalFilename();
			
			//파일저장
			File target = new File(savePath, fileName);
			target.mkdirs();
			multi.transferTo(target);
			
			//attachVO
			AttachVO attach = new AttachVO();
			attach.setUploadPath(savePath);
			attach.setFileName(fileName);
			attach.setFileType(fileName.substring(fileName.lastIndexOf('.') + 1)
					.toUpperCase());
			
			attachList.add(attach);
		}
		return attachList;
	}
}




