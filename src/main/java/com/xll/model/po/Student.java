package com.xll.model.po;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Date: 2021/09/14/14:29
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "学生类")
public class Student implements Serializable {

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String user_name;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "籍贯")
    private String address;

    @ApiModelProperty(value = "生日")
    private Date birthday;
}
