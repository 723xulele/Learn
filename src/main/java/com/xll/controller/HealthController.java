package com.xll.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/09/26/19:16
 * @Description:
 */
@RestController
@RequestMapping
@Api(tags = "健康监控")
public class HealthController {

    @GetMapping("/health")
    @ApiOperation("健康监控")
    public String health() {
        return "health";
    }
}
