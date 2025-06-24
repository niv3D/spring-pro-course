package com.niv3D.web;

import com.niv3D.dto.InvoiceDTO;
import com.niv3D.model.Invoice;
import com.niv3D.services.InvoiceService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class FancyPdfInvoicesController {

    private final InvoiceService invoiceService;

    public FancyPdfInvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestParam("user_id") @NotBlank String userId, @RequestParam("amount") @Min(10) @Max(50) Integer amount) {
        return invoiceService.create(userId, amount);
    }
}
