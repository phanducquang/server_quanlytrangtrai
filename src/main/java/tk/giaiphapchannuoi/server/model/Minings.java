package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="minings")
public class Minings implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="index")
    private Integer index;

    @Column(name = "origin_weight")
    private Integer originWeight;

    @Column(name = "foot")
    private Integer foot;

    @Column(name = "gential")
    private Integer gential;

    @Column(name = "udder")
    private Integer udder;

    @Column(name = "adg")
    private Integer adg;

    @Column(name = "class")
    private String classification;

    public Minings() {
    }

    public Minings(Integer index, Integer originWeight, Integer foot, Integer gential, Integer udder, Integer adg, String classification) {
        this.index = index;
        this.originWeight = originWeight;
        this.foot = foot;
        this.gential = gential;
        this.udder = udder;
        this.adg = adg;
        this.classification = classification;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getOriginWeight() {
        return originWeight;
    }

    public void setOriginWeight(Integer originWeight) {
        this.originWeight = originWeight;
    }

    public Integer getFoot() {
        return foot;
    }

    public void setFoot(Integer foot) {
        this.foot = foot;
    }

    public Integer getGential() {
        return gential;
    }

    public void setGential(Integer gential) {
        this.gential = gential;
    }

    public Integer getUdder() {
        return udder;
    }

    public void setUdder(Integer udder) {
        this.udder = udder;
    }

    public Integer getAdg() {
        return adg;
    }

    public void setAdg(Integer adg) {
        this.adg = adg;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
