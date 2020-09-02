package com.lucky.params.papi.business;

import lombok.Data;

/**
 * Created by liping.li on 2020-05-19
 * <p>
 * 租房合同与产权证明 P
 */

@Data
public class HouseCertificationInfoP {

    /**
     * 意向项目编号
     */
    private String applyProjectNo;

    /**
     * 产权证明图片url
     */
    private String houseCertificateUrl;

    /**
     * 产权证明名称
     */
    private String houseCertificateName;

    /**
     * 租房合同图片url
     */
    private String rentHouseCertificateUrl;

    /**
     * 租房合同名称
     */
    private String rentHouseCertificateName;

    /**
     * 租房开始时间
     */
    private String rentHouseBeginTime;

    /**
     * 租房结束时间
     */
    private String rentHouseEndTime;

}
