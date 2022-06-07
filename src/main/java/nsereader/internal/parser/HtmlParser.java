package nsereader.internal.parser;

import nsereader.exception.NseDataParsingException;
import nsereader.internal.datafetcher.UrlStore;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

class HtmlParser {

    HtmlParser(){

    }

    String parseStockQuote(InputStream iStream) throws NseDataParsingException{
        try {
            Document document = Jsoup.parse(iStream,"UTF-8", UrlStore.ROOT_URL);
            return Objects.requireNonNull(document.getElementById("responseDiv")).text();
        } catch (IOException | NullPointerException e) {
            throw new NseDataParsingException(e);
        }
    }
}
