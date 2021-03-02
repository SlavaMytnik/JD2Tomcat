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
import org.example.tomcat1.dao.NewsDAO;

public class SQLNewsDAO implements NewsDAO {
	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public List<News> getAll() throws DAOException {
		Connection con = null;
		
		List<News> news = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC",
					"root", "root");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM news WHERE status='active' ORDER BY date DESC;");
			
			news = new ArrayList<News>();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				
				LocalDate date = rs.getDate("date").toLocalDate();
				
				News n = new News(id, title, brief, content, date);
				
				news.add(n);				
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return news;
	}

	@Override
	public News getById(int id) throws DAOException {
		Connection con = null;
				
		News news = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC",
					"root", "root");
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM news WHERE id=" + id + ";");
			
			if (rs.next()) {
				String title = rs.getString("title");
				String brief = rs.getString("brief");
				String content = rs.getString("content");
				
				LocalDate date = rs.getDate("date").toLocalDate();
				
				news = new News(id, title, brief, content, date);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return news;
	}

	@Override
	public Boolean editById(int id, String title, String brief, String content) throws DAOException {
		Connection con = null;
		
		Boolean editResult = false;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC",
					"root", "root");
			
			Statement st = con.createStatement();
			
			String STRING_QUARY = "UPDATE news SET title='" + title + "', brief='" 
					+ brief + "', content='" + content + "' WHERE id=" + id + ";";
			
			int col = st.executeUpdate(STRING_QUARY);
			
			if (col > 0) {
				editResult = true;
			} 
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return editResult;
	}
	
	@Override
	public Boolean deleteById(int id) throws DAOException {
		Connection con = null;
		
		Boolean delResult = false;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/news_management?useSSL=false&serverTimezone=UTC",
					"root", "root");
			
			Statement st = con.createStatement();
			
			String STRING_QUARY = "UPDATE news SET status='deleted' WHERE id=" + id + ";";
			
			int col = st.executeUpdate(STRING_QUARY);
			
			if (col > 0) {
				delResult = true;
			} 
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DAOException(e);
			}
		}

		return delResult;
	}
}
