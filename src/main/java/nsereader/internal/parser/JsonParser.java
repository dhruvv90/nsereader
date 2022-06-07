package nsereader.internal.parser;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import nsereader.exception.NseDataParsingException;
import nsereader.model.AdvanceDeclineStats;
import nsereader.model.GainerLoserStats;
import nsereader.model.Index;
import nsereader.model.StockQuote;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

class JsonParser {

    private final ObjectMapper mapper;

    JsonParser() {
        this.mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Long.class, new NumberDeserializer<>(Long.class));
        module.addDeserializer(Integer.class, new NumberDeserializer<>(Integer.class));
        module.addDeserializer(Double.class, new NumberDeserializer<>(Double.class));
        module.addDeserializer(Float.class, new NumberDeserializer<>(Float.class));
        module.addDeserializer(Short.class, new NumberDeserializer<>(Short.class));
        module.addDeserializer(BigDecimal.class, new NumberDeserializer<>(BigDecimal.class));
        module.addDeserializer(BigInteger.class, new NumberDeserializer<>(BigInteger.class));
        module.addDeserializer(String.class, new StringDeserializer(String.class));
        module.addDeserializer(Date.class, new DateSerializer(Date.class));

        mapper.registerModule(module);
    }

    List<Index> parseAllIndices(InputStream iStream) throws NseDataParsingException {
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

    List<GainerLoserStats> parseTop(InputStream iStream) throws NseDataParsingException {
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

    List<GainerLoserStats> parseTopGainers(InputStream iStream) throws NseDataParsingException {
        return parseTop(iStream);
    }

    List<GainerLoserStats> parseTopLosers(InputStream iStream) throws NseDataParsingException {
        return parseTop(iStream);
    }

    List<AdvanceDeclineStats> parseAdvancesDeclines(InputStream iStream) throws NseDataParsingException {
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

    StockQuote parseStockQuote(String responseBlock) throws NseDataParsingException {
        StockQuote quote;
        {
            try {
                JsonNode node = mapper.readTree(responseBlock).get("data").get(0);
                quote = mapper.treeToValue(node, StockQuote.class);
                if (quote == null) {
                    throw new NseDataParsingException("Received Empty Quote data from NSE");
                }
            } catch (IOException e) {
                throw new NseDataParsingException(e);
            }
        }
        return quote;
    }
}

class NumberDeserializer<T extends Number> extends StdDeserializer<T> {

    private final HashMap<Class<? extends Number>, Function<String, ? extends Number>> fnMap;
    private final Class<? extends Number> clazz;

    NumberDeserializer(Class<? extends Number> x) {
        super(x);
        this.clazz = x; // Needed for Runtime information
        this.fnMap = new HashMap<>();

        fnMap.put(Long.class, Long::valueOf);
        fnMap.put(Integer.class, Integer::valueOf);
        fnMap.put(Double.class, Double::valueOf);
        fnMap.put(Float.class, Float::valueOf);
        fnMap.put(Short.class, Short::valueOf);
        fnMap.put(BigDecimal.class, BigDecimal::new);
        fnMap.put(BigInteger.class, BigInteger::new);
    }

    private T fromString(String s) throws IOException {
        Function<String, ? extends Number> fn = fnMap.get(this.clazz);
        if (fn == null) {
            throw new IOException("No Parser defined for type: " + this.clazz.getName());
        }
        // Cast Safe due to above null check
        //noinspection unchecked
        return (T) fn.apply(s);
    }

    @Override
    public T deserialize(com.fasterxml.jackson.core.JsonParser p, DeserializationContext ctxt) throws IOException {

        String s = p.getText();
        if (s.equals("-")) {
            return null;
        }
        if (s.contains(",")) {
            s = s.replace(",", "");
        }
        return fromString(s);
    }
}


class StringDeserializer extends StdDeserializer<String> {

    protected StringDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public String deserialize(com.fasterxml.jackson.core.JsonParser p, DeserializationContext ctxt) throws IOException {
        String s = p.getText();
        if (s.equals("-")) {
            return null;
        }
        return s;
    }
}

class DateSerializer extends StdDeserializer<Date> {

    protected DateSerializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(com.fasterxml.jackson.core.JsonParser p, DeserializationContext ctxt) throws IOException {
        String s = p.getText();
        if (s.equals("-")) {
            return null;
        }
        try {
            return new SimpleDateFormat("dd-MMM-yyyy").parse(s);
        } catch (ParseException e) {
            throw new IOException(e);
        }
    }
}
