package nsereader.internal;

import nsereader.datafetcher.IDataFetcher;
import nsereader.exception.NseDataParsingException;
import nsereader.exception.NseResponseFailureException;
import nsereader.exception.NseTimeoutException;
import nsereader.model.Stock;
import okhttp3.OkHttpClient;

import java.util.List;


public class OkHttpDataFetcher implements IDataFetcher {
    private final OkHttpClient httpClient;

    public OkHttpDataFetcher() {
        this.httpClient = new OkHttpClient.Builder().build();
    }

    public List<Stock> getStocks() throws NseResponseFailureException, NseTimeoutException, NseDataParsingException {
//        Request req = new Request.Builder().url(UrlStore.ALL_STOCKS).build();
//        Call call = httpClient.newCall(req);
//
//        try(Response res = call.execute()) {
//            if (res.code() != HttpUtils.HTTP_CODE_OK || res.body() == null) {
//                throw new NseResponseFailureException();
//            }
//            return res.body().byteStream();
//        } catch (IOException e) {
//            throw new NseTimeoutException(e);
//        }
        return null;
    }
}
