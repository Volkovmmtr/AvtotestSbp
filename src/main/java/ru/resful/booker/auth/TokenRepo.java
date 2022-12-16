package ru.resful.booker.auth;

import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.clientFactorys.ConverterType;
import ru.resful.booker.models.universal.UserModel;

import java.io.IOException;

public class TokenRepo {


    public static String getToken(UserModel user) throws IOException {
        //токены можно получить только json запросом, поэтому хардкод
        return ClientFactory.getClient(ConverterType.JSON).getToken(user).execute().body()
                .replaceAll(".*:\"","").replace("\"}","");

    }
}
