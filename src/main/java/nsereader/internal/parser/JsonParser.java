package nsereader.internal.parser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import nsereader.exception.NseDataParsingException;
import nsereader.model.AdvanceDeclineStats;
import nsereader.model.GainerLoserStats;
import nsereader.model.Index;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    private JsonParser() {

    }

    public static List<Index> parseAllIndices(InputStream iStream) throws NseDataParsingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Index> indexList = new ArrayList<>();

        JsonFactory jsonFactory = new JsonFactory();
        try (com.fasterxml.jackson.core.JsonParser parser = jsonFactory.createParser(iStream)) {
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

    private static List<GainerLoserStats> parseTop(InputStream iStream) throws NseDataParsingException {
        ObjectMapper mapper = new ObjectMapper();
        List<GainerLoserStats> stats = new ArrayList<>();

        JsonFactory jsonFactory = new JsonFactory();
        try (com.fasterxml.jackson.core.JsonParser parser = jsonFactory.createParser(iStream)) {
            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();
                if (JsonToken.FIELD_NAME.equals(token) && parser.getCurrentName().equals("data")) {
                    if (parser.nextToken() != JsonToken.START_ARRAY) {
                        throw new NseDataParsingException();
                    }

                    while (parser.nextToken() != JsonToken.END_ARRAY) {
                        GainerLoserStats stat = mapper.readValue(parser, GainerLoserStats.class);
                        stats.add(stat);
                    }
                    if (stats.isEmpty()) {
                        throw new NseDataParsingException("Empty data from NSE");
                    }
                    break;
                }
            }
        } catch (IOException e) {
            throw new NseDataParsingException(e);
        }
        return stats;
    }

    public static List<GainerLoserStats> parseTopGainers(InputStream iStream) throws NseDataParsingException {
        return parseTop(iStream);
    }

    public static List<GainerLoserStats> parseTopLosers(InputStream iStream) throws NseDataParsingException {
        return parseTop(iStream);
    }

    public static List<AdvanceDeclineStats> parseAdvancesDeclines(InputStream iStream) throws NseDataParsingException {
        ObjectMapper mapper = new ObjectMapper();
        List<AdvanceDeclineStats> stats = new ArrayList<>();

        JsonFactory jsonFactory = new JsonFactory();
        try (com.fasterxml.jackson.core.JsonParser parser = jsonFactory.createParser(iStream)) {
            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();
                if (JsonToken.FIELD_NAME.equals(token) && parser.getCurrentName().equals("data")) {
                    if (parser.nextToken() != JsonToken.START_ARRAY) {
                        throw new NseDataParsingException();
                    }

                    while (parser.nextToken() != JsonToken.END_ARRAY) {
                        AdvanceDeclineStats stat = mapper.readValue(parser, AdvanceDeclineStats.class);
                        stats.add(stat);
                    }
                    if (stats.isEmpty()) {
                        throw new NseDataParsingException("Empty data from NSE");
                    }
                    break;
                }
            }
        } catch (IOException e) {
            throw new NseDataParsingException(e);
        }
        return stats;
    }
}
