package com.nsereader.datafetcher;


import com.nsereader.exception.NseResponseFailureException;
import com.nsereader.exception.NseTimeoutException;

import java.io.InputStream;
import java.time.Duration;

public interface IDataFetcher {

    static IDataFetcher createDefault(Duration duration) {
        return new DataFetcherImpl(duration);
    }

    InputStream getAllStocks() throws NseResponseFailureException, NseTimeoutException;

    InputStream getAllIndices() throws NseResponseFailureException, NseTimeoutException;
}

class UrlRepository {
    static final String ALL_STOCKS = "http://www1.nseindia.com/content/equities/EQUITY_L.csv";
    static final String ALL_INDICES = "http://www1.nseindia.com/homepage/Indices1.json";
}

