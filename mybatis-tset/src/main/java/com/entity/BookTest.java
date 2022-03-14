package com.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xs
 * @describe:
 * @date 2022/3/6 21:12
 */
@Data
public class BookTest implements Serializable {
    private User user;
    private int id;
    private String bookName;
}
