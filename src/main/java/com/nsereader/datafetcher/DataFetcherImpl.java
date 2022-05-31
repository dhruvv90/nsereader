package com.nsereader.datafetcher;

import com.nsereader.exception.NseResponseFailureException;
import com.nsereader.exception.NseTimeoutException;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.InputStream;
import java.time.Duration;
import java.util.Objects;


class DataFetcherImpl implements IDataFetcher {

    private static final int HTTP_CODE_OK = 200;
    private final Duration DEFAULT_DURATION = Duration.ofSeconds(10);
    private final OkHttpClient httpClient;

    DataFetcherImpl(Duration duration) {
        if (duration == null) {
            duration = DEFAULT_DURATION;
        }
        this.httpClient = new OkHttpClient.Builder()
                .callTimeout(Duration.ofSeconds(10))
                .readTimeout(duration)
                .build();
    }

    @Override
    public InputStream getAllStocks() throws NseTimeoutException, NseResponseFailureException {
        Request req = new Request.Builder()
                .url(UrlRepository.ALL_STOCKS)
                .build();

        InputStream responseStream;
        Call call = httpClient.newCall(req);
        try {
            Response res = call.execute();
            if (res.code() != HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            responseStream = res.body().byteStream();
        } catch (NseResponseFailureException e) {
            throw e;
        } catch (Exception e) {
            throw new NseTimeoutException();
        }
        return responseStream;
    }

    @Override
    public InputStream getAllIndices() throws NseTimeoutException, NseResponseFailureException {
        Request req = new Request.Builder()
                .url(UrlRepository.ALL_INDICES)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", "linux")
                .build();

        InputStream responseStream;
        Call call = httpClient.newCall(req);
        try {
            Response res = call.execute();
            if (res.code() != HTTP_CODE_OK || res.body() == null) {
                throw new NseResponseFailureException();
            }
            responseStream = res.body().byteStream();
        } catch (NseResponseFailureException e) {
            throw e;
        } catch (Exception e) {
            throw new NseTimeoutException();
        }
        return responseStream;
    }
}
