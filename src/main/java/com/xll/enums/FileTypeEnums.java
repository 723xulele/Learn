package com.xll.enums;

import lombok.Getter;

/**
 * @Date: 2021/09/15/17:49
 * @Description:
 */
@Getter
public enum FileTypeEnums {

    FILE(0, "文件"),
    IMAGE(1, "图片");
    private Integer code;
    private String value;

    FileTypeEnums(Integer code, String value){
        this.code = code;
        this.value = value;
    }

    public static FileTypeEnums find (Integer code) {
        for (FileTypeEnums instance : FileTypeEnums.values()){
            if(instance.getCode().equals(code)){
                return instance;
            }
        }
        return null;
    }
}
