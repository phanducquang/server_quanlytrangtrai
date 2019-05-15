package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.Breedings;
import tk.giaiphapchannuoi.server.model.Matings;
import tk.giaiphapchannuoi.server.model.Sperm;

import java.util.List;

public class PigInfoExtendDTO {

    private List<Breedings> breedings;
    private List<Matings> matings;
    private List<Sperm> sperms;

    public PigInfoExtendDTO() {
    }

    public List<Breedings> getBreedings() {
        return breedings;
    }

    public void setBreedings(List<Breedings> breedings) {
        this.breedings = breedings;
    }

    public List<Matings> getMatings() {
        return matings;
    }

    public void setMatings(List<Matings> matings) {
        this.matings = matings;
    }

    public List<Sperm> getSperms() {
        return sperms;
    }

    public void setSperms(List<Sperm> sperms) {
        this.sperms = sperms;
    }
}
