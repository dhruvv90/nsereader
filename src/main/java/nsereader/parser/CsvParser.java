package nsereader.parser;

import nsereader.exception.NseDataException;
import nsereader.model.Stock;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

class CsvParser {

    CsvParser() {

    }

    List<Stock> parseAllStocks(InputStream iStream) throws NseDataException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(iStream));
            List<Stock> stockList = new ArrayList<>();
            while (true) {
                String row = reader.readLine();

                if (row == null) {
                    break;
                }
                String[] fragments = row.split(",");
                if (fragments.length == 0) {
                    throw new NseDataException("No Data in Stocks CSV");
                }

                // Ignore first row
                if (fragments[0].equalsIgnoreCase("symbol")) {
                    continue;
                }

                int i = 0;
                Stock stock = new Stock();

                stock.setSymbol(fragments[i++]);
                stock.setNameOfCompany(fragments[i++]);
                stock.setSeries(fragments[i++]);
                stock.setDateOfListing(new SimpleDateFormat("dd-MMM-yyyy").parse(fragments[i++]));
                stock.setPaidUpValue(new BigDecimal(fragments[i++]));
                stock.setMarketLot(Integer.parseInt(fragments[i++]));
                stock.setIsinNumber(fragments[i++]);
                //noinspection UnusedAssignment
                stock.setFaceValue(Integer.parseInt(fragments[i++]));

                stockList.add(stock);
            }
            if (stockList.isEmpty()) {
                throw new NseDataException("StocksCsv: Empty Response");
            }
            return stockList;

        } catch (Exception e) {
            throw new NseDataException(e);
        }
    }

}


