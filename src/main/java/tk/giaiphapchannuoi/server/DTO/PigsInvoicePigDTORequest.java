package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;

import java.util.List;

public class PigsInvoicePigDTORequest {
    private List<Pigs> pigsList;
    private InvoicesPig invoicesPig;
    private InvoicesPig invoicesPigUpdate;

    public PigsInvoicePigDTORequest() {
    }

    public PigsInvoicePigDTORequest(List<Pigs> pigsList, InvoicesPig invoicesPig, InvoicesPig invoicesPigUpdate) {
        this.pigsList = pigsList;
        this.invoicesPig = invoicesPig;
        this.invoicesPigUpdate = invoicesPigUpdate;
    }

    public List<Pigs> getPigsList() {
        return pigsList;
    }

    public void setPigsList(List<Pigs> pigsList) {
        this.pigsList = pigsList;
    }

    public InvoicesPig getInvoicesPig() {
        return invoicesPig;
    }

    public void setInvoicesPig(InvoicesPig invoicesPig) {
        this.invoicesPig = invoicesPig;
    }

    public InvoicesPig getInvoicesPigUpdate() {
        return invoicesPigUpdate;
    }

    public void setInvoicesPigUpdate(InvoicesPig invoicesPigUpdate) {
        this.invoicesPigUpdate = invoicesPigUpdate;
    }
}
