package com.example.pointofsale.Model;

import com.example.pointofsale.entity.Invoice;
import com.example.pointofsale.entity.ProductInvoice;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductInvoiceModel {

    private Long id;
    private BigDecimal total;
    private ProductModel productModel;
    private InvoiceModel invoiceModel;

    public ProductInvoiceModel(ProductInvoice productInvoice) {
        this.id = productInvoice.getId();
        this.total = productInvoice.getTotal();
        this.productModel = new ProductModel(productInvoice.getProduct());
        this.invoiceModel = new InvoiceModel(productInvoice.getInvoice());

    }

    public ProductInvoiceModel( ) {
        this.id=getId();
        this.total=getTotal();
        this.productModel=new ProductModel();
        this.invoiceModel=new InvoiceModel();
    }

    public ProductInvoice disassemble() {
        ProductInvoice productInvoice = new ProductInvoice();
        productInvoice.setId(id);
        productInvoice.setTotal(total);
        productInvoice.setProduct(productModel.disassemble());
        productInvoice.setInvoice(invoiceModel.disassemble());
        return productInvoice;
    }

    public  ProductInvoiceModel assemble(ProductInvoice productInvoice) {
        ProductInvoiceModel productInvoiceModel = new ProductInvoiceModel(productInvoice);
        productInvoiceModel.setId(productInvoiceModel.getId());
        productInvoiceModel.setTotal(productInvoiceModel.getTotal());
        productInvoiceModel.setProductModel(new ProductModel().assemble(productInvoiceModel.getProductModel().disassemble()));
        productInvoiceModel.setInvoiceModel(new InvoiceModel().assemble(productInvoiceModel.getInvoiceModel().disassemble()));
        return productInvoiceModel;
    }

}
