package com.server.loop.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum VoteType implements BaseEnum<String> {

    FIT("fit"),
    SKIP("skip");

    private final String value;

}
