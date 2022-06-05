package nsereader.datafetcher;

class UrlStore {
    static final String ROOT_URL = "http://www1.nseindia.com";
    static final String ALL_STOCKS = ROOT_URL + "/content/equities/EQUITY_L.csv";
    static final String ALL_INDICES = ROOT_URL + "/homepage/Indices1.json";
    static final String TOP_GAINER_STOCKS = ROOT_URL + "/live_market/dynaContent/live_analysis/gainers/niftyGainers1.json";
    static final String TOP_LOSER_STOCKS = ROOT_URL + "/live_market/dynaContent/live_analysis/losers/niftyLosers1.json";
    static final String ADVANCES_DECLINES = ROOT_URL + "/common/json/indicesAdvanceDeclines.json";
}
