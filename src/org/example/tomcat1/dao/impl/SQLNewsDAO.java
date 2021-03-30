package org.example.tomcat1.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.example.tomcat1.bean.News;
import org.example.tomcat1.dao.DAOConnectionPool;
import org.example.tomcat1.dao.DAOException;
import org.example.tomcat1.dao.INewsDAO;

import static org.example.tomcat1.dao.DAOConstants.*;

public final class SQLNewsDAO implements INewsDAO {
	private static final DAOConnectionPool CONNECTION_POOL;

	static {
		CONNECTION_POOL = DAOConnectionPool.getInstance();
	}

	@Override
	public List<News> getAll() throws DAOException {
		List<News> news = null;

		Connection con = null;

		Statement st = null;

		ResultSet rs = null;

		try {
			con = CONNECTION_POOL.getConnection();

			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM "
					+ TABLE_NEWS
					+ " WHERE "
					+ COLUMN_STATUS + " = '" + STATUS_ACTIVE
					+ "' ORDER BY date DESC;");

			news = new ArrayList<News>();

			while (rs.next()) {
				int id = rs.getInt(COLUMN_ID);

				String title = rs.getString(COLUMN_TITLE);
				String brief = rs.getString(COLUMN_BRIEF);
				String content = rs.getString(COLUMN_CONTENT);

				LocalDate date = rs.getDate(COLUMN_DATE)
						.toLocalDate();

				News n = new News(id, title,
						brief, content, date);

				news.add(n);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			CONNECTION_POOL.closeConnection(con, st, rs);
		}

		return news;
	}

	@Override
	public News getById(final int id) throws DAOException {
		News news = null;

		Connection con = null;

		Statement st = null;

		ResultSet rs = null;

		try {
			con = CONNECTION_POOL.getConnection();

			st = con.createStatement();

			rs = st.executeQuery("SELECT * FROM "
					+ TABLE_NEWS
					+ " WHERE "
					+ COLUMN_ID + " = " + id
					+ ";");

			if (rs.next()) {
				String title = rs.getString(COLUMN_TITLE);
				String brief = rs.getString(COLUMN_BRIEF);
				String content = rs.getString(COLUMN_CONTENT);

				LocalDate date = rs.getDate(COLUMN_DATE)
						.toLocalDate();

				news = new News(id, title,
						brief, content, date);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			CONNECTION_POOL.closeConnection(con, st, rs);
		}

		return news;
	}

	@Override
	public Boolean editById(final int id, final String title,
			final String brief, final String content)
			throws DAOException {
		Boolean editResult = false;

		Connection con = null;

		Statement st = null;

		try {
			con = CONNECTION_POOL.getConnection();

			st = con.createStatement();

			String query = "UPDATE "
					+ TABLE_NEWS
					+ " SET "
					+ COLUMN_TITLE + " = '" + title
					+ "', "
					+ COLUMN_BRIEF + " = '" + brief
					+ "', "
					+ COLUMN_CONTENT + " = '" + content
					+ "' WHERE "
					+ COLUMN_ID + " = " + id
					+ ";";

			int col = st.executeUpdate(query);

			if (col > 0) {
				editResult = true;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			CONNECTION_POOL.closeConnection(con, st);
		}

		return editResult;
	}

	@Override
	public Boolean deleteById(final int id) throws DAOException {
		Boolean delResult = false;

		Connection con = null;

		Statement st = null;

		try {
			con = CONNECTION_POOL.getConnection();

			st = con.createStatement();
			
			String query = "UPDATE "
					+ TABLE_NEWS
					+ " SET "
					+ COLUMN_STATUS + " = '" + STATUS_DELETED
					+ "' WHERE "
					+ COLUMN_ID + " = " + id
					+ ";";

			int col = st.executeUpdate(query);

			if (col > 0) {
				delResult = true;
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			CONNECTION_POOL.closeConnection(con, st);
		}

		return delResult;
	}
}
