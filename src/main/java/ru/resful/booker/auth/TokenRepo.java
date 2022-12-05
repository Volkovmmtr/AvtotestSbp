package ru.resful.booker.auth;

import com.google.gson.JsonObject;
import lombok.SneakyThrows;
import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.models.UserModel;

import java.io.IOException;

public class TokenRepo {


    public static String getToken(UserModel user) throws IOException {
        return ClientFactory.anonimClient().getToken(user).execute().body()
                .replaceAll(".*:\"","").replace("\"}","");
    }
}
