package com.xll.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author  xulele
 * @Date 2022-03-27 03:38:58 
 * @Description  
 */

@Data
@ApiModel("用户操作日志表")
@TableName("user_log")
public class UserLog  implements Serializable {

	private static final long serialVersionUID =  7288475232300250133L;

   	@ApiModelProperty(value = "用户编号" )
	private String userId;

   	@ApiModelProperty(value = "用户请求IP" )
	private String userIp;

   	@ApiModelProperty(value = "请求url" )
	private String requestUrl;

   	@ApiModelProperty(value = "请求参数" )
	private String requestParams;

   	@ApiModelProperty(value = "创建时间" )
	private Date createTime;

}
