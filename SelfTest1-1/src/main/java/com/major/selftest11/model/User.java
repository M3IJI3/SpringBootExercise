package com.major.selftest11.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    long employeeNO;
    String username;
    String password;
    int age;
    float salary;
}
