package com.base.domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private String id;
    private String name;
    private int quantity;
    private double price;
    private String requestingCustomer;
}
