package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.MatingDetails;
import tk.giaiphapchannuoi.server.model.Matings;

import java.util.List;

public class ListMatingsMatingDetailsDTO {
    private List<Matings> matings;
    private List<MatingDetails> matingDetails;

    public ListMatingsMatingDetailsDTO() {
    }

    public List<Matings> getMatings() {
        return matings;
    }

    public void setMatings(List<Matings> matings) {
        this.matings = matings;
    }

    public List<MatingDetails> getMatingDetails() {
        return matingDetails;
    }

    public void setMatingDetails(List<MatingDetails> matingDetails) {
        this.matingDetails = matingDetails;
    }
}
