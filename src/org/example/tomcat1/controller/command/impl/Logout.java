package org.example.tomcat1.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.controller.command.Command;

public class Logout implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession();
		
		if (session != null) {
			session.removeAttribute("auth");
			session.removeAttribute("username");
			session.removeAttribute("role");
		}
		
		response.sendRedirect("Controller?command=gotoindexpage");		
	}
}
