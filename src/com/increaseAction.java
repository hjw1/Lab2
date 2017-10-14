package com;

import com.SQLHelper;
import com.mysql.jdbc.PreparedStatement;

import java.awt.print.Printable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class increaseAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String bookname;
	private String bookisbn;
	private String bookauthor;
	private String bookpublisher;
	private String bookpublishyear;
	private String bookpublishmonth;
	private String bookpublishday;
	private String bookprice;

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	public String getBookauthor() {
		return bookauthor;
	}

	public void setBookauthor(String bookauthor) {
		this.bookauthor = bookauthor;
	}

	public String getBookpublisher() {
		return bookpublisher;
	}

	public void setBookpublisher(String bookpublisher) {
		this.bookpublisher = bookpublisher;
	}

	public String getBookpublishyear() {
		return bookpublishyear;
	}

	public void setBookpublishyear(String bookpublishyear) {
		this.bookpublishyear = bookpublishyear;
	}

	public String getBookpublishmonth() {
		return bookpublishmonth;
	}

	public void setBookpublishmonth(String bookpublishmonth) {
		this.bookpublishmonth = bookpublishmonth;
	}

	public String getBookpublishday() {
		return bookpublishday;
	}

	public void setBookpublishday(String bookpublishday) {
		this.bookpublishday = bookpublishday;
	}

	public String getBookprice() {
		return bookprice;
	}

	public void setBookprice(String bookprice) {
		this.bookprice = bookprice;
	}

	public String execute() throws SQLException {
		SQLHelper sHelper = null;
		String bookauthorid = "";
        boolean logo=false;
		
		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return INPUT;
		}
		String sql = "select authorid from author where name='" + this.bookauthor + "'";
		ResultSet rs = null;

		try {
			rs = sHelper.getConnection().createStatement().executeQuery(sql);
			if (rs.next()) {
				bookauthorid = rs.getString("authorid");
			}
			else
			{
				logo=true;//没有在数据库中找到author
			}
		} catch (SQLException ex) {
			return INPUT;
		}
		
		if(!logo)//在数据库中找到author
		{
			try {
				sHelper = new SQLHelper();
			} catch (Exception e) {
				return INPUT;
			}

			String sqlinsert = "insert into book values('" + this.bookisbn + "'" + ",'" + this.bookname
					+ "'" + ",'" + this.bookpublisher + "'" + ",'" + this.bookpublishyear
					+ this.bookpublishmonth + this.bookpublishday + "'" + ",'" + this.bookprice + "'"
					+ ",'" + bookauthorid + "')";
			try {
				sHelper.getConnection().createStatement().executeUpdate(sqlinsert);
				return SUCCESS;
			} catch (SQLException ex) {
				return INPUT;
			}

		}
		else//没有在数据库中找到author
		{
			ActionContext.getContext().put("increasebookname", this.bookname);
			ActionContext.getContext().put("increasebookisbn", this.bookisbn);
			ActionContext.getContext().put("increasebookauthor", this.bookauthor);
			ActionContext.getContext().put("increasebookpublisher", this.bookpublisher);
			ActionContext.getContext().put("increasebookpublishyear", this.bookpublishyear);
			ActionContext.getContext().put("increasebookpublishmonth", this.bookpublishmonth);
			ActionContext.getContext().put("increasebookpublishday", this.bookpublishday);
			ActionContext.getContext().put("increasebookprice", this.bookprice);
			return ERROR;
		}

		
	}

}
