package com;

import com.SQLHelper;

import java.awt.print.Printable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class updateAuthorAction  extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String updatebookname;
	private String updatebookisbn;
	private String updatebookpublisher;
	private String updatebookpublishyear;
	private String updatebookpublishmonth;
	private String updatebookpublishday;
	private String updatebookprice;
	private String updatebookauthor;
	private String updateauthorid;
	private String updateage;
	private String updatecountry;
	public String getUpdatebookname() {
		return updatebookname;
	}
	public void setUpdatebookname(String updatebookname) {
		this.updatebookname = updatebookname;
	}
	public String getUpdatebookisbn() {
		return updatebookisbn;
	}
	public void setUpdatebookisbn(String updatebookisbn) {
		this.updatebookisbn = updatebookisbn;
	}
	public String getUpdatebookpublisher() {
		return updatebookpublisher;
	}
	public void setUpdatebookpublisher(String updatebookpublisher) {
		this.updatebookpublisher = updatebookpublisher;
	}
	public String getUpdatebookpublishyear() {
		return updatebookpublishyear;
	}
	public void setUpdatebookpublishyear(String updatebookpublishyear) {
		this.updatebookpublishyear = updatebookpublishyear;
	}
	public String getUpdatebookpublishmonth() {
		return updatebookpublishmonth;
	}
	public void setUpdatebookpublishmonth(String updatebookpublishmonth) {
		this.updatebookpublishmonth = updatebookpublishmonth;
	}
	public String getUpdatebookpublishday() {
		return updatebookpublishday;
	}
	public void setUpdatebookpublishday(String updatebookpublishday) {
		this.updatebookpublishday = updatebookpublishday;
	}
	public String getUpdatebookprice() {
		return updatebookprice;
	}
	public void setUpdatebookprice(String updatebookprice) {
		this.updatebookprice = updatebookprice;
	}
	public String getUpdatebookauthor() {
		return updatebookauthor;
	}
	public void setUpdatebookauthor(String updatebookauthor) {
		this.updatebookauthor = updatebookauthor;
	}
	public String getUpdateauthorid() {
		return updateauthorid;
	}
	public void setUpdateauthorid(String updateauthorid) {
		this.updateauthorid = updateauthorid;
	}
	public String getUpdateage() {
		return updateage;
	}
	public void setUpdateage(String updateage) {
		this.updateage = updateage;
	}
	public String getUpdatecountry() {
		return updatecountry;
	}
	public void setUpdatecountry(String updatecountry) {
		this.updatecountry = updatecountry;
	}

	public String execute() throws Exception {
		SQLHelper sHelper = null;
		// 新建连接
		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}
		String sql = "insert into author values('" + this.updateauthorid + "'" + ",'"
				+ this.updatebookauthor + "'" + ",'" + this.updateage + "'" + ",'"
				+ this.updatecountry + "')";
		String sql2="delete from book where isbn='"+this.updatebookisbn+"'";
		String sql3="Insert into book values('" + this.updatebookisbn + "'" +",'"
				+ this.updatebookname + "'" +",'"
				+ this.updatebookpublisher + "'" +",'"
				+ this.updatebookpublishyear+ this.updatebookpublishmonth+ this.updatebookpublishday + "'" + ",'"
						+ this.updatebookprice + "'" + ",'"
								+ this.updateauthorid + "')";
		// 获得检索结果并返回结果字符串
		try {
			sHelper.getConnection().createStatement().executeUpdate(sql);
			sHelper.getConnection().createStatement().executeUpdate(sql2);
			sHelper.getConnection().createStatement().executeUpdate(sql3);
			return SUCCESS;
		} catch (SQLException ex) {
			return INPUT;
		}

	}
}
