package model;

import java.util.Date;

public class Trade {
	private Date tradeDate;
	private Integer qtyOfShares;
	private Boolean buyIndicator;
	private Double tradePrice;
	
	public Trade(Date tradeDate, Integer qtyOfShares, Boolean buyIndicator,
			Double tradePrice) {
		super();
		this.tradeDate = tradeDate;
		this.qtyOfShares = qtyOfShares;
		this.buyIndicator = buyIndicator;
		this.tradePrice = tradePrice;
	}

	public Date getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}

	public Integer getQtyOfShares() {
		return qtyOfShares;
	}

	public void setQtyOfShares(Integer qtyOfShares) {
		this.qtyOfShares = qtyOfShares;
	}

	public Boolean getBuyIndicator() {
		return buyIndicator;
	}

	public void setBuyIndicator(Boolean buyIndicator) {
		this.buyIndicator = buyIndicator;
	}

	public Double getTradePrice() {
		return tradePrice;
	}

	public void setTradePrice(Double tradePrice) {
		this.tradePrice = tradePrice;
	}
}
