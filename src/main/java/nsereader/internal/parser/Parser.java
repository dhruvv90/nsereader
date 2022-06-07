package nsereader.internal.parser;

import nsereader.exception.NseDataParsingException;
import nsereader.model.AdvanceDeclineStats;
import nsereader.model.GainerLoserStats;
import nsereader.model.Index;
import nsereader.model.Stock;

import java.io.InputStream;
import java.util.List;

public class Parser {

    private final CsvParser csvParser;
    private final JsonParser jsonParser;

    public Parser() {
        this.csvParser = new CsvParser();
        this.jsonParser = new JsonParser();

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
}
