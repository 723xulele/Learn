package com.xll.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author xulele
 * @Date: 2022/04/01/23:41
 * @Description: 自定义结果集实体类
*/
@ApiModel(value = "返回实体类")
public class R<T> {

    @ApiModelProperty("状态码 0:正常 1:错误")
    private Integer status;

    @ApiModelProperty("返回信息")
    private String msg = "操作成功";

    @ApiModelProperty("返回数据对象")
    private T data;

    @JsonIgnore
    private transient Boolean ok;
    @JsonIgnore
    private transient Boolean error;

    public R() {

    }

    public R(Integer status) {
        this.status = status;
    }

    public R(Integer status,String msg) {
        this.status = status;
        this.msg = msg;
    }

    public R(T data) {
        this.data = data;
    }

    public R(Integer status,String msg,T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static R<String> ok(){
        return new R(Constant.RESPONSE.success);
    }

    public static R<String> error(){
        return new R(Constant.RESPONSE.error);
    }

    public static <E> R<E> ok(E E) {
        R<E> result = new R<E>();
        result.setStatus(Constant.RESPONSE.success);
        result.setData(E);
        return result;
    }

    public static R<String> error(String msg){
        R<String> result = new R<>();
        result.setStatus(Constant.RESPONSE.error);
        result.setMsg(msg);
        return result;
    }

    public static <E> R<E> error(E E,String msg){
        R<E> result = new R<>();
        result.setStatus(Constant.RESPONSE.error);
        result.setMsg(msg);
        result.setData(E);
        return result;
    }

    public boolean isOk(){
        if(this.status == null) {
            this.ok = false;
        }
        this.ok = this.status == Constant.RESPONSE.success;
        return this.ok;
    }

    public boolean isError(){
        if (this.status == null) {
            this.error = true;
        }
        this.error = this.status != Constant.RESPONSE.success;
        return this.error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
