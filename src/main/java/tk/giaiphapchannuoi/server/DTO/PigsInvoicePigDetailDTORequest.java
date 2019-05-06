package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;

public class PigsInvoicePigDetailDTORequest {
    private Pigs pigs;
    private InvoicesPig invoicesPig;

    public PigsInvoicePigDetailDTORequest() {
    }

    public PigsInvoicePigDetailDTORequest(Pigs pigs, InvoicesPig invoicesPig) {
        this.pigs = pigs;
        this.invoicesPig = invoicesPig;
    }

    public Pigs getPigs() {
        return pigs;
    }

    public void setPigs(Pigs pigs) {
        this.pigs = pigs;
    }

    public InvoicesPig getInvoicesPig() {
        return invoicesPig;
    }

    public void setInvoicesPig(InvoicesPig invoicesPig) {
        this.invoicesPig = invoicesPig;
    }
}
