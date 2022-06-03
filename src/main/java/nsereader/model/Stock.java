package nsereader.model;

import java.util.Date;

public class Stock {

    private final String symbol;
    private String nameOfCompany;
    private String series;
    private Date dateOfListing;
    private double paidUpValue;
    private short marketLot;
    private String isinNumber;
    private short faceValue;

    public Stock(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNameOfCompany() {
        return nameOfCompany;
    }

    void setNameOfCompany(String nameOfCompany) {
        this.nameOfCompany = nameOfCompany;
    }

    public String getSeries() {
        return series;
    }

    void setSeries(String series) {
        this.series = series;
    }

    public Date getDateOfListing() {
        return dateOfListing;
    }

    void setDateOfListing(Date dateOfListing) {
        this.dateOfListing = dateOfListing;
    }

    public double getPaidUpValue() {
        return paidUpValue;
    }

    void setPaidUpValue(double paidUpValue) {
        this.paidUpValue = paidUpValue;
    }

    public short getMarketLot() {
        return marketLot;
    }

    void setMarketLot(short marketLot) {
        this.marketLot = marketLot;
    }

    public String getIsinNumber() {
        return isinNumber;
    }

    void setIsinNumber(String isinNumber) {
        this.isinNumber = isinNumber;
    }

    public short getFaceValue() {
        return faceValue;
    }

    void setFaceValue(short faceValue) {
        this.faceValue = faceValue;
    }

    @Override
    public String toString() {
        return getSymbol() + "(" + getNameOfCompany() + ")";
    }

}
