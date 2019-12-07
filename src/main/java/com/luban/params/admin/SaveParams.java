package com.luban.params.admin;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shijin.huang
 * @date 2019-12-07
 * @content save api入参
 */
@Data
@Accessors(chain = true)
public class SaveParams {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年纪
     */
    private Integer age;
}
