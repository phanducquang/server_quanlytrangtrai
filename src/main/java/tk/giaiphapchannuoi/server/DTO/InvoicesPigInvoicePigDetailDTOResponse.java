package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.InvoicePigDetail;
import tk.giaiphapchannuoi.server.model.InvoicesPig;

import java.util.List;

public class InvoicesPigInvoicePigDetailDTOResponse {

    private List<InvoicesPig> invoicesPig;
    private List<InvoicePigDetail> invoicePigDetail;

    public InvoicesPigInvoicePigDetailDTOResponse() {
    }

    public InvoicesPigInvoicePigDetailDTOResponse(List<InvoicesPig> invoicesPig, List<InvoicePigDetail> invoicePigDetail) {
        this.invoicesPig = invoicesPig;
        this.invoicePigDetail = invoicePigDetail;
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
}
