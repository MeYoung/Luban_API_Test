package com.lucky.domain.partner;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;


/**
 * 城市水质表
 *
 * @author liping.li
 */

@Data
@Table(name ="t_city_water_quality")
public class TCityWaterQuality implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 水质参考枚举WaterQualityEnum
     */
    private Integer waterQualityType;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改人
     */
    private String modifierName;

    /**
     * 修改时间
     */
    private LocalDateTime modifyTime;


}
