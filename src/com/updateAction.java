package com;

import com.SQLHelper;

import java.sql.Date;
import java.awt.print.Printable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class updateAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String updatebookname;

	public String getUpdatebookname() {
		return updatebookname;
	}

	public void setUpdatebookname(String updatebookname) {
		this.updatebookname = updatebookname;
	}

	public String execute() throws Exception {
		SQLHelper sHelper = null;
		// 新建连接
		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}
		String sql = "select name from author where authorid= ( select authorid from book where title='"
				+ this.updatebookname + "')";
		ResultSet rs = null;
        String updatebookauthor="";
        String updatebookpublisher="";
        String updatebookisbn="";
        double updatebookprice;
        Date newpublishdate;
		// 获得检索结果并返回结果字符串
		try {
			rs = sHelper.getConnection().createStatement().executeQuery(sql);
			if (rs.next()) {
                 updatebookauthor=rs.getString("name");
			}
			else return INPUT;
		} catch (SQLException ex) {
			return ERROR;
		}
		
		// 新建连接
		try {
			sHelper = new SQLHelper();
		} catch (Exception e) {
			return ERROR;
		}
		String sqlbook = "select * from book where title='" + this.updatebookname
				+ "'";
		// 获得检索结果并返回结果字符串
		try {
			rs = sHelper.getConnection().createStatement().executeQuery(sqlbook);
			if(rs.next()) {
				updatebookisbn=rs.getString("isbn");
				updatebookprice=rs.getDouble("price");
				updatebookpublisher=rs.getString("publisher");
			    newpublishdate=rs.getDate("publishdate");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String updatebookpublishdate = sdf.format(newpublishdate);
				ActionContext.getContext().put("updatenewbookname", this.updatebookname);
				ActionContext.getContext().put("updatenewbookisbn", updatebookisbn);
				ActionContext.getContext().put("updatenewbookauthor", updatebookauthor);
				ActionContext.getContext().put("updatenewbookpublisher", updatebookpublisher);
				ActionContext.getContext().put("updatenewbookprice", updatebookprice);
				ActionContext.getContext().put("updatenewbookpublishyear", updatebookpublishdate.substring(0,4));
				ActionContext.getContext().put("updatenewbookpublishmonth", updatebookpublishdate.substring(5,7));
				ActionContext.getContext().put("updatenewbookpublishday", updatebookpublishdate.substring(8,10));
			}
			return SUCCESS;
		} catch (SQLException ex) {
			return ERROR;
		}

		
	}

}
