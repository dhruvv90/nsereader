package nsereader.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class GainerLoserStats {
    private String symbol;
    private String series;

    private BigDecimal openPrice;

    private BigDecimal highPrice;

    private BigDecimal lowPrice;

    private BigDecimal ltp;

    private BigDecimal previousPrice;

    private BigDecimal netPrice;

    private BigInteger tradedQuantity;

    private BigDecimal turnoverInLakhs;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private Date lastCorpAnnouncementDate;

    private String lastCorpAnnouncement;

    public GainerLoserStats() {

    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public BigDecimal getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(BigDecimal openPrice) {
        this.openPrice = openPrice;
    }

    public BigDecimal getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(BigDecimal highPrice) {
        this.highPrice = highPrice;
    }

    public BigDecimal getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(BigDecimal lowPrice) {
        this.lowPrice = lowPrice;
    }

    public BigDecimal getLtp() {
        return ltp;
    }

    public void setLtp(BigDecimal ltp) {
        this.ltp = ltp;
    }

    public BigDecimal getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(BigDecimal previousPrice) {
        this.previousPrice = previousPrice;
    }

    public BigDecimal getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(BigDecimal netPrice) {
        this.netPrice = netPrice;
    }

    public BigInteger getTradedQuantity() {
        return tradedQuantity;
    }

    public void setTradedQuantity(BigInteger tradedQuantity) {
        this.tradedQuantity = tradedQuantity;
    }

    public BigDecimal getTurnoverInLakhs() {
        return turnoverInLakhs;
    }

    public void setTurnoverInLakhs(BigDecimal turnoverInLakhs) {
        this.turnoverInLakhs = turnoverInLakhs;
    }

    public Date getLastCorpAnnouncementDate() {
        return lastCorpAnnouncementDate;
    }

    public void setLastCorpAnnouncementDate(Date lastCorpAnnouncementDate) {
        this.lastCorpAnnouncementDate = lastCorpAnnouncementDate;
    }

    public String getLastCorpAnnouncement() {
        return lastCorpAnnouncement;
    }

    public void setLastCorpAnnouncement(String lastCorpAnnouncement) {
        this.lastCorpAnnouncement = lastCorpAnnouncement;
    }
}
