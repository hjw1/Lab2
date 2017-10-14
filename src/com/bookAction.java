package com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;//import

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class bookAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String author;
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String execute() throws Exception {
		SQLHelper sHelper = null;
		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}
		String sql = "select title from book where authorid= ( select authorid from author where name='" + this.author
				+ "')";
		ResultSet rs = null;
		// 获得检索结果并返回结果字符串
		try {
			ArrayList<String> lst = new ArrayList<String>();
			rs = sHelper.getConnection().createStatement().executeQuery(sql);
		    while (rs.next()) {
					lst.add(rs.getString("title"));
			}
		    if(lst.size()!=0)
		    {
				ActionContext.getContext().put("bookList", lst);
				return SUCCESS;
			}
		    else  return INPUT;
			
		} catch (SQLException ex) {
			return ERROR;
		}

	}
}
