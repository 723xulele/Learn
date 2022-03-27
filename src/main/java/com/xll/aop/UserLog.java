package com.xll.aop;

import java.lang.annotation.*;

/**
 * @Author xulele
 * @Date: 2022/03/27/14:04
 * @Description:
 */
// Type代表可以放在类上面 Method代表可以放在方法上面
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserLog {

    String value() default  "";
}
