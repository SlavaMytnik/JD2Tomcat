package org.example.tomcat1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.example.tomcat1.bean.News;
import org.example.tomcat1.dao.DAOException;
import org.example.tomcat1.dao.INewsDAO;

public class SQLNewsDAO extends SQLConstants implements INewsDAO {

	@Override
	public List<News> getAll() throws DAOException {
		List<News> news = null;
		
		try (Connection con = DriverManager.getConnection(CONNECTION_HOST, CONNECTION_LOGIN, CONNECTION_PASSWORD)) {						
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM " + TABLE_NEWS + " WHERE " + COLUMN_STATUS 
					+ " = '" + STATUS_ACTIVE + "' ORDER BY date DESC;");
			
			news = new ArrayList<News>();
			
			while(rs.next()) {
				int id = rs.getInt(COLUMN_ID);
				
				String title = rs.getString(COLUMN_TITLE);
				String brief = rs.getString(COLUMN_BRIEF);
				String content = rs.getString(COLUMN_CONTENT);
				
				LocalDate date = rs.getDate(COLUMN_DATE).toLocalDate();
				
				News n = new News(id, title, brief, content, date);
				
				news.add(n);				
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} 
		
		return news;
	}

	@Override
	public News getById(int id) throws DAOException {
		News news = null;

		try (Connection con = DriverManager.getConnection(CONNECTION_HOST, CONNECTION_LOGIN, CONNECTION_PASSWORD)) {	
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM " + TABLE_NEWS + " WHERE " + COLUMN_ID + " = " + id + ";");
			
			if (rs.next()) {
				String title = rs.getString(COLUMN_TITLE);
				String brief = rs.getString(COLUMN_BRIEF);
				String content = rs.getString(COLUMN_CONTENT);
				
				LocalDate date = rs.getDate(COLUMN_DATE).toLocalDate();
				
				news = new News(id, title, brief, content, date);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} 
		
		return news;
	}

	@Override
	public Boolean editById(int id, String title, String brief, String content) throws DAOException {
		Boolean editResult = false;

		try (Connection con = DriverManager.getConnection(CONNECTION_HOST, CONNECTION_LOGIN, CONNECTION_PASSWORD)) {
			Statement st = con.createStatement();
			
			String STRING_QUARY = "UPDATE " + TABLE_NEWS + " SET " + COLUMN_TITLE + " = '" + title + "', " + COLUMN_BRIEF + " = '" 
					+ brief + "', " + COLUMN_CONTENT + " = '" + content + "' WHERE " + COLUMN_ID + " = " + id + ";";
			
			int col = st.executeUpdate(STRING_QUARY);
			
			if (col > 0) {
				editResult = true;
			} 
		} catch (SQLException e) {
			throw new DAOException(e);
		} 

		return editResult;
	}
	
	@Override
	public Boolean deleteById(int id) throws DAOException {
		Boolean delResult = false;

		try (Connection con = DriverManager.getConnection(CONNECTION_HOST, CONNECTION_LOGIN, CONNECTION_PASSWORD)) {
			Statement st = con.createStatement();
			
			String STRING_QUARY = "UPDATE " + TABLE_NEWS + " SET " + COLUMN_STATUS + " = '" + STATUS_DELETED 
					+ "' WHERE " + COLUMN_ID + " = " + id + ";";
			
			int col = st.executeUpdate(STRING_QUARY);
			
			if (col > 0) {
				delResult = true;
			} 
		} catch (SQLException e) {
			throw new DAOException(e);
		} 

		return delResult;
	}
}
