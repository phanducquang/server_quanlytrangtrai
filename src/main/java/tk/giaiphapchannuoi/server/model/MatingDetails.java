package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="mating_details")
public class MatingDetails extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="mating_id")
	private Matings mating;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sperm_id")
    private Sperm sperm;

    @Column(name="date")
    private Date date;

    @Column(name = "insemination")
    private String insemination;

    @Column(name = "del_flag")
    private Boolean delFlag;

    public MatingDetails() {
    }

    public MatingDetails(Matings mating, Sperm sperm, Date date, String insemination, Boolean delFlag) {
        this.mating = mating;
        this.sperm = sperm;
        this.date = date;
        this.insemination = insemination;
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matings getMating() {
        return mating;
    }

    public void setMating(Matings mating) {
        this.mating = mating;
    }

    public Sperm getSperm() {
        return sperm;
    }

    public void setSperm(Sperm sperm) {
        this.sperm = sperm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInsemination() {
        return insemination;
    }

    public void setInsemination(String insemination) {
        this.insemination = insemination;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
