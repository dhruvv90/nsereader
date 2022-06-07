package nsereader.internal.datafetcher;

abstract class HttpUtils {
    static final int HTTP_CODE_OK = 200;

    static String getQuoteUrlForStock(String stockSymbol) {
        return UrlStore.ROOT_URL +
                "/live_market/dynaContent/live_watch/get_quote/GetQuote.jsp?symbol=" +
                stockSymbol.toUpperCase() +
                "&illiquid=0&smeFlag=0&itpFlag=0";
    }

}
