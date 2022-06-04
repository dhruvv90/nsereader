package nsereader.datafetcher;

import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.GainerLoserStat;
import nsereader.model.Index;
import nsereader.model.Stock;
import nsereader.parser.ICsvParser;
import nsereader.parser.IJsonParser;
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
    private final IJsonParser jsonParser;

    private OkHttpDataFetcher() {
        this.httpClient = new OkHttpClient.Builder().build();
        this.csvParser = ICsvParser.getCurrentInstance();
        this.jsonParser = IJsonParser.getCurrentInstance();
    }

    static OkHttpDataFetcher getInstance() {
        if (instance == null) {
            instance = new OkHttpDataFetcher();
        }
        return instance;
    }

    public List<Stock> getStocks() throws NseResponseFailureException, NseTimeoutException, NseDataParsingException {
        Request req = new Request.Builder().url(UrlStore.ALL_STOCKS).build();
        List<Stock> stockList;

        try (Response res = httpClient.newCall(req).execute()) {
            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            InputStream iStream = res.body().byteStream();
            stockList = this.csvParser.parseAllStocks(iStream);
            return stockList;
        } catch (IOException e) {
            throw new NseTimeoutException(e);
        }
    }

    @Override
    public List<Index> getIndices() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        Request req = new Request.Builder()
                .url(UrlStore.ALL_INDICES)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", "linux")
                .build();
        List<Index> indexList;

        try(Response res = httpClient.newCall(req).execute()){
            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            InputStream iStream = res.body().byteStream();
            indexList = this.jsonParser.parseAllIndices(iStream);
        }
        catch(IOException e){
            throw new NseTimeoutException(e);
        }
        return indexList;
    }

    private List<GainerLoserStat> getTop(String url) throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        Request req = new Request.Builder()
                .url(url)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", "linux")
                .build();

        List<GainerLoserStat> stats;

        try(Response res = httpClient.newCall(req).execute()){
            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            InputStream iStream = res.body().byteStream();
            stats = this.jsonParser.parseTop(iStream);
        }
        catch(IOException e){
            throw new NseTimeoutException(e);
        }
        return stats;
    }

    @Override
    public List<GainerLoserStat> getTopGainers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        return this.getTop(UrlStore.TOP_GAINER_STOCKS);
    }

    @Override
    public List<GainerLoserStat> getTopLosers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        return this.getTop(UrlStore.TOP_LOSER_STOCKS);
    }
}
