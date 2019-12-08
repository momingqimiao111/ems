package com.ljl.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Emp implements Serializable {
    private String id;
    private String name;
    private Double salary;
    private Integer age;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bir;
    private Dept dept;
}
