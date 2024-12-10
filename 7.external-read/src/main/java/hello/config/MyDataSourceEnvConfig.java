package hello.config;

import hello.datasource.MyDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.time.Duration;
import java.util.List;


@Slf4j
@Configuration
public class MyDataSourceEnvConfig {

    private final Environment env;

    public MyDataSourceEnvConfig(Environment env) {
        this.env = env;
    }

    /**
     * 아래와 같이 Environment`를 사용하면
     * 외부 설정의 종류와 관계없이 코드 안에서 일관성 있게 외부 설정을 조회할 수 있다.
     *
     * getProperty(key, Type)를 호출할 때 타입 정보를 주면 해당 타입으로 변환해준다.
     * - 스프링 내부 변환기가 작동한다.
     * - 스프링은 다양한 타입들에 대해서 기본 변환 기능을 제공한다.
     */
    @Bean
    public MyDataSource myDataSource() {
        String url = env.getProperty("my.datasource.url");
        String username = env.getProperty("my.datasource.username");
        String password = env.getProperty("my.datasource.password");
        Integer maxConnection = env.getProperty("my.datasource.etc.max-connection", Integer.class);
        Duration timeout = env.getProperty("my.datasource.etc.timeout", Duration.class);
        List options = env.getProperty("my.datasource.etc.options", List.class);

        return new MyDataSource(url, username, password, maxConnection, timeout, options);
    }
}
