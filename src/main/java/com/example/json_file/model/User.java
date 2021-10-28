package com.example.json_file.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private Integer id;
    private String username;
    private String password;
    private Address address;
}
