package nsereader.model;

import java.util.Date;

public class Stock {

    private String symbol;
    private String nameOfCompany;
    private String series;
    private Date dateOfListing;
    private Double paidUpValue;
    private Short marketLot;
    private String isinNumber;
    private Short faceValue;

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

    public Double getPaidUpValue() {
        return paidUpValue;
    }

    public void setPaidUpValue(Double paidUpValue) {
        this.paidUpValue = paidUpValue;
    }

    public Short getMarketLot() {
        return marketLot;
    }

    public void setMarketLot(Short marketLot) {
        this.marketLot = marketLot;
    }

    public String getIsinNumber() {
        return isinNumber;
    }

    public void setIsinNumber(String isinNumber) {
        this.isinNumber = isinNumber;
    }

    public Short getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(Short faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return getSymbol() + " (" + getNameOfCompany() + ")";
    }

}
