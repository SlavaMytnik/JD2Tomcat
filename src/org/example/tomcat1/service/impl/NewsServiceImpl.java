package org.example.tomcat1.service.impl;

import java.util.List;

import org.example.tomcat1.bean.News;
import org.example.tomcat1.dao.DAOException;
import org.example.tomcat1.dao.DAOProvider;
import org.example.tomcat1.dao.INewsDAO;
import org.example.tomcat1.service.INewsService;
import org.example.tomcat1.service.ServiceException;

public class NewsServiceImpl implements INewsService {

	@Override
	public List<News> getAll() throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		
		INewsDAO newsDAO = provider.getNewsDAO();
		
		List<News> news;
		
		try {
			news = newsDAO.getAll();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return news;
	}

	@Override
	public News getById(int id) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		
		INewsDAO newsDAO = provider.getNewsDAO();
		
		News news;
		
		try {
			news = newsDAO.getById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return news;
	}

	@Override
	public Boolean editById(int id, String title, String brief, String content) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		
		INewsDAO newsDAO = provider.getNewsDAO();
		
		Boolean edited;
		
		try {
			edited = newsDAO.editById(id, title, brief, content);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return edited;
	}
	
	@Override
	public Boolean deleteById(int id) throws ServiceException {
		DAOProvider provider = DAOProvider.getInstance();
		
		INewsDAO newsDAO = provider.getNewsDAO();
		
		Boolean deleted;
		
		try {
			deleted = newsDAO.deleteById(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		
		return deleted;
	}
}
