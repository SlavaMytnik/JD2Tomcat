package org.example.tomcat1.service;

import java.util.List;

import org.example.tomcat1.bean.News;

public interface NewsService {
	List<News> getAll() throws ServiceException;
	News getById(int id) throws ServiceException;
	Boolean editById(int id, String title, String brief, String content) throws ServiceException;
	Boolean deleteById(int id) throws ServiceException;
}
