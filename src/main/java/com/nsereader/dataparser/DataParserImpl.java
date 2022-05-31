package com.nsereader.dataparser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.nsereader.exception.NseDataParsingException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DataParserImpl implements IDataParser {

    @Override
    public Map<String, String> parseAllStocks(InputStream data) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(data));
        Map<String, String> result = new HashMap<>();

        while (true) {
            String row = reader.readLine();
            if (row == null)
                break;

            String[] fragments = row.split(CSV_DELIMITER);
            if (fragments[0].equalsIgnoreCase("symbol")) {
                continue;
            }
            result.put(fragments[0], fragments[1]);
        }
        return result;
    }

    @Override
    public List<String> parseAllIndices(InputStream data) throws NseDataParsingException, IOException {
        List<String> result = new ArrayList<>();

        JsonFactory jsonFactory = new JsonFactory();
        JsonParser parser = jsonFactory.createParser(data);
        while (!parser.isClosed()) {
            JsonToken token = parser.nextToken();
            if (JsonToken.FIELD_NAME.equals(token) && parser.getCurrentName().equals("data")) {
                if (parser.nextToken() != JsonToken.START_ARRAY) {
                    throw new NseDataParsingException();
                }
                while (parser.nextToken() != JsonToken.END_ARRAY) {
                    if (JsonToken.FIELD_NAME.equals(parser.getCurrentToken())
                            && parser.getCurrentName().equals("name")) {
                        parser.nextToken();
                        result.add(parser.getValueAsString());
                    }
                }
                break;
            }
        }
        return result;
    }
}
