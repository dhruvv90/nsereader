package nsereader.model;

public class AdvanceDeclineStats {
    private String indice;
    private Integer advances;
    private Integer declines;
    private Integer unchanged;

    public AdvanceDeclineStats() {

    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice.toUpperCase();
    }

    public Integer getAdvances() {
        return advances;
    }

    public void setAdvances(Integer advances) {
        this.advances = advances;
    }

    public Integer getDeclines() {
        return declines;
    }

    public void setDeclines(Integer declines) {
        this.declines = declines;
    }

    public Integer getUnchanged() {
        return unchanged;
    }

    public void setUnchanged(Integer unchanged) {
        this.unchanged = unchanged;
    }
}
