package ru.resful.booker.auth;

import ru.resful.booker.clientFactorys.ClientFactory;
import ru.resful.booker.models.UserModel;

import java.io.IOException;

public class TokenRepo {
    public static String getToken(UserModel user) throws IOException {
    // ToDo убрать модельку "Ради одного стрингового значения модельку заводить ненадо" (Школа Ренесанса)
        return ClientFactory.anonimClient().getToken(user).execute().body().getToken();
    }
}
