package com.spring.service;

import java.sql.SQLException;
import java.util.List;

import com.spring.command.PageMaker;
import com.spring.dao.AttachDAO;
import com.spring.dao.PdsDAO;
import com.spring.dto.AttachVO;
import com.spring.dto.PdsVO;

public class PdsServiceImpl implements PdsService{

	private PdsDAO pdsDAO;
	private AttachDAO attachDAO;
	
	public void setPdsDAO(PdsDAO pdsDAO) {
		this.pdsDAO = pdsDAO;
	}
	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO = attachDAO;
	}

	
	
	@Override
	public List<PdsVO> searchList(PageMaker pageMaker) throws SQLException {
		List<PdsVO> pdsList = pdsDAO.selectSearchPdsList(pageMaker);
		if(pdsList !=null) for(PdsVO pds : pdsList) {
			int pno = pds.getPno();
			List<AttachVO> attachList = attachDAO.selectAttachByPno(pno);
			pds.setAttachList(attachList);
		}
		
		int listTotalCount = pdsDAO.selectSearchPdsListCount(pageMaker);
		pageMaker.setTotalCount(listTotalCount);
		
		return pdsList;
	}

	@Override
	public void increaseViewCnt(int pno) throws SQLException {
		pdsDAO.increaseViewCnt(pno);
	}
	
	@Override
	public void regist(PdsVO pds) throws SQLException {
		List<AttachVO> attachList = pds.getAttachList();
		
		int pno = pdsDAO.selectPdsSeqNext();
		
		pds.setPno(pno);
		
		pdsDAO.insertPds(pds);
		
		if(attachList!=null) for(AttachVO attach : attachList) {
			attach.setPno(pno);
			attach.setAttacher(pds.getWriter());
			attachDAO.insertAttach(attach);
		}
		
		
	}

	@Override
	public void modify(PdsVO pds) throws SQLException {
		pdsDAO.updatePds(pds);
		
		int pno = pds.getPno();
		
		List<AttachVO> attachList = pds.getAttachList();
		if(attachList!=null) for(AttachVO attach : attachList) {
			attach.setPno(pno);
			attach.setAttacher(pds.getWriter());
			attachDAO.insertAttach(attach);
		}
		
	}

	@Override
	public void remove(int pno) throws SQLException {
		//attachDAO.deletAllAttach(pno);
		pdsDAO.deletePds(pno);
	}

	@Override
	public AttachVO getAttachByAno(int ano) throws SQLException {
		return attachDAO.selectAttachByAno(ano);
	}

	@Override
	public void removeAttachByAno(int ano) throws SQLException {
		attachDAO.deletAttach(ano);
		
	}
	@Override
	public PdsVO getPds(int pno) throws SQLException {
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		List<AttachVO> attachList = attachDAO.selectAttachByPno(pno);
		pds.setAttachList(attachList);
		return pds;
	}

}
