package nsereader.internal.datafetcher;

import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.internal.parser.ICsvParser;
import nsereader.internal.parser.IJsonParser;
import nsereader.model.AdvanceDeclineStats;
import nsereader.model.GainerLoserStats;
import nsereader.model.Index;
import nsereader.model.Stock;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class OkHttpDataFetcher implements IDataFetcher {
    private static OkHttpDataFetcher instance;
    private final OkHttpClient httpClient;
    private final ICsvParser csvParser;
    private final IJsonParser jsonParser;

    private OkHttpDataFetcher() {
        this.httpClient = new OkHttpClient.Builder().build();
        this.csvParser = ICsvParser.getCurrentInstance();
        this.jsonParser = IJsonParser.getCurrentInstance();
    }

    public static OkHttpDataFetcher getInstance() {
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

    @Override
    public List<GainerLoserStats> getTopGainers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        Request req = new Request.Builder()
                .url(UrlStore.TOP_GAINER_STOCKS)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", "linux")
                .build();

        List<GainerLoserStats> stats;

        try(Response res = httpClient.newCall(req).execute()){
            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            InputStream iStream = res.body().byteStream();
            stats = this.jsonParser.parseTopGainers(iStream);
        }
        catch(IOException e){
            throw new NseTimeoutException(e);
        }
        return stats;
    }

    @Override
    public List<GainerLoserStats> getTopLosers() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        Request req = new Request.Builder()
                .url(UrlStore.TOP_LOSER_STOCKS)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", "linux")
                .build();

        List<GainerLoserStats> stats;

        try(Response res = httpClient.newCall(req).execute()){
            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            InputStream iStream = res.body().byteStream();
            stats = this.jsonParser.parseTopLosers(iStream);
        }
        catch(IOException e){
            throw new NseTimeoutException(e);
        }
        return stats;
    }

    @Override
    public List<AdvanceDeclineStats> getAdvancesDeclines() throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        Request req = new Request.Builder()
                .url(UrlStore.ADVANCES_DECLINES)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", "linux")
                .build();

        List<AdvanceDeclineStats> stats;

        try(Response res = httpClient.newCall(req).execute()){
            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            InputStream iStream = res.body().byteStream();
            stats = this.jsonParser.parseAdvancesDeclines(iStream);
        }
        catch(IOException e){
            throw new NseTimeoutException(e);
        }
        return stats;
    }
}
