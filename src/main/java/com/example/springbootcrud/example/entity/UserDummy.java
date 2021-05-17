package com.example.springbootcrud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDummy {
    private String name;
    private String hp;
    private String email;
    private List<String> alamat;
}
