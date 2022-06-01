package com.nsereader;

import com.nsereader.datafetcher.IDataFetcher;
import com.nsereader.dataparser.IDataParser;
import com.nsereader.exception.NseDataParsingException;
import com.nsereader.exception.NseResponseFailureException;
import com.nsereader.exception.NseTimeoutException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

class NseReaderImpl extends NseReader {

    private final IDataFetcher dataFetcher;
    private final IDataParser dataParser;
    private Map<String, String> stockData;
    private List<String> indexList;

    NseReaderImpl(NseReaderBuilderImpl builder) {
        this.dataFetcher = IDataFetcher.createDefault(builder.getDuration());
        this.dataParser = IDataParser.createDefault();
    }


    @Override
    public Map<String, String> getAllStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException, IOException {
        return null;
    }

    @Override
    public boolean isValidStockCode(String stockCode) {
        return false;
    }

    @Override
    public List<String> getAllIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException, IOException {
        return null;
    }

    @Override
    public boolean isValidIndex(String index) {
        return false;
    }

    @Override
    public List<String> getTopGainerStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException, IOException {
        return null;
    }

    @Override
    public List<String> getTopLoserStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException, IOException {
        return null;
    }
}
