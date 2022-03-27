package com.xll.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xll.model.po.UserLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 学生表 Mapper 接口
 * </p>
 *
 * @author xulele
 * @since 2021-09-22
 */
@Mapper
public interface UserLogMapper extends BaseMapper<UserLog> {

}
