package tk.giaiphapchannuoi.server.DTO;

public class MiningResponse {

    private Float index;
    private Float originWeight;
    private String foot;
    private String gential;
    private Integer udder;
    private Float adg;
    private String classification;

    public MiningResponse() {
    }

    public MiningResponse(Float index, Float originWeight, String foot, String gential, Integer udder, Float adg, String classification) {
        this.index = index;
        this.originWeight = originWeight;
        this.foot = foot;
        this.gential = gential;
        this.udder = udder;
        this.adg = adg;
        this.classification = classification;
    }

    public Float getIndex() {
        return index;
    }

    public void setIndex(Float index) {
        this.index = index;
    }

    public Float getOriginWeight() {
        return originWeight;
    }

    public void setOriginWeight(Float originWeight) {
        this.originWeight = originWeight;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getGential() {
        return gential;
    }

    public void setGential(String gential) {
        this.gential = gential;
    }

    public Integer getUdder() {
        return udder;
    }

    public void setUdder(Integer udder) {
        this.udder = udder;
    }

    public Float getAdg() {
        return adg;
    }

    public void setAdg(Float adg) {
        this.adg = adg;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
