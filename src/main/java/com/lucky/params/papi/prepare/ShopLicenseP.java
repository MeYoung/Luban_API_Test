package com.lucky.params.papi.prepare;

import lombok.Data;

/**
 * @author shue.li
 * @date 2020/6/16 14:22
 * @content 门店证照
 */
@Data
public class ShopLicenseP {
    private String shopNcCode;
    private int shopLicenseType;
    private String principalName;
    private String principalPhone;
    private int applyAuditType;
    private String expireTime;
    private int isForever;
    private OriginLicenseFileP originLicenseFile;
}
