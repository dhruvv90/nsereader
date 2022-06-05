package nsereader.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class GainerLoserStats {
    private String symbol;
    private String series;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double openPrice;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double highPrice;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double lowPrice;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double ltp;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double previousPrice;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double netPrice;

    @JsonDeserialize(using = IntegerCommaDeserializer.class)
    private Integer tradedQuantity;

    @JsonDeserialize(using = DoubleCommaDeserializer.class)
    private Double turnoverInLakhs;

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

    public Double getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(Double openPrice) {
        this.openPrice = openPrice;
    }

    public Double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(Double highPrice) {
        this.highPrice = highPrice;
    }

    public Double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(Double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public Double getLtp() {
        return ltp;
    }

    public void setLtp(Double ltp) {
        this.ltp = ltp;
    }

    public Double getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(Double previousPrice) {
        this.previousPrice = previousPrice;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

    public Integer getTradedQuantity() {
        return tradedQuantity;
    }

    public void setTradedQuantity(Integer tradedQuantity) {
        this.tradedQuantity = tradedQuantity;
    }

    public Double getTurnoverInLakhs() {
        return turnoverInLakhs;
    }

    public void setTurnoverInLakhs(Double turnoverInLakhs) {
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
