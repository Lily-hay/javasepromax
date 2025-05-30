package com.lily.d3_collections_test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String number;
    private String color;
    private int size;

    @Override
    public String toString() {
        return number+color;
    }
}
