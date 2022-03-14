package com.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class User implements Serializable {
    BookTest bookTest;
    private Long id;
    private String username;
    private Integer age;
}
