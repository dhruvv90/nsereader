package com.nsereader.datafetcher;


import com.nsereader.exception.NseResponseFailureException;
import com.nsereader.exception.NseTimeoutException;

import java.io.InputStream;
import java.time.Duration;

public interface IDataFetcher {

    static IDataFetcher createDefault(Duration duration) {
        return null;
    }

    InputStream getAllStocks() throws NseResponseFailureException, NseTimeoutException;

    InputStream getAllIndices() throws NseResponseFailureException, NseTimeoutException;

    InputStream getTopGainerStocks() throws NseResponseFailureException, NseTimeoutException;

    InputStream getTopLoserStocks() throws NseResponseFailureException, NseTimeoutException;
}

class UrlRepository {
    static final String ROOT_URL = "http://www1.nseindia.com";
    static final String ALL_STOCKS = ROOT_URL + "/content/equities/EQUITY_L.csv";
    static final String ALL_INDICES = ROOT_URL + "/homepage/Indices1.json";

    static final String TOP_GAINER_STOCKS = ROOT_URL + "/live_market/dynaContent/live_analysis/gainers/niftyGainers1.json";
    static final String TOP_LOSER_STOCKS = ROOT_URL + "/live_market/dynaContent/live_analysis/losers/niftyLosers1.json";
}

