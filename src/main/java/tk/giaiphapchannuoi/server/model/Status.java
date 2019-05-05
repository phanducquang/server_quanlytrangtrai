package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="status")
public class Status extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="previous_status")
    private Integer previousStatus;

    @Column(name="description")
    private String description;

    @Column(name = "del_flag")
    private Boolean delFlag;

    public Status() {
    }

    public Status(String name, Integer previousStatus, String description, Boolean delFlag) {
        this.name = name;
        this.previousStatus = previousStatus;
        this.description = description;
        this.delFlag = delFlag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(Integer previousStatus) {
        this.previousStatus = previousStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
