package org.example.tomcat1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.command.Command;
import org.example.tomcat1.service.NewsService;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;

public class ModifyNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		
		Boolean isAuth = (Boolean) session.getAttribute("auth");

		if (session == null || isAuth == null || !isAuth) {
			response.sendRedirect("Controller?command=gotoindexpage");
			
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();
		
		NewsService newsService = provider.getNewsService();

		Integer id = Integer.valueOf(request.getParameter("id"));
		
		String title = request.getParameter("title");
		String brief = request.getParameter("brief");
		String content = request.getParameter("content");
		
		try {
			Boolean edited = newsService.editById(id, title, brief, content);			
			
			response.sendRedirect("Controller?command=gotonewspage&id=" + id + "&edited=" + edited);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

