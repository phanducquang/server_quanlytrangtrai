package tk.giaiphapchannuoi.server.DTO;

import tk.giaiphapchannuoi.server.model.InvoicesPig;
import tk.giaiphapchannuoi.server.model.InvoicesProduct;

import java.util.List;

public class InvoicesDTO {

    private List<InvoicesPig> invoicesPigs;
    private List<InvoicesProduct> invoicesProducts;

    public InvoicesDTO() {
    }

    public InvoicesDTO(List<InvoicesPig> invoicesPigs, List<InvoicesProduct> invoicesProducts) {
        this.invoicesPigs = invoicesPigs;
        this.invoicesProducts = invoicesProducts;
    }

    public List<InvoicesPig> getInvoicesPigs() {
        return invoicesPigs;
    }

    public void setInvoicesPigs(List<InvoicesPig> invoicesPigs) {
        this.invoicesPigs = invoicesPigs;
    }

    public List<InvoicesProduct> getInvoicesProducts() {
        return invoicesProducts;
    }

    public void setInvoicesProducts(List<InvoicesProduct> invoicesProducts) {
        this.invoicesProducts = invoicesProducts;
    }
}
