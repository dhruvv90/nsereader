package nsereader.model;

import java.math.BigDecimal;
import java.util.Date;

public class Stock {

    private String symbol;
    private String nameOfCompany;
    private String series;
    private Date dateOfListing;
    private BigDecimal paidUpValue;
    private Integer marketLot;
    private String isinNumber;
    private Integer faceValue;

    public Stock() {
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol.toUpperCase();
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    public void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public Date getDateOfListing() {
        return dateOfListing;
    }

    public void setDateOfListing(Date dateOfListing) {
        this.dateOfListing = dateOfListing;
    }

    public BigDecimal getPaidUpValue() {
        return paidUpValue;
    }

    public void setPaidUpValue(BigDecimal paidUpValue) {
        this.paidUpValue = paidUpValue;
    }

    public Integer getMarketLot() {
        return marketLot;
    }

    public void setMarketLot(Integer marketLot) {
        this.marketLot = marketLot;
    }

    public String getIsinNumber() {
        return isinNumber;
    }

    public void setIsinNumber(String isinNumber) {
        this.isinNumber = isinNumber;
    }

    public Integer getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Integer faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return getSymbol() + " (" + getNameOfCompany() + ")";
    }

}
