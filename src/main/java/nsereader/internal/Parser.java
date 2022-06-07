package nsereader.internal;

import nsereader.exception.NseDataParsingException;
import nsereader.model.*;

import java.io.InputStream;
import java.util.List;

class Parser {

    private final CsvParser csvParser;
    private final JsonParser jsonParser;
    private final HtmlParser htmlParser;

    Parser() {
        this.csvParser = new CsvParser();
        this.jsonParser = new JsonParser();
        this.htmlParser = new HtmlParser();
    }

    List<Stock> parseAllStocks(InputStream iStream) throws NseDataParsingException{
        return this.csvParser.parseAllStocks(iStream);
    }

    List<Index> parseAllIndices(InputStream iStream) throws NseDataParsingException {
        return this.jsonParser.parseAllIndices(iStream);
    }

    List<GainerLoserStats> parseTopGainers(InputStream iStream) throws NseDataParsingException {
        return this.jsonParser.parseTopGainers(iStream);
    }

    List<GainerLoserStats> parseTopLosers(InputStream iStream) throws NseDataParsingException {
        return this.jsonParser.parseTopLosers(iStream);
    }

    List<AdvanceDeclineStats> parseAdvancesDeclines(InputStream iStream) throws NseDataParsingException {
        return this.jsonParser.parseAdvancesDeclines(iStream);
    }

    StockQuote parseStockQuote(InputStream iStream) throws NseDataParsingException {
        String responseBlock = this.htmlParser.parseStockQuote(iStream);
        StockQuote quote = this.jsonParser.parseStockQuote(responseBlock);

        return quote;
    }
}
