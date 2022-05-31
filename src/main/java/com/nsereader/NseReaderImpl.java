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
        InputStream stockDataStream = this.dataFetcher.getAllStocks();
        var result = this.dataParser.parseAllStocks(stockDataStream);
        stockDataStream.close();

        this.stockData = result;
        return this.stockData;
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
        var indicesDataStream = this.dataFetcher.getAllIndices();
        var result = this.dataParser.parseAllIndices(indicesDataStream);
        indicesDataStream.close();

        this.indexList = result;
        return this.indexList;
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
}
