package com.server.loop.common.converter;

import com.server.loop.common.constant.Status;
import jakarta.persistence.Converter;


@Converter(autoApply = true)
public class StatusConverter extends BaseEnumConverter<Status, Integer>{

    public StatusConverter() {
        super(Status.class);
    }
}