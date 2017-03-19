package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Stocks database table.
 * 
 */
@Entity
@Table(name="Stocks")
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int stockID;

	private double sBuyPrice;

	private double sClosePrice;

	private double sDayHigh;

	private double sDayLow;

	private double sLimitDown;

	private double sLimitUp;

	private String sName;

	private double sSellPrice;

	private int sVolume;

	public Stock() {
	}

	public int getStockID() {
		return this.stockID;
	}

	public void setStockID(int stockID) {
		this.stockID = stockID;
	}

	public double getSBuyPrice() {
		return this.sBuyPrice;
	}

	public void setSBuyPrice(double sBuyPrice) {
		this.sBuyPrice = sBuyPrice;
	}

	public double getSClosePrice() {
		return this.sClosePrice;
	}

	public void setSClosePrice(double sClosePrice) {
		this.sClosePrice = sClosePrice;
	}

	public double getSDayHigh() {
		return this.sDayHigh;
	}

	public void setSDayHigh(double sDayHigh) {
		this.sDayHigh = sDayHigh;
	}

	public double getSDayLow() {
		return this.sDayLow;
	}

	public void setSDayLow(double sDayLow) {
		this.sDayLow = sDayLow;
	}

	public double getSLimitDown() {
		return this.sLimitDown;
	}

	public void setSLimitDown(double sLimitDown) {
		this.sLimitDown = sLimitDown;
	}

	public double getSLimitUp() {
		return this.sLimitUp;
	}

	public void setSLimitUp(double sLimitUp) {
		this.sLimitUp = sLimitUp;
	}

	public String getSName() {
		return this.sName;
	}

	public void setSName(String sName) {
		this.sName = sName;
	}

	public double getSSellPrice() {
		return this.sSellPrice;
	}

	public void setSSellPrice(double sSellPrice) {
		this.sSellPrice = sSellPrice;
	}

	public int getSVolume() {
		return this.sVolume;
	}

	public void setSVolume(int sVolume) {
		this.sVolume = sVolume;
	}

}