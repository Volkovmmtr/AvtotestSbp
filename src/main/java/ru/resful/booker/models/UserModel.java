package ru.resful.booker.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserModel {

    private String username;
    private String password;
}
