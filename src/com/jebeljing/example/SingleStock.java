package com.jebeljing.example;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;

/**
 * Created by jingshanyin on 10/13/16.
 */
public class SingleStock {

    public static void main(String... args) throws IOException {
        Stock stock = null;
        stock = YahooFinance.get("AAPL");


        BigDecimal price = stock.getQuote().getPrice();
        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();


        /**
         * This will also automatically refresh the statistics and dividend data of the stock
         * in a single request to Yahoo Finance. Please be aware that it wouldn't be a good
         * idea to call the getQuote(true), getStats(true) or getDividend(true) too much
         * in a short timespan as this will cost too much delay without providing any added value.
         * There's no problem to call the versions of those methods without argument
         * or with the argument set to false.
         */
        BigDecimal refreshPrice = stock.getQuote(true).getPrice();
        System.out.println(refreshPrice);


        /**
         * Single Stock - Include Historical Quotes
         */
        Stock dnr = YahooFinance.get("DNR", true);
        System.out.println(dnr.getHistory());
        dnr.print();

        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.add(Calendar.YEAR, -5);
        Stock apple = YahooFinance.get("AAPL", from, to, Interval.WEEKLY);
        apple.print();
    }
}
