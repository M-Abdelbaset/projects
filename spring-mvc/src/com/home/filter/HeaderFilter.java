package com.home.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		req.setAttribute("filtered", true);
		if(req.getParameter("block") != null) {
			ServletOutputStream os = res.getOutputStream();
			os.print("Rejected");
			os.close();
		}else {
			chain.doFilter(req, res);
		}
	}
}
