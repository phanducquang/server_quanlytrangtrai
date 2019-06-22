package tk.giaiphapchannuoi.server.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="used_medicine")
public class UsedMedicine extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "for_pig_id")
    private Pigs forPigId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="diseases_id")
    private Diseases diseases;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="medicine_id")
//    private Medicines medicine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="medicine_warehouse_id")
    private MedicineWarehouse medicineWarehouse;

    @Column(name="unit")
    private Integer unit;

    @Column(name="quantity")
    private Float quantity;

    @Column(name="date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private Employees employee;

    @Column(name="description")
    private String description;

    @Column(name = "del_flag")
    private Boolean delFlag;

    public UsedMedicine() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pigs getForPigId() {
        return forPigId;
    }

    public void setForPigId(Pigs forPigId) {
        this.forPigId = forPigId;
    }

    public Diseases getDiseases() {
        return diseases;
    }

    public void setDiseases(Diseases diseases) {
        this.diseases = diseases;
    }

    public MedicineWarehouse getMedicineWarehouse() {
        return medicineWarehouse;
    }

    public void setMedicineWarehouse(MedicineWarehouse medicineWarehouse) {
        this.medicineWarehouse = medicineWarehouse;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
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
