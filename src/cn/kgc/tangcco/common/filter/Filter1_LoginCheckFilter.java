package cn.kgc.tangcco.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.kgc.tangcco.user.entity.User;
/**
 * 登录检查
 * @author zlx
 *
 */
@WebFilter("*.action")
public class Filter1_LoginCheckFilter implements Filter {

    public Filter1_LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//除了首页之外的其余页面，都需要session中有loginUser对象
		String methodName = request.getParameter("methodName");
		System.out.println(methodName+"------");
		if (methodName!=null&&!methodName.equals("toLogin")&&!methodName.equals("doLogin")) {//既不是欢迎页，也不是去登录页（比如注销、切换用户）
			HttpServletRequest req = (HttpServletRequest)request;//向下转型
			HttpSession session = req.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			if (loginUser==null) {
				HttpServletResponse res = (HttpServletResponse)response;
				res.sendRedirect("user.action?methodName=toLogin");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
