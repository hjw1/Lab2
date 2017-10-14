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

public class updatedetailAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String updatenewbookname;
	private String updatenewbookisbn;
	private String updatenewbookauthor;
	private String updatenewbookpublisher;
	private String updatenewbookpublishyear;
	private String updatenewbookpublishmonth;
	private String updatenewbookpublishday;
	private String updatenewbookprice;

	public String getUpdatenewbookname() {
		return updatenewbookname;
	}

	public void setUpdatenewbookname(String updatenewbookname) {
		this.updatenewbookname = updatenewbookname;
	}

	public String getUpdatenewbookisbn() {
		return updatenewbookisbn;
	}

	public void setUpdatenewbookisbn(String updatenewbookisbn) {
		this.updatenewbookisbn = updatenewbookisbn;
	}

	public String getUpdatenewbookauthor() {
		return updatenewbookauthor;
	}

	public void setUpdatenewbookauthor(String updatenewbookauthor) {
		this.updatenewbookauthor = updatenewbookauthor;
	}

	public String getUpdatenewbookpublisher() {
		return updatenewbookpublisher;
	}

	public void setUpdatenewbookpublisher(String updatenewbookpublisher) {
		this.updatenewbookpublisher = updatenewbookpublisher;
	}

	public String getUpdatenewbookpublishyear() {
		return updatenewbookpublishyear;
	}

	public void setUpdatenewbookpublishyear(String updatenewbookpublishyear) {
		this.updatenewbookpublishyear = updatenewbookpublishyear;
	}

	public String getUpdatenewbookpublishmonth() {
		return updatenewbookpublishmonth;
	}

	public void setUpdatenewbookpublishmonth(String updatenewbookpublishmonth) {
		this.updatenewbookpublishmonth = updatenewbookpublishmonth;
	}

	public String getUpdatenewbookpublishday() {
		return updatenewbookpublishday;
	}

	public void setUpdatenewbookpublishday(String updatenewbookpublishday) {
		this.updatenewbookpublishday = updatenewbookpublishday;
	}

	public String getUpdatenewbookprice() {
		return updatenewbookprice;
	}

	public void setUpdatenewbookprice(String updatenewbookprice) {
		this.updatenewbookprice = updatenewbookprice;
	}

	public String execute() throws SQLException {
		SQLHelper sHelper = null;
		String bookauthorid = "";
		boolean logo = false;

		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return INPUT;
		}
		String sql = "select authorid from author where name='" + this.updatenewbookauthor + "'";
		ResultSet rs = null;

		try {
			rs = sHelper.getConnection().createStatement().executeQuery(sql);
			if (rs.next()) {
				bookauthorid = rs.getString("authorid");
			} else {
				logo = true;// 没有在数据库中找到author
			}
		} catch (SQLException ex) {
			return INPUT;
		}

		if (!logo)// 在数据库中找到author
		{
			try {
				sHelper = new SQLHelper();
			} catch (Exception e) {
				return INPUT;
			}

			String sqlreplace = "replace into book(isbn,title,authorid,publisher,publishdate,price) values('"
					+ this.updatenewbookisbn + "','" + this.updatenewbookname + "','" + bookauthorid + "','"
					+ this.updatenewbookpublisher + "','" + this.updatenewbookpublishyear + this.updatenewbookpublishmonth
					+ this.updatenewbookpublishday + "','" + this.updatenewbookprice + "')";
			try {
				sHelper.getConnection().createStatement().executeUpdate(sqlreplace);
				return SUCCESS;
			} catch (SQLException ex) {
				return INPUT;
			}

		} else// 没有在数据库中找到author
		{
			ActionContext.getContext().put("updatebookname", this.updatenewbookname);
			ActionContext.getContext().put("updatebookisbn", this.updatenewbookisbn);
			ActionContext.getContext().put("updatebookauthor", this.updatenewbookauthor);
			ActionContext.getContext().put("updatebookpublisher", this.updatenewbookpublisher);
			ActionContext.getContext().put("updatebookpublishyear", this.updatenewbookpublishyear);
			ActionContext.getContext().put("updatebookpublishmonth", this.updatenewbookpublishmonth);
			ActionContext.getContext().put("updatebookpublishday", this.updatenewbookpublishday);
			ActionContext.getContext().put("updatebookprice", this.updatenewbookprice);
			return ERROR;
		}

	}

}
