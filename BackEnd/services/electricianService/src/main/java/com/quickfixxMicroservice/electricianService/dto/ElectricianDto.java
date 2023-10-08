package com.quickfixxMicroservice.electricianService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ElectricianDto {
    private Long id;
    private String name;
    private Integer contact;
    private String location;
    private String address;
    private List<String> qualification;
}
