package com.xll.controller;

import com.xll.utils.VcodePictureUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Date: 2021/09/20/15:40
 * @Description:
 */
@RestController
@RequestMapping("/vcode")
@Api(tags = "图形验证码接口")
public class VcodePictureController {

    @Resource
    private RedisTemplate redisTemplate;

    /**
     * 获取图形验证码
     * @param response
     * @param ranStr
     * @throws IOException
     */
    @RequestMapping(value = "/output", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取图形验证码接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ranStr", value = "随机码", required = false, dataType = "string")})
    public void output(HttpServletResponse response, String ranStr) throws IOException {
//        response.setContentType("image/jpeg");
//        response.setHeader("Pragma", "no-cache");
//        response.setHeader("Cache-Control", "no-cache");
//        response.setDateHeader("Expires", 0);
        VcodePictureUtil instance = new VcodePictureUtil();
        instance.write(response.getOutputStream());
        System.out.println(instance.getCode());
        redisTemplate.opsForValue().set(ranStr,instance.getCode(),60, TimeUnit.SECONDS);
    }
}
