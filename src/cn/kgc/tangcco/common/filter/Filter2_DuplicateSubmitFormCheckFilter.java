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

/**
 * 重复提交表单检查（添加、修改）
 */
@WebFilter("*.action")
public class Filter2_DuplicateSubmitFormCheckFilter implements Filter {

    /**
     * Default constructor. 
     */
    public Filter2_DuplicateSubmitFormCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//如果想执行doAdd\doUpdate方法，前提条件是刚刚执行了toAdd\toUpdate
		String methodName = request.getParameter("methodName");
		HttpSession session = ((HttpServletRequest)request).getSession();
		if(methodName==null) {//欢迎页
			chain.doFilter(request, response);
		}else if (methodName.startsWith("toAdd")||methodName.startsWith("toUpdate")) {//去添加、去修改
			session.setAttribute("state", "ok");//"ok"字符串可以换成boolean类型、枚举类型、字符串常量...
			chain.doFilter(request, response);
		}else if (methodName.startsWith("doAdd")||methodName.startsWith("doUpdate")) {//执行添加、执行修改
			String state = (String)session.getAttribute("state");
			if (state.equals("ok")) {//点添加、修改超链接
				session.setAttribute("state", "done");
				chain.doFilter(request, response);
			}else {
				//后退回来的（重复提交表单）
				((HttpServletResponse)response).sendRedirect("subject.action?methodName=toSubjectList");//也可以给提示或者去其余页面错误提示页面
			}
		}else {//其余一切
			chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
