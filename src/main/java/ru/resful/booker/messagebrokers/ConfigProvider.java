package ru.resful.booker.messagebrokers;

import lombok.Getter;
import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {

    @Getter
    private static final BrokersConfig messageConfigProps = ConfigFactory.newInstance().create(BrokersConfig.class);
}
