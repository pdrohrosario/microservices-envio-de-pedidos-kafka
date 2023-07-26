package com.base.domains.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderStatus {

    PENDING("PENDING","Order status is in peding state");

    private final String status;

    private final String message;

}
