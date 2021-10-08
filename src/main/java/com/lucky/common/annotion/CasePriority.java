package com.lucky.common.annotion;

import io.qameta.allure.SeverityLevel;

/**
 * @Author shijin.huang
 * @Date 2021/10/08
 */
public enum CasePriority {

//    P0("blocker"),
    P0("blocker"),
    P1(SeverityLevel.CRITICAL.value()),
    P2(SeverityLevel.NORMAL.value()),
    P3(SeverityLevel.MINOR.value());

    private final String value;

    CasePriority(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }
}
