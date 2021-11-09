package ink.ckx.easyexcel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chenkaixin
 * @since 2021/11/6
 */
@MapperScan("ink.ckx.easyexcel.mapper")
@SpringBootApplication
public class EasyExcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcelApplication.class, args);
    }
}
