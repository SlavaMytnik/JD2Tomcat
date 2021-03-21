package org.example.tomcat1.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.example.tomcat1.controller.ControllerException;

public interface ICommand {
	void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,
			IOException, ControllerException;
}
