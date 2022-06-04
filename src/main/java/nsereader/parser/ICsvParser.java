package nsereader.parser;

import nsereader.exception.NseDataParsingException;
import nsereader.model.Stock;

import java.io.InputStream;
import java.util.List;

public interface ICsvParser {

    static ICsvParser getCurrentInstance() {
        return CsvParserImpl.getInstance();
    }

    List<Stock> parseAllStocks(InputStream iStream) throws NseDataParsingException;

}


