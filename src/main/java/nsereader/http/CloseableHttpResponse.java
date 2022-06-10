package nsereader.http;

import nsereader.exception.NseConnectionException;
import nsereader.exception.NseResponseFailureException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public class CloseableHttpResponse implements Closeable {

    private final Response response;

    CloseableHttpResponse(OkHttpClient client, Request request) throws NseConnectionException, NseResponseFailureException {
        try {
            this.response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new NseConnectionException(e);
        }

        if (this.response.code() != 200 || this.response.body() == null) {
            throw new NseResponseFailureException();
        }
    }

    public InputStream getStream() {
        assert this.response.body() != null;
        return this.response.body().byteStream();
    }

    @Override
    public void close() {
        if (this.response != null) {
            this.response.close();
        }
    }
}
