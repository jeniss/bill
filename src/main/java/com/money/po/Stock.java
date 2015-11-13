package com.money.po;

import java.util.Date;

/**
 * Created by jennifert on 2015/11/12.
 */
public class Stock {
	private Integer id;
	private Integer userId;
	private String code;//stock code
	private String name;//stock name
	private Date entryDatetime;
	private Date updateDatetime;
	private String soldAll;//the flag of is soldAll; Y--Yes; N--No
	private Double profit;//when the stock is sold totally, accumulate the profit of stock
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEntryDatetime() {
		return entryDatetime;
	}

	public void setEntryDatetime(Date entryDatetime) {
		this.entryDatetime = entryDatetime;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	public String getSoldAll() {
		return soldAll;
	}

	public void setSoldAll(String soldAll) {
		this.soldAll = soldAll;
	}

	public Double getProfit() {
		return profit;
	}

	public void setProfit(Double profit) {
		this.profit = profit;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
