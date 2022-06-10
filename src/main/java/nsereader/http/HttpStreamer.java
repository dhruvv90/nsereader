package nsereader.http;

import nsereader.exception.NseConnectionException;
import nsereader.exception.NseResponseFailureException;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.time.Duration;

public class HttpStreamer {

    private static final String DEFAULT_USER_AGENT = "undefined/1.0";

    private static final Duration DEFAULT_TIMEOUT_DURATION = Duration.ofSeconds(10);
    private final OkHttpClient httpClient;
    private final String userAgent;

    private HttpStreamer(HttpStreamerBuilder builder) {
        this.userAgent = builder.userAgent != null ? builder.userAgent : DEFAULT_USER_AGENT;
        Duration timeout = builder.timeoutInSeconds != null ? builder.timeoutInSeconds : DEFAULT_TIMEOUT_DURATION;
        this.httpClient = new OkHttpClient.Builder().callTimeout(timeout).build();
    }

    public CloseableHttpResponse get(String url) throws NseConnectionException, NseResponseFailureException {
        Request req = createGetRequest(url);
        return new CloseableHttpResponse(this.httpClient, req);
    }

    private Request createGetRequest(String url) {
        return new Request.Builder()
                .url(url)
                .addHeader("Accept", "*/*")
                .addHeader("User-Agent", this.userAgent)
                .build();
    }

    public static class HttpStreamerBuilder {
        Duration timeoutInSeconds;
        String userAgent;

        public HttpStreamerBuilder setTimeout(Duration timeoutInSeconds) {
            this.timeoutInSeconds = timeoutInSeconds;
            return this;
        }

        public HttpStreamerBuilder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public HttpStreamer build() {
            HttpStreamer httpStreamer = new HttpStreamer(this);
            return httpStreamer;
        }
    }
}


