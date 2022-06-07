package nsereader.internal.parser;

import nsereader.exception.NseDataParsingException;
import nsereader.model.*;

import java.io.InputStream;
import java.util.List;

public class Parser {

    private final CsvParser csvParser;
    private final JsonParser jsonParser;
    private final HtmlParser htmlParser;

    public Parser() {
        this.csvParser = new CsvParser();
        this.jsonParser = new JsonParser();
        this.htmlParser = new HtmlParser();
    }

    public List<Stock> parseAllStocks(InputStream iStream) throws NseDataParsingException{
        return this.csvParser.parseAllStocks(iStream);
    }

    public List<Index> parseAllIndices(InputStream iStream) throws NseDataParsingException {
        return this.jsonParser.parseAllIndices(iStream);
    }

    public List<GainerLoserStats> parseTopGainers(InputStream iStream) throws NseDataParsingException {
        return this.jsonParser.parseTopGainers(iStream);
    }

    public List<GainerLoserStats> parseTopLosers(InputStream iStream) throws NseDataParsingException {
        return this.jsonParser.parseTopLosers(iStream);
    }

    public List<AdvanceDeclineStats> parseAdvancesDeclines(InputStream iStream) throws NseDataParsingException {
        return this.jsonParser.parseAdvancesDeclines(iStream);
    }

    public StockQuote parseStockQuote(InputStream iStream) throws NseDataParsingException {
        String responseBlock = this.htmlParser.parseStockQuote(iStream);
        StockQuote quote = this.jsonParser.parseStockQuote(responseBlock);

        return quote;
    }
}
