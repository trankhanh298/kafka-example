package com.khan.gateway;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FilterOrderType {

    PRE(-1),

    POST(0),

    ROUTE(1);

    private int order;
    
}