package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.Pigs;

public class PigsInvoicePigDetailDTO {
    private Pigs pigs;
    private InvoicePigDetail invoicePigDetail;

    public PigsInvoicePigDetailDTO() {
    }

    public PigsInvoicePigDetailDTO(Pigs pigs, InvoicePigDetail invoicePigDetail) {
        this.pigs = pigs;
        this.invoicePigDetail = invoicePigDetail;
    }

    public Pigs getPigs() {
        return pigs;
    }

    public void setPigs(Pigs pigs) {
        this.pigs = pigs;
    }

    public InvoicePigDetail getInvoicePigDetail() {
        return invoicePigDetail;
    }

    public void setInvoicePigDetail(InvoicePigDetail invoicePigDetail) {
        this.invoicePigDetail = invoicePigDetail;
    }
}
