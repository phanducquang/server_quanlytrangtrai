package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.Breedings;

import java.util.List;

public class ScheduleDTO {
    private List<Breedings> breedings;

    public ScheduleDTO() {
    }

    public List<Breedings> getBreedings() {
        return breedings;
    }

    public void setBreedings(List<Breedings> breedings) {
        this.breedings = breedings;
    }
}
