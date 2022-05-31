package com.nsereader.datafetcher;


import com.nsereader.exception.NseDataParsingException;
import com.nsereader.exception.NseResponseFailureException;
import com.nsereader.exception.NseTimeoutException;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public interface IDataFetcher {
    String ALL_STOCKS = "http://www1.nseindia.com/content/equities/EQUITY_L.csv";
    String ALL_INDICES = "http://www1.nseindia.com/homepage/Indices1.json";

    Duration DEFAULT_DURATION = Duration.ofSeconds(10);

    static IDataFetcher createDefault(Duration duration) {
        if (duration == null) {
            return new DataFetcherImpl(DEFAULT_DURATION);

        }
        return new DataFetcherImpl(duration);
    }

    InputStream getAllStocks() throws NseResponseFailureException, NseTimeoutException;

    InputStream getAllIndices() throws NseResponseFailureException, NseTimeoutException;
}

