package spring.boot.rest.base_api.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan("spring.boot.rest")
public class SpringBootWebApplication extends SpringBootServletInitializer implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(SpringBootWebApplication.class);

    @Autowired
    DataSource dataSource;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootWebApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {
        //应用起来后,先尝试关闭db连接,避免一些冷门应用,无人访问占用连接资源，同时也测试db连接关闭是否正常
        try {
            dataSource.getConnection().close();
            logger.info("db连接正常关闭");
        } catch (Exception e) {
            logger.error("db连接关闭失败:", e);
        }
    }
}