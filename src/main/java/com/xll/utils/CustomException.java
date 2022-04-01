package com.xll.utils;

import org.springframework.core.NestedRuntimeException;

import java.io.Serializable;

/**
 * @Author xulele
 * @Date: 2022/04/01/23:27
 * @Description: 自定义异常类
 */
public class CustomException extends NestedRuntimeException implements Serializable {


    private static final long serialVersionUID = -7038347592965206721L;

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
