package hello;

import hello.config.*;
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
//@Import(MyDataSourceConfigV2.class)

/**
 * ConfigurationProperties 덕분에 최종적으로 '타입 안전' + '검증' 효과를 얻을 수 있었으며, 또 매우 편리하게 외부 설정을 사용할 수 있었다.
 */
@Import(MyDataSourceConfigV3.class)
@SpringBootApplication(scanBasePackages = "hello.datasource")
public class ExternalReadApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExternalReadApplication.class, args);
    }

}
