package nsereader.parser;

import nsereader.exception.NseDataException;
import nsereader.model.*;

import java.io.InputStream;
import java.util.List;

public class Parser {

    private CsvParser csvParser;
    private JsonParser jsonParser;
    private HtmlParser htmlParser;

    public Parser() {
    }

    private void initCsvParser() {
        if (this.csvParser == null) {
            this.csvParser = new CsvParser();
        }
    }

    private void initJsonParser() {
        if (this.jsonParser == null) {
            this.jsonParser = new JsonParser();
        }
    }

    private void initHtmlParser() {
        if (this.htmlParser == null) {
            this.htmlParser = new HtmlParser();
        }
    }

    public List<Stock> parseAllStocks(InputStream iStream) throws NseDataException {
        this.initCsvParser();
        return this.csvParser.parseAllStocks(iStream);
    }

    public List<Index> parseAllIndices(InputStream iStream) throws NseDataException {
        this.initJsonParser();
        return this.jsonParser.parseAllIndices(iStream);
    }

    public List<GainerLoserStats> parseTopGainers(InputStream iStream) throws NseDataException {
        this.initJsonParser();
        return this.jsonParser.parseTopGainers(iStream);
    }

    public List<GainerLoserStats> parseTopLosers(InputStream iStream) throws NseDataException {
        this.initJsonParser();
        return this.jsonParser.parseTopLosers(iStream);
    }

    public List<AdvanceDeclineStats> parseAdvancesDeclines(InputStream iStream) throws NseDataException {
        this.initJsonParser();
        return this.jsonParser.parseAdvancesDeclines(iStream);
    }

    public StockQuote parseStockQuote(InputStream iStream) throws NseDataException {
        this.initJsonParser();
        this.initHtmlParser();

        String responseBlock = this.htmlParser.parseStockQuote(iStream);
        StockQuote quote = this.jsonParser.parseStockQuote(responseBlock);

        return quote;
    }
}
