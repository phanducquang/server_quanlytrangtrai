package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;

import java.util.List;

public class PigsInvoicePigDTOResponse {
    private List<PigsDTO> pigsList;
    private InvoicesPig invoicesPig;
    private List<InvoicePigDetail> invoicePigDetailList;

    public PigsInvoicePigDTOResponse() {
    }

    public PigsInvoicePigDTOResponse(List<PigsDTO> pigsList, InvoicesPig invoicesPig, List<InvoicePigDetail> invoicePigDetailList) {
        this.pigsList = pigsList;
        this.invoicesPig = invoicesPig;
        this.invoicePigDetailList = invoicePigDetailList;
    }

    public List<PigsDTO> getPigsList() {
        return pigsList;
    }

    public void setPigsList(List<PigsDTO> pigsList) {
        this.pigsList = pigsList;
    }

    public InvoicesPig getInvoicesPig() {
        return invoicesPig;
    }

    public void setInvoicesPig(InvoicesPig invoicesPig) {
        this.invoicesPig = invoicesPig;
    }

    public List<InvoicePigDetail> getInvoicePigDetailList() {
        return invoicePigDetailList;
    }

    public void setInvoicePigDetailList(List<InvoicePigDetail> invoicePigDetailList) {
        this.invoicePigDetailList = invoicePigDetailList;
    }
}
