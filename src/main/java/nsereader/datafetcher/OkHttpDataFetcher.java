package nsereader.datafetcher;

import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.Stock;
import nsereader.parser.ICsvParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


class OkHttpDataFetcher implements IDataFetcher {
    private static OkHttpDataFetcher instance;
    private final OkHttpClient httpClient;
    private final ICsvParser csvParser;

    private OkHttpDataFetcher() {
        this.httpClient = new OkHttpClient.Builder().build();
        this.csvParser = ICsvParser.getCurrentInstance();
    }

    static OkHttpDataFetcher getInstance() {
        if (instance == null) {
            instance = new OkHttpDataFetcher();
        }
        return instance;
    }

    public List<Stock> getStocks() throws NseResponseFailureException, NseTimeoutException, NseDataParsingException {
        Request req = new Request.Builder().url(UrlStore.ALL_STOCKS).build();

        try (Response res = httpClient.newCall(req).execute()) {
            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            InputStream iStream = res.body().byteStream();
            List<Stock> stockList;
            stockList = this.csvParser.parseAllStocksCsv(iStream);
            return stockList;
        } catch (IOException e) {
            throw new NseTimeoutException(e);
        }
    }
}
