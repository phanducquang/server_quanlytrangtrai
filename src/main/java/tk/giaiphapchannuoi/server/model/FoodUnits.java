package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="food_units")
public class FoodUnits extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="quantity")
    private Float quantity;

    @Column(name="description")
    private String description;

    @Column(name="base_unit")
    private Integer baseUnit;

    @Column(name = "del_flag")
    private Boolean delFlag;

    public FoodUnits() {
    }

    public FoodUnits(String name, Float quantity, String description, Integer baseUnit, Boolean delFlag) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.baseUnit = baseUnit;
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

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(Integer baseUnit) {
        this.baseUnit = baseUnit;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }
}
