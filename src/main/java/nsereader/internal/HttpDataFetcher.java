package nsereader.internal;

import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


class HttpDataFetcher implements IDataFetcher {
    private static HttpDataFetcher instance;
    private final OkHttpClient httpClient;
    private final Parser parser;

    private HttpDataFetcher() {
        this.httpClient = new OkHttpClient.Builder().build();
        this.parser = new Parser();
    }

    static HttpDataFetcher getInstance() {
        if (instance == null) {
            instance = new HttpDataFetcher();
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
            stockList = this.parser.parseAllStocks(iStream);
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
            indexList = this.parser.parseAllIndices(iStream);
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
            stats = this.parser.parseTopGainers(iStream);
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
            stats = this.parser.parseTopLosers(iStream);
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
            stats = this.parser.parseAdvancesDeclines(iStream);
        }
        catch(IOException e){
            throw new NseTimeoutException(e);
        }
        return stats;
    }

    @Override
    public StockQuote getStockQuote(String stockSymbol) throws NseDataParsingException, NseResponseFailureException, NseTimeoutException {
        Request req = new Request.Builder()
                .url(UrlStore.getQuoteUrlForStock(stockSymbol))
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", "linux")
                .build();

        StockQuote quote;

        try(Response res = httpClient.newCall(req).execute()){
            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            InputStream iStream = res.body().byteStream();
            quote = this.parser.parseStockQuote(iStream);
        }
        catch(IOException e){
            throw new NseTimeoutException(e);
        }
        return quote;
    }
}