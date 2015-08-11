package model;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	
	private String stockName;
	private String stockType;
	private Double lastDividend;
	private Double fixedDividend;
	private Double parValue;
	private Double dividendYield;
	private Double per;

	public Stock(String name, String type, Double lastDividend,
			Double fixedDividend, Double parValue) {
		super();
		stockName = name;
		stockType = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.dividendYield = 0.0;
		this.per = 0.0;
	}
	
	public static List<Stock> initGBCE(){
		List<Stock> stocks = new ArrayList<Stock>();
		
		Stock tea = new Stock("TEA", "Common", 0.0, 0.0, 1.0);
		Stock pop = new Stock("POP", "Common", 0.08, 0.0, 1.0);
		Stock ale = new Stock("ALE", "Common", 0.23, 0.0, 0.6);
		Stock gin = new Stock("GIN", "Preferred", 0.08, 0.02, 1.0);
		Stock joe = new Stock("JOE", "Common", 0.13, 0.0, 2.5);
		
		stocks.add(tea);
		stocks.add(pop);
		stocks.add(ale);
		stocks.add(gin);
		stocks.add(joe);
		
		return stocks;
	}
	
	public Double calcDividendYield(Double marketPrice){
		Double dy;
		if(this.getStockType().equals("Preferred")){
			dy = (this.getFixedDividend()*this.getParValue())/marketPrice;
		} else {
			dy = (this.getLastDividend()/marketPrice);
		}
		this.setDividendYield(dy);
		return dy;
	}
	
	public Double calcPER(Double marketPrice){
		Double per;
		if(0.0!=this.getDividendYield()){
			per = marketPrice/this.getDividendYield();
		} else {
			per = 0.0;
		}
		this.setPer(per);
		return per;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public Double getLastDividend() {
		return lastDividend;
	}

	public void setLastDividend(Double lastDividend) {
		this.lastDividend = lastDividend;
	}

	public Double getFixedDividend() {
		return fixedDividend;
	}

	public void setFixedDividend(Double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}

	public Double getParValue() {
		return parValue;
	}

	public void setParValue(Double parValue) {
		this.parValue = parValue;
	}

	public Double getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(Double dividendYield) {
		this.dividendYield = dividendYield;
	}

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}
	
	
}
