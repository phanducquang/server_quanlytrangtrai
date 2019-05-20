package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pig_transfer")
public class PigTransfer extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "from_farm")
    private Farms fromFarm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "to_farm")
    private Farms toFarm;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pig_id")
    private Pigs pig;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "del_flag")
    private Boolean delFlag;

    public PigTransfer() {
    }

    public PigTransfer(Farms fromFarm, Farms toFarm, Pigs pig, Date date, String status, Boolean delFlag) {
        this.fromFarm = fromFarm;
        this.toFarm = toFarm;
        this.pig = pig;
        this.date = date;
        this.status = status;
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Farms getFromFarm() {
        return fromFarm;
    }

    public void setFromFarm(Farms fromFarm) {
        this.fromFarm = fromFarm;
    }

    public Farms getToFarm() {
        return toFarm;
    }

    public void setToFarm(Farms toFarm) {
        this.toFarm = toFarm;
    }

    public Pigs getPig() {
        return pig;
    }

    public void setPig(Pigs pig) {
        this.pig = pig;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
