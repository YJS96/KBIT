package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

public interface TimeMapper {
    @Select("SELECT sysdate() FROM dual")
    public String getTime();
    public String getTime2();

    @Configuration
    @MapperScan(basePackages = {"org.scoula.mapper"})
    public class RootConfig {

    }

}
