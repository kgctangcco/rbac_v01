package cn.kgc.tangcco.menu.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.kgc.tangcco.common.dao.BaseDao;
import cn.kgc.tangcco.menu.dao.MenuDao;
import cn.kgc.tangcco.menu.entity.Menu;

public class MenuDaoImpl implements MenuDao {

	@Override
	public List<Menu> getAllMenus() {
		String sql = "select * from menu";
		return BaseDao.queryList(sql, Menu.class);
	}
	
	@Test
	public void test() throws Exception {
		List<Menu> allMenus = getAllMenus();
		System.out.println(allMenus);
	}

}
