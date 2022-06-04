package nsereader.parser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import nsereader.exception.NseDataParsingException;
import nsereader.model.Index;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class JsonParserImpl implements IJsonParser {
    private static JsonParserImpl instance;

    private JsonParserImpl() {
    }

    static JsonParserImpl getInstance() {
        if (instance == null) {
            instance = new JsonParserImpl();
        }
        return instance;
    }

    @Override
    public List<Index> parseAllIndices(InputStream iStream) throws NseDataParsingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Index> indexList = new ArrayList<>();

        JsonFactory jsonFactory = new JsonFactory();
        try (JsonParser parser = jsonFactory.createParser(iStream)) {
            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();
                if (JsonToken.FIELD_NAME.equals(token) && parser.getCurrentName().equals("data")) {
                    if (parser.nextToken() != JsonToken.START_ARRAY) {
                        throw new NseDataParsingException();
                    }

                    while (parser.nextToken() != JsonToken.END_ARRAY) {
                        Index idx = mapper.readValue(parser, Index.class);
                        indexList.add(idx);
                    }
                    if (indexList.isEmpty()) {
                        throw new NseDataParsingException("Empty data from NSE");
                    }
                    break;
                }
            }
        } catch (IOException e) {
            throw new NseDataParsingException(e);
        }
        return indexList;
    }
}


