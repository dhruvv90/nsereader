package com.nsereader.dataparser;

import com.nsereader.exception.NseDataParsingException;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface IDataParser {

    String CSV_DELIMITER = ",";

    static IDataParser createDefault() {
        return null;
    }

    Map<String, String> parseAllStocks(InputStream data) throws NseDataParsingException, IOException;

    List<String> parseAllIndices(InputStream data) throws NseDataParsingException, IOException;

    List<String> parseTopStockGainers(InputStream data) throws NseDataParsingException, IOException;

    List<String> parseTopLoserStocks(InputStream stream) throws  NseDataParsingException, IOException;
}

