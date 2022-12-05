package ru.resful.booker.auth;

import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.models.UserModel;

import java.io.IOException;

public class TokenRepo {


    public static String getToken(UserModel user) throws IOException {
        return ClientFactory.getClient().getToken(user).execute().body()
                .replaceAll(".*:\"","").replace("\"}","");
    }
}
