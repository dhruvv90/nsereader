package com.nsereader;

import com.nsereader.datafetcher.IDataFetcher;
import com.nsereader.dataparser.IDataParser;
import com.nsereader.exception.NseDataParsingException;
import com.nsereader.exception.NseResponseFailureException;
import com.nsereader.exception.NseTimeoutException;

import java.io.IOException;
import java.io.InputStream;
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
    public Map<String, String> getAllStocks() throws NseDataParsingException, NseTimeoutException, NseResponseFailureException, IOException {
        if (this.stockData != null) {
            return this.stockData;
        }

        Map<String, String> result;
        try(InputStream stockDataStream = this.dataFetcher.getAllStocks()){
            result = this.dataParser.parseAllStocks(stockDataStream);
        }
        this.stockData = result;
        return result;
    }

    @Override
    public boolean isValidStockCode(String stockCode) {
        try {
            var stocksMap = this.getAllStocks();
            return stocksMap.containsKey(stockCode.toUpperCase());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<String> getAllIndices() throws NseDataParsingException, NseTimeoutException, NseResponseFailureException, IOException {
        if (this.indexList != null) {
            return this.indexList;
        }

        List<String> result;
        try(InputStream indicesDataStream = this.dataFetcher.getAllIndices()){
            result = this.dataParser.parseAllIndices(indicesDataStream);
        }
        this.indexList = result;
        return result;
    }

    @Override
    public boolean isValidIndex(String index) {
        try {
            var indicesMap = this.getAllIndices();
            return indicesMap.contains(index.toUpperCase());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<String> getTopGainerStocks() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException, IOException {
        List<String> result;
        try(InputStream stream = this.dataFetcher.getTopGainerStocks()){
            result = this.dataParser.parseTopStockGainers(stream);
        }
        return result;
    }
}
