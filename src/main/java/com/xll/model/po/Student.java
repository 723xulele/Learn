package com.xll.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 学生表
 * </p>
 *
 * @author xulele
 * @since 2021-09-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学生类")
@TableName("student")
public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生姓名
     */
    @ApiModelProperty(value = "姓名")
    private String userName;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 籍贯
     */
    @ApiModelProperty(value = "籍贯")
    private String address;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private Date birthday;
}
