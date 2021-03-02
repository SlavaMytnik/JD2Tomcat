package org.example.tomcat1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.command.Command;

public class ChangeLocal implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		
		String local = request.getParameter("local");
		
		if (session != null) session.setAttribute("local", local);

		if (session == null) {
			response.sendRedirect("Controller?command=gotoindexpage");
			
			return;
		}

		String url = (String) session.getAttribute("url");

		response.sendRedirect(url);
	}
}
