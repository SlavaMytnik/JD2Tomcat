package org.example.tomcat1.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public final class CharsetFilter implements Filter {
	private String encoding;

	@Override
	public void doFilter(final ServletRequest request,
			final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);

		chain.doFilter(request, response);
	}

	public void init(final FilterConfig fConfig)
			throws ServletException {
		encoding = fConfig.getInitParameter("characterEncoding");
	}

	@Override
	public void destroy() {}
}
