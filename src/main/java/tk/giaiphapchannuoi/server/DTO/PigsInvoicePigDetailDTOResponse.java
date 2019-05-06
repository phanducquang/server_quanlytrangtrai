package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;

public class PigsInvoicePigDetailDTOResponse {
    private PigsDTO pigs;
    private InvoicePigDetail invoicePigDetail;

    public PigsInvoicePigDetailDTOResponse() {
    }

    public PigsInvoicePigDetailDTOResponse(PigsDTO pigs, InvoicePigDetail invoicePigDetail) {
        this.pigs = pigs;
        this.invoicePigDetail = invoicePigDetail;
    }

    public PigsDTO getPigs() {
        return pigs;
    }

    public void setPigs(PigsDTO pigs) {
        this.pigs = pigs;
    }

    public InvoicePigDetail getInvoicePigDetail() {
        return invoicePigDetail;
    }

    public void setInvoicePigDetail(InvoicePigDetail invoicePigDetail) {
        this.invoicePigDetail = invoicePigDetail;
    }
}
