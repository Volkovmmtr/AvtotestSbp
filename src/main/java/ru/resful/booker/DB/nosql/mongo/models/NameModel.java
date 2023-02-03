package ru.resful.booker.DB.nosql.mongo.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NameModel {
    Integer id;
    String name;
}
