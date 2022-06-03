package nsereader.parser;

import nsereader.exception.NseDataParsingException;
import nsereader.model.Stock;

import java.io.InputStream;
import java.util.List;

public interface ICsvParser {

    List<Stock> parseAllStocksCsv(InputStream iStream) throws NseDataParsingException;

}


