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

    NseReaderImpl(NseReaderBuilderImpl builder) {
        this.dataFetcher = IDataFetcher.createDefault(builder.getDuration());
        this.dataParser = IDataParser.createDefault();
    }

    @Override
    public Map<String, String> getAllStocks() throws NseDataParsingException, NseTimeoutException, NseResponseFailureException, IOException {
        InputStream stockDataStream = this.dataFetcher.getAllStocks();
        var result = this.dataParser.parseAllStocks(stockDataStream);

        stockDataStream.close();
        return result;
    }

    @Override
    public List<String> getAllIndices() throws NseDataParsingException, NseTimeoutException, NseResponseFailureException, IOException {
        var indicesDataStream = this.dataFetcher.getAllIndices();
        var result = this.dataParser.parseAllIndices(indicesDataStream);

        indicesDataStream.close();
        return result;
    }
}
