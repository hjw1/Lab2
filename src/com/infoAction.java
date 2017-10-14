package com;

import com.SQLHelper;
import java.text.SimpleDateFormat;
import java.awt.print.Printable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class infoAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String execute() throws SQLException {
		SQLHelper sHelper = null;
		String authorid="";
		// �½�����
		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}
		String sql = "select * from book where title='" + this.id + "'";

		ResultSet rs = null;

		// ��ü�����������ؽ���ַ���
		try {

			rs = sHelper.getConnection().createStatement().executeQuery(sql);
			if (rs.next()) {
				String isbn = rs.getString("isbn");
				ActionContext.getContext().put("isbn", isbn);

				String title = rs.getString("title");
				ActionContext.getContext().put("title", title);

				authorid = rs.getString("authorid");
				ActionContext.getContext().put("authorid", authorid);

				String sqlauthor = "select * from book where AuthorID='" + authorid + "'";
				ResultSet rsauthor = null;

				String publisher = rs.getString("publisher");
				ActionContext.getContext().put("publisher", publisher);

				Date Publishdate = rs.getDate("publishdate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String publishdate = sdf.format(Publishdate);
				ActionContext.getContext().put("publishdate", publishdate);

				double price = rs.getDouble("price");
				ActionContext.getContext().put("price", price);
			}
		} catch (SQLException ex) {
			return INPUT;
		}
		// �½�����
		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}

		// ��ü�����������ؽ���ַ���
		try {
			String sqlauthor = "select * from author where authorid='" + authorid + "'";
			ResultSet rsauthor = sHelper.getConnection().createStatement().executeQuery(sqlauthor);
			if (rsauthor.next()) {
				String name = rsauthor.getString("name");
				ActionContext.getContext().put("name", name);
				int age = rsauthor.getInt("age");
				ActionContext.getContext().put("age", age);
				String country = rsauthor.getString("country");
				ActionContext.getContext().put("country", country);
			}
			return SUCCESS;
		} catch (SQLException ex) {
			return INPUT;
		}

	}

}