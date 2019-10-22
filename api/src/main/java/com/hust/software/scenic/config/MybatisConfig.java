package com.hust.software.scenic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 小栗旬
 * @Date: 2019/10/22 22:40
 */
@Configuration
@MapperScan("com.hust.software.scenic.mgb.mapper")
public class MybatisConfig {
}
