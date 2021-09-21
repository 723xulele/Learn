package com.xll.mapper;

import com.xll.model.po.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface StudentMapper extends BaseMapper<Student> {

}
