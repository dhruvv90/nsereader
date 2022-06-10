package nsereader.parser;

import nsereader.exception.NseDataException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;

class HtmlParser {

    HtmlParser() {

    }

    String parseStockQuote(InputStream iStream) throws NseDataException {
        Element responseDiv;
        try {
            Document document = Jsoup.parse(iStream, "UTF-8", "http://www1.nseindia.com");
            responseDiv = document.getElementById("responseDiv");
        } catch (IOException e) {
            throw new NseDataException(e);
        }
        if (responseDiv == null) {
            throw new NseDataException("responseDiv not found");
        }
        return responseDiv.text();
    }
}
