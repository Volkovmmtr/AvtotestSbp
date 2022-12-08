package ru.resful.booker.DB;

import org.aeonbits.owner.Config;

@Config.Sources({"file:./src/main/resources/db.properties"})
public interface DBConfig extends Config {

    @Key("db.psql_url")
    String getPsqlUrl();

    @Key("db.psql_user_name")
    String getPsqlUsername();

    @Key("db.psql_user_pass")
    String getPsglPassword();

    @Key("db.oracle_url")
    String getOracleUrl();

    @Key("db.oracle_user_name")
    String getOracleName();

    @Key("db.oracle_user_pass")
    String getOraclePassword();


}
