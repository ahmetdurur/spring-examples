package com.haydikodlayalim.graphql.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class VehicleDto {

    private String type;
    private String modelCode;
    private String brandName;
}
