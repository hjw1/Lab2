package com;

import com.SQLHelper;

import java.awt.print.Printable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class deleteAction extends ActionSupport {
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
		String deletesql = "delete from book where title='" + this.id + "'";
		String sql = "select authorid from book where title='" + this.id + "'";
		String authorid = "";
		ResultSet rs = null;
		ArrayList<String> lst = new ArrayList<String>();

		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}
		try {
			rs = sHelper.getConnection().createStatement().executeQuery(sql);
			if (rs.next()) {
				authorid = rs.getString("authorid");
			}

		} catch (SQLException ex) {
			return ERROR;
		}

		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}

		try {
			sHelper.getConnection().createStatement().executeUpdate(deletesql);
		} catch (SQLException ex) {
			return INPUT;
		}

		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}
		try {
			String searchsql = "select title from book where authorid='" + authorid + "'";
			rs = sHelper.getConnection().createStatement().executeQuery(searchsql);
			while (rs.next()) {
				lst.add(rs.getString("title"));
			}
			if (lst.size() != 0) {
				ActionContext.getContext().put("bookList", lst);
				return SUCCESS;
			} else
				return INPUT;

		} catch (SQLException ex) {
			return ERROR;
		}
	}
}