package com.lucky.reponse.sapi.file;

import lombok.Data;

/**
 * @author shijin.huang
 * @date 2019-10-29
 * @content 文件上传返回类型
 */
@Data
public class MultipleUploadRe {
    private String fileUrl;
    private String fileUrlId;
    private String filename;
}
