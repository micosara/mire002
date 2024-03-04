package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.MenuVO;

public class MenuDAOImpl implements MenuDAO{


	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public List<MenuVO> selectMainMenu() throws SQLException {
		List<MenuVO> menuList = session.selectList("Menu-Mapper.selectMainMenu");
		return menuList;
	}

	@Override
	public List<MenuVO> selectSubMenu(String mCode) throws SQLException {
		List<MenuVO> menuList 
				= session.selectList("Menu-Mapper.selectSubMenu",mCode);
		return menuList;
	}

	@Override
	public MenuVO selectMenuByMcode(String mCode) throws SQLException {
		MenuVO menu = session.selectOne("Menu-Mapper.selectMenuByMcode",mCode);
		return menu;
	}
	
	@Override
	public MenuVO selectMenuByMname(String mName) throws SQLException {
		MenuVO menu = session.selectOne("Menu-Mapper.selectMenuByMname",mName);
		return menu;
	}
}
