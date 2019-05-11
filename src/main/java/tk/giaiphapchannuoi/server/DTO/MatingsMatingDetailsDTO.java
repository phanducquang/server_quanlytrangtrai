package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.MatingDetails;
import tk.giaiphapchannuoi.server.model.Matings;

import java.util.List;

public class MatingsMatingDetailsDTO {

    private Matings mating;

    private List<MatingDetails> matingDetail;

    public MatingsMatingDetailsDTO() {
    }

    public MatingsMatingDetailsDTO(Matings mating, List<MatingDetails> matingDetail) {
        this.mating = mating;
        this.matingDetail = matingDetail;
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
}
