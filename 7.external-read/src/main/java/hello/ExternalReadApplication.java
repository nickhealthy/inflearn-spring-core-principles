package hello;

import hello.config.MyDataSourceConfigV1;
import hello.config.MyDataSourceConfigV2;
import hello.config.MyDataSourceEnvConfig;
import hello.config.MyDataSourceValueConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Import;

//@Import(MyDataSourceEnvConfig.class)
//@Import(MyDataSourceValueConfig.class)
//@Import(MyDataSourceConfigV1.class)
/*
* @ConfigurationPropertiesScan: 컴포넌트 스캔처럼 @ConfigurationProperties 설정 정보를 찾아내서 자동으로 등록한다.
* @EnableConfigurationProperties: 하나하나 직접 등록할 때는 해당 어노테이션을 사용한다.
* */
//@ConfigurationPropertiesScan({"hello.datasource"})
@Import(MyDataSourceConfigV2.class)
@SpringBootApplication(scanBasePackages = "hello.datasource")
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
