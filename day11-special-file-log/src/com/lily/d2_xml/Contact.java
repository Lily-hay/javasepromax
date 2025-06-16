package com.lily.d2_xml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String name;
    private int id;
    private char gender;
    private String email;
}
