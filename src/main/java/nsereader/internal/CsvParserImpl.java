package nsereader.internal;

import nsereader.exception.NseDataParsingException;
import nsereader.model.Stock;
import nsereader.parser.ICsvParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvParserImpl implements ICsvParser {

    private final static String CSV_DELIMITER = ",";

    @Override
    public List<Stock> parseAllStocksCsv(InputStream iStream) throws NseDataParsingException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
        List<Stock> stockList = new ArrayList<>();

        try {
            while (true) {
                String row = reader.readLine();
                if (row == null) {
                    break;
                }
                String[] fragments = row.split(CSV_DELIMITER);
                if (fragments.length < 8) {
                    throw new NseDataParsingException("Incorrect CSV format. Got <8 fragments in CSV row");
                }
                // Ignore first row
                if (fragments[0].equalsIgnoreCase("symbol")) {
                    continue;
                }

                Stock stock = new Stock(fragments[0]);
            }
        } catch (IOException e) {
            throw new NseDataParsingException(e);
        }

//        if (stockList.isEmpty()) {
//            throw new NseDataParsingException();
//        }
        return stockList;
    }
}
