package com.lucky.params.papi.prepare;

import lombok.Data;

import java.util.List;

/**
 * Created by liping.li on 2020-06-12
 * <p>
 * 提交房屋交割单
 */


@Data
public class SaveHousesDeliveryP {

    /**
     * 意向项目编号
     */
    private String applyProjectNo;


    /**
     * 房租交割单名称/url
     */
    private List<HousesDeliveryFileP> housesDeliveryFile;


}


