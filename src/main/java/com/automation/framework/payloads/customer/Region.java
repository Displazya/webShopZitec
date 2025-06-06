package com.automation.framework.payloads.customer;

import lombok.Data;

@Data
public class Region {
    private String regionCode;
    private String region;
    private Integer regionId;

    public Region(String regionCode, String region, Integer regionId) {
        this.regionCode = regionCode;
        this.region = region;
        this.regionId = regionId;
    }
}