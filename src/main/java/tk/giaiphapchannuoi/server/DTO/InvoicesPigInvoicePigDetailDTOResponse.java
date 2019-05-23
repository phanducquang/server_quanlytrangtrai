package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.Pigs;

import java.util.List;

public class InvoicesPigInvoicePigDetailDTOResponse {

    private List<InvoicesPig> invoicesPig;
    private List<InvoicePigDetail> invoicePigDetail;
    private List<Pigs> pigs;

    public InvoicesPigInvoicePigDetailDTOResponse() {
    }

    public InvoicesPigInvoicePigDetailDTOResponse(List<InvoicesPig> invoicesPig, List<InvoicePigDetail> invoicePigDetail, List<Pigs> pigs) {
        this.invoicesPig = invoicesPig;
        this.invoicePigDetail = invoicePigDetail;
        this.pigs = pigs;
    }

    public List<InvoicesPig> getInvoicesPig() {
        return invoicesPig;
    }

    public void setInvoicesPig(List<InvoicesPig> invoicesPig) {
        this.invoicesPig = invoicesPig;
    }

    public List<InvoicePigDetail> getInvoicePigDetail() {
        return invoicePigDetail;
    }

    public void setInvoicePigDetail(List<InvoicePigDetail> invoicePigDetail) {
        this.invoicePigDetail = invoicePigDetail;
    }

    public List<Pigs> getPigs() {
        return pigs;
    }

    public void setPigs(List<Pigs> pigs) {
        this.pigs = pigs;
    }
}
