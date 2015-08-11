package app;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import model.Stock;
import model.Trade;

public class StocksApp {

	public static void main(String[] args) {
	//Print a table with the values of GBCE Stocks
		List<Stock> stocks = new ArrayList<Stock>();
		stocks = Stock.initGBCE();
		System.out.println("GBCE Stocks: \n"+"Stock\t | Type\t\t | Last Div\t | Fixed Div\t | PAR Val");
		for(Stock s : stocks){
			System.out.println(s.getStockName()+"\t | "+s.getStockType()+"\t | "+Math.round(s.getLastDividend()*100)+"\t\t | "+Math.round(s.getFixedDividend()*100)+"\t\t | "+Math.round(s.getParValue()*100));
		}
	//Start creatint 5 trades
		Calendar cr1 = Calendar.getInstance();
		Calendar cr2 = Calendar.getInstance();
		Calendar cr3 = Calendar.getInstance();
		Calendar cr4 = Calendar.getInstance();
		Calendar cr5 = Calendar.getInstance();
		
		List<Calendar> fechas = new ArrayList<Calendar>();
		fechas.add(cr1);
		fechas.add(cr2);
		fechas.add(cr3);
		fechas.add(cr4);
		fechas.add(cr5);
		
		for(Calendar c : fechas){
			c.setTime(new Date());
			c.add(Calendar.MINUTE, (new Random().nextInt(25))*-1);
		}
		
		Trade tr1 = new Trade(fechas.get(0).getTime(), 3, true, 2.3);
		Trade tr2 = new Trade(fechas.get(1).getTime(), 2, false, 2.2);
		Trade tr3 = new Trade(fechas.get(2).getTime(), 4, true, 1.98);
		Trade tr4 = new Trade(fechas.get(3).getTime(), 6, false, 2.1);
		Trade tr5 = new Trade(fechas.get(4).getTime(), 3, true, 2.2);
	//Finish creating 5 shares
	//Creating list with 5 trades
		List<Trade> trades = new ArrayList<Trade>();
		trades.add(tr1);
		trades.add(tr2);
		trades.add(tr3);
		trades.add(tr4);
		trades.add(tr5);
	//Variables necesaries for calculating VWAP	
		Integer totalShares = 0;
		Double sharesCalc = 0.0;
		Double VWSP;
	//printing ALL THE TRADES	
		System.out.println("\n TRADES: \n"+"Date\t\t\t\t | Shares\t | Buy?\t | Price");
		Calendar currentCal = Calendar.getInstance();
		for(Trade t : trades){
			
			System.out.println(t.getTradeDate().toString()+"\t | "+t.getQtyOfShares()+"\t\t | "+t.getBuyIndicator()+"\t | "+t.getTradePrice()+"\n");
		}
	//printing ONLY THE TRADES with Trade Date in past 15 minutes and with buy indicator=true.
	//The objective is calculating VWSP
		System.out.println("\n TRADES(15MINS): \n"+"Date\t\t\t\t | Shares\t | Buy?\t | Price");
		for(Trade t : trades){
			Calendar c = Calendar.getInstance();
			c.setTime(t.getTradeDate());
			long mins = (currentCal.getTimeInMillis()-c.getTimeInMillis())/1000/60;
			
			if(mins<15){
				System.out.println(t.getTradeDate().toString()+"\t | "+t.getQtyOfShares()+"\t\t | "+t.getBuyIndicator()+"\t | "+t.getTradePrice()+"\n");
				
				if(t.getBuyIndicator()){
					sharesCalc = sharesCalc + (t.getQtyOfShares()*t.getTradePrice());
					totalShares = totalShares + t.getQtyOfShares();
				}
			}
		}
	//Volume Weighted Stock Price
		VWSP = sharesCalc / totalShares;
		
		System.out.println("VWSP = " + VWSP);
		
		
		
	}

}
