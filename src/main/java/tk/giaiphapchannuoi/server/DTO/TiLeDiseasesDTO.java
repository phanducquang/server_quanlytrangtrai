package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.Diseases;

import java.util.Objects;

public class TiLeDiseasesDTO {

    private Diseases disease;
    private Float tiLe;

    public TiLeDiseasesDTO() {
    }

    public Diseases getDisease() {
        return disease;
    }

    public void setDisease(Diseases disease) {
        this.disease = disease;
    }

    public Float getTiLe() {
        return tiLe;
    }

    public void setTiLe(Float tiLe) {
        this.tiLe = tiLe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TiLeDiseasesDTO that = (TiLeDiseasesDTO) o;
        return Objects.equals(disease, that.disease) &&
                Objects.equals(tiLe, that.tiLe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disease, tiLe);
    }

//    public int compareTo(TiLeDiseasesDTO tiLeDiseasesDTO) {
//        if (tiLe == tiLeDiseasesDTO.tiLe)
//            return 0;
//        else if (tiLe > tiLeDiseasesDTO.tiLe)
//            return 1;
//        else
//            return -1;
//    }
}
