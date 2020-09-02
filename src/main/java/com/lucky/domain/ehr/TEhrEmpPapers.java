package com.lucky.domain.ehr;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 员工证件表
 *
 * @author shijin.huang
 */

@Data
@Table(name ="t_ehr_emp_papers")
public class TEhrEmpPapers implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 关联员工id
     */
    private Long empId;

    /**
     * 健康证状态(0:异常，1:正常，2:临期，3:过期)
     */
    private Integer papersStatus;

    /**
     * 有效期开始时间
     */
    private LocalDateTime validBegin;

    /**
     * 有效期结束时间
     */
    private LocalDateTime validEnd;

    /**
     * 证件照片1路径
     */
    private String image1;

    /**
     * 证件照片2路径
     */
    private String image2;

    /**
     * 修改状态(0:未上传,1:待审核,2:已生效,3:未通过)
     */
    private Integer modifyStatus;

    /**
     * 修改证件有效期开始时间
     */
    private LocalDateTime modifyValidBegin;

    /**
     * 修改证件有效期结束时间
     */
    private LocalDateTime modifyValidEnd;

    /**
     * 修改证件照片1路径
     */
    private String modifyImage1;

    /**
     * 修改证件照片2路径
     */
    private String modifyImage2;

    /**
     * 关联证件不合格表id
     */
    private Long modifyRejectId;


    /**
     * 创建人
     */
    private Long createEmp;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime modifyTime;

    /**
     * 修改人
     */
    private Long modifyEmp;

    /**
     * 是否可用0:正常,1:已删除
     */
    private Boolean isDeleted;

    /**
     * 备注
     */
    private String remark;



    }
