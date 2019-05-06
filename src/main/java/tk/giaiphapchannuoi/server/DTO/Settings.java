package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.*;

import java.util.List;

public class Settings {

    private List<PregnancyStatus> pregnancyStatus;
    private List<Breeds> breeds;
    private List<BreedingType> breedingType;
    private List<HealthStatus> healthStatus;
    private List<Diseases> diseases;
    private List<FarmTypes> farmTypes;
    private List<FoodType> foodType;
    private List<FoodUnits> foodUnits;
    private List<Foods> foods;
    private List<MedicineType> medicineType;
    private List<MedicineUnits> medicineUnits;
    private List<Medicines> medicines;
    private List<PriceCodes> priceCodes;
    private List<FootType> footType;
    private List<GentialType> gentialType;
    private List<Issues> issues;
    private List<Rounds> rounds;
    private List<Status> status;
    private List<Roles> roles;


    public Settings() {
    }

    public Settings(List<PregnancyStatus> pregnancyStatus, List<Breeds> breeds, List<BreedingType> breedingType, List<HealthStatus> healthStatus, List<Diseases> diseases, List<FarmTypes> farmTypes, List<FoodType> foodType, List<FoodUnits> foodUnits, List<Foods> foods, List<MedicineType> medicineType, List<MedicineUnits> medicineUnits, List<Medicines> medicines, List<PriceCodes> priceCodes, List<FootType> footType, List<GentialType> gentialType, List<Issues> issues, List<Rounds> rounds, List<Status> status, List<Roles> roles) {
        this.pregnancyStatus = pregnancyStatus;
        this.breeds = breeds;
        this.breedingType = breedingType;
        this.healthStatus = healthStatus;
        this.diseases = diseases;
        this.farmTypes = farmTypes;
        this.foodType = foodType;
        this.foodUnits = foodUnits;
        this.foods = foods;
        this.medicineType = medicineType;
        this.medicineUnits = medicineUnits;
        this.medicines = medicines;
        this.priceCodes = priceCodes;
        this.footType = footType;
        this.gentialType = gentialType;
        this.issues = issues;
        this.rounds = rounds;
        this.status = status;
        this.roles = roles;
    }

    public List<PregnancyStatus> getPregnancyStatus() {
        return pregnancyStatus;
    }

    public void setPregnancyStatus(List<PregnancyStatus> pregnancyStatus) {
        this.pregnancyStatus = pregnancyStatus;
    }

    public List<Breeds> getBreeds() {
        return breeds;
    }

    public void setBreeds(List<Breeds> breeds) {
        this.breeds = breeds;
    }

    public List<BreedingType> getBreedingType() {
        return breedingType;
    }

    public void setBreedingType(List<BreedingType> breedingType) {
        this.breedingType = breedingType;
    }

    public List<HealthStatus> getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(List<HealthStatus> healthStatus) {
        this.healthStatus = healthStatus;
    }

    public List<Diseases> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Diseases> diseases) {
        this.diseases = diseases;
    }

    public List<FarmTypes> getFarmTypes() {
        return farmTypes;
    }

    public void setFarmTypes(List<FarmTypes> farmTypes) {
        this.farmTypes = farmTypes;
    }

    public List<FoodType> getFoodType() {
        return foodType;
    }

    public void setFoodType(List<FoodType> foodType) {
        this.foodType = foodType;
    }

    public List<FoodUnits> getFoodUnits() {
        return foodUnits;
    }

    public void setFoodUnits(List<FoodUnits> foodUnits) {
        this.foodUnits = foodUnits;
    }

    public List<Foods> getFoods() {
        return foods;
    }

    public void setFoods(List<Foods> foods) {
        this.foods = foods;
    }

    public List<MedicineType> getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(List<MedicineType> medicineType) {
        this.medicineType = medicineType;
    }

    public List<MedicineUnits> getMedicineUnits() {
        return medicineUnits;
    }

    public void setMedicineUnits(List<MedicineUnits> medicineUnits) {
        this.medicineUnits = medicineUnits;
    }

    public List<Medicines> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicines> medicines) {
        this.medicines = medicines;
    }

    public List<PriceCodes> getPriceCodes() {
        return priceCodes;
    }

    public void setPriceCodes(List<PriceCodes> priceCodes) {
        this.priceCodes = priceCodes;
    }

    public List<FootType> getFootType() {
        return footType;
    }

    public void setFootType(List<FootType> footType) {
        this.footType = footType;
    }

    public List<GentialType> getGentialType() {
        return gentialType;
    }

    public void setGentialType(List<GentialType> gentialType) {
        this.gentialType = gentialType;
    }

    public List<Issues> getIssues() {
        return issues;
    }

    public void setIssues(List<Issues> issues) {
        this.issues = issues;
    }

    public List<Rounds> getRounds() {
        return rounds;
    }

    public void setRounds(List<Rounds> rounds) {
        this.rounds = rounds;
    }

    public List<Status> getStatus() {
        return status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
