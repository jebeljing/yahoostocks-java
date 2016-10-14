package com.jebeljing.example;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.Map;

/**
 * Created by jingshanyin on 10/13/16.
 */
public class MultipleStocks {

    public static void main(String... args) throws IOException {

        String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
        Map<String, Stock> stocks = YahooFinance.get(symbols); // single request
        Stock intel = stocks.get("INTC");
        Stock airbus = stocks.get("AIR.PA");
        intel.print();

        airbus.print();


        // Can also be done with explicit from, to and Interval parameters
        Map<String, Stock> stocks2 = YahooFinance.get(symbols, true);
        Stock intel2 = stocks2.get("INTC");
        Stock airbus2 = stocks2.get("AIR.PA");

    }
}
