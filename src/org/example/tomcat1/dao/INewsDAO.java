package org.example.tomcat1.dao;

import java.util.List;

import org.example.tomcat1.bean.News;

public interface INewsDAO {
	List<News> getAll() throws DAOException;
	News getById(int id) throws DAOException;
	Boolean editById(int id, String title, String brief, String content)
			throws DAOException;
	Boolean deleteById(int id) throws DAOException;
}
