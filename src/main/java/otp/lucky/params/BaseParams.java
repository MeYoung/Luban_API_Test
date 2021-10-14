package otp.lucky.params;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author shijin.huang
 * @date 2019-12-02
 * @content 公共的参数
 */
@Data
@Accessors(chain = true)
public class BaseParams {
    /**
     * APP版本
     */
    private String appversion;
    /**
     * 页码
     */
    private Integer offset;

    /**
     * 条目数
     */
    private Integer pageSize;


}
