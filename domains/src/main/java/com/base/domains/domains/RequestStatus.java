package com.base.domains.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RequestStatus {

    PENDING("PENDING","Request status is in peding state");

    private final String status;

    private final String message;

}
