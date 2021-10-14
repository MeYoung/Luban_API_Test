package otp.lucky.reponse.sapi.postman;

import lombok.Data;

/**
 * @author shijin.huang
 * @date 2019-12-05
 * @content 配送团队状态接口Response
 */
@Data
public class OverviewRe {
    private Integer busyCount;
    private Integer idleCount;
    private Integer innerCount;
    private Integer offDutyCount;
    private Integer onDutyCount;
    private Integer outerCount;
}
