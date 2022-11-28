package ru.resful.booker.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenModel {

    //Имя переменной должно быть эквивалентно имени ключа JSON файла
    private String token;
}
