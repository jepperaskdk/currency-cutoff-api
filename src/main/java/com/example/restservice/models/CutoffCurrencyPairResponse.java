package com.example.restservice.models;

import java.util.Date;

public class CutoffCurrencyPairResponse {
    private Date cutoffDate;
    public CutoffCurrencyPairResponse(Date cutoffDate) {
        this.cutoffDate = cutoffDate;
    }

    public Date getCutoffDate() {
        return cutoffDate;
    }
}
