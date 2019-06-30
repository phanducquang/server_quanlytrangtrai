package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.Breedings;
import tk.giaiphapchannuoi.server.model.MatingDetails;
import tk.giaiphapchannuoi.server.model.Matings;

import java.util.List;

public class MatingsMatingDetailsDTO {

    private Matings mating;

    private List<MatingDetails> matingDetail;

    private Breedings breeding;

    public MatingsMatingDetailsDTO() {
    }

    public MatingsMatingDetailsDTO(Matings mating, List<MatingDetails> matingDetail) {
        this.mating = mating;
        this.matingDetail = matingDetail;
    }

    public MatingsMatingDetailsDTO(Matings mating, List<MatingDetails> matingDetail, Breedings breeding) {
        this.mating = mating;
        this.matingDetail = matingDetail;
        this.breeding = breeding;
    }

    public Matings getMating() {
        return mating;
    }

    public void setMating(Matings mating) {
        this.mating = mating;
    }

    public List<MatingDetails> getMatingDetail() {
        return matingDetail;
    }

    public void setMatingDetail(List<MatingDetails> matingDetail) {
        this.matingDetail = matingDetail;
    }

    public Breedings getBreeding() {
        return breeding;
    }

    public void setBreeding(Breedings breeding) {
        this.breeding = breeding;
    }
}
