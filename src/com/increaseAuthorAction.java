package com;

import com.SQLHelper;

import java.awt.print.Printable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class increaseAuthorAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String increasebookname;
	private String increasebookisbn;
	private String increasebookpublisher;
	private String increasebookpublishyear;
	private String increasebookpublishmonth;
	private String increasebookpublishday;
	private String increasebookprice;
	private String increasebookauthor;
	private String increaseauthorid;
	private String increaseage;
	private String increasecountry;

	

	

	public String getIncreasebookname() {
		return increasebookname;
	}





	public void setIncreasebookname(String increasebookname) {
		this.increasebookname = increasebookname;
	}





	public String getIncreasebookisbn() {
		return increasebookisbn;
	}





	public void setIncreasebookisbn(String increasebookisbn) {
		this.increasebookisbn = increasebookisbn;
	}





	public String getIncreasebookpublisher() {
		return increasebookpublisher;
	}





	public void setIncreasebookpublisher(String increasebookpublisher) {
		this.increasebookpublisher = increasebookpublisher;
	}





	public String getIncreasebookpublishyear() {
		return increasebookpublishyear;
	}





	public void setIncreasebookpublishyear(String increasebookpublishyear) {
		this.increasebookpublishyear = increasebookpublishyear;
	}





	public String getIncreasebookpublishmonth() {
		return increasebookpublishmonth;
	}





	public void setIncreasebookpublishmonth(String increasebookpublishmonth) {
		this.increasebookpublishmonth = increasebookpublishmonth;
	}





	public String getIncreasebookpublishday() {
		return increasebookpublishday;
	}





	public void setIncreasebookpublishday(String increasebookpublishday) {
		this.increasebookpublishday = increasebookpublishday;
	}





	public String getIncreasebookprice() {
		return increasebookprice;
	}





	public void setIncreasebookprice(String increasebookprice) {
		this.increasebookprice = increasebookprice;
	}





	public String getIncreasebookauthor() {
		return increasebookauthor;
	}





	public void setIncreasebookauthor(String increasebookauthor) {
		this.increasebookauthor = increasebookauthor;
	}





	public String getIncreaseauthorid() {
		return increaseauthorid;
	}





	public void setIncreaseauthorid(String increaseauthorid) {
		this.increaseauthorid = increaseauthorid;
	}





	public String getIncreaseage() {
		return increaseage;
	}





	public void setIncreaseage(String increaseage) {
		this.increaseage = increaseage;
	}





	public String getIncreasecountry() {
		return increasecountry;
	}





	public void setIncreasecountry(String increasecountry) {
		this.increasecountry = increasecountry;
	}





	public String execute() throws Exception {
		SQLHelper sHelper = null;
		// 新建连接
		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}
		String sql = "insert into author values('" + this.increaseauthorid + "'" + ",'"
				+ this.increasebookauthor + "'" + ",'" + this.increaseage + "'" + ",'"
				+ this.increasecountry + "')";
		String sql2="Insert into book values('" + this.increasebookisbn + "'" +",'"
				+ this.increasebookname + "'" +",'"
				+ this.increasebookpublisher + "'" +",'"
				+ this.increasebookpublishyear+ this.increasebookpublishmonth+ this.increasebookpublishday + "'" + ",'"
						+ this.increasebookprice + "'" + ",'"
								+ this.increaseauthorid + "')";
		// 获得检索结果并返回结果字符串
		try {
			sHelper.getConnection().createStatement().executeUpdate(sql);
			sHelper.getConnection().createStatement().executeUpdate(sql2);
			return SUCCESS;
		} catch (SQLException ex) {
			return INPUT;
		}

	}

}