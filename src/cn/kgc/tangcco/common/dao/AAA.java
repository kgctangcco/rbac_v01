package cn.kgc.tangcco.common.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.kgc.tangcco.common.servlet.BaseServlet;

/**
 */
@WebServlet(value="/async",asyncSupported=true)
public class AAA extends BaseServlet {

	private static final long serialVersionUID = 1395705856095123802L;

	public void login(HttpServletRequest request, HttpServletResponse response, String parmas) {
		System.out.println(parmas);
	}
}
