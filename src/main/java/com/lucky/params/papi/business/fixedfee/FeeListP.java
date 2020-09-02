package com.lucky.params.papi.business.fixedfee;

import lombok.Data;

import java.util.List;

/**
 * @author 左轮(haiyong.he @ luckincoffee.com)
 * @desc
 * @name FeeListP
 * @date 2020/5/8
 **/
@Data
public class FeeListP {

    private String applyProjectNo;
    /**
     * 缴费日期（月度费用才有值）
     */
    private String paymentDate;
    private List<FixedFeeP> feeParam ;
}
