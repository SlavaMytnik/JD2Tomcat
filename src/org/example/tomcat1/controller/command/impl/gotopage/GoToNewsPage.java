package org.example.tomcat1.controller.command.impl.gotopage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.example.tomcat1.bean.News;
import org.example.tomcat1.controller.ControllerException;
import org.example.tomcat1.controller.command.ICommand;
import org.example.tomcat1.controller.command.impl.CommandBouncer;
import org.example.tomcat1.controller.command.impl.CommandConstants;
import org.example.tomcat1.service.INewsService;
import org.example.tomcat1.service.ServiceException;
import org.example.tomcat1.service.ServiceProvider;

public class GoToNewsPage extends CommandConstants implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ControllerException {		
		CommandBouncer bouncer = new CommandBouncer();		
		
		if (!bouncer.checkSessionAndAuth(request, response)) return;
		
		HttpSession session = request.getSession();		

		ServiceProvider provider = ServiceProvider.getInstance();
		
		INewsService newsService = provider.getNewsService();

		try {
			Integer id = Integer.valueOf(request.getParameter(PAR_OR_ATTR_ID));
			
			Boolean edited = Boolean.valueOf(request.getParameter(PAR_OR_ATTR_EDITED));

			News news = newsService.getById(id);
			
			String url = request.getRequestURL() + "?" + request.getQueryString();
			
			session.setAttribute(PAR_OR_ATTR_URL, url);			
			request.setAttribute(PAR_OR_ATTR_NEWS, news);	
			request.setAttribute(PAR_OR_ATTR_EDITED, edited);	
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/page_news_show.jsp");
			requestDispatcher.forward(request, response);		
		} catch (ServiceException | NumberFormatException e) {
			throw new ControllerException(e);
		}	
	}
}
