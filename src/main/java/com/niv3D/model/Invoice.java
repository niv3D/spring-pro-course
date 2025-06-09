package com.niv3D;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Invoice {
    private String id;
    private String userId;
    private String pdfUrl;
    private Integer amount;

    public Invoice(String userId, Integer amount, String pdfUrl) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.amount = amount;
        this.pdfUrl = pdfUrl;
    }

    public String getId() {
        return id;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("pdf_url")
    public String getPdfUrl() {
        return pdfUrl;
    }

    public Integer getAmount() {
        return amount;
    }
}
