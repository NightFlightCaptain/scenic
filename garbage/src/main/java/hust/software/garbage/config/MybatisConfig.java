package hust.software.garbage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: 小栗旬
 * @Date: 2019/10/22 22:40
 */
@Configuration
@EnableTransactionManagement
@MapperScan("hust.software.garbage.mgb.mapper")
public class MybatisConfig {
}
