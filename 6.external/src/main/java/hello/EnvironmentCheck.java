package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 스프링은 Environment와 PropertySource 추상화를 통해 key=value 값의 외부 설정 값을 일관성 있게 사용할 수 있도록 제공한다.
 *
 * org.springframework.core.env.PropertySource: 스프링은 로딩 시점에 필요한 PropertySource들을 생성하고, Environment에서 사용할 수 있게 연결해둔다.
 * org.springframework.core.env.Environment: 특정 외부 설정에 종속되지 않고, 일관성 있게 key=value 형식의 외부 설정에 접근할 수 있다.
 * - 모든 외부 설정은 이제 Environment를 통해 조회하면 된다.
 */
@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment env;

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        String url = env.getProperty("url");
        String username = env.getProperty("username");
        String password = env.getProperty("password");

        log.info("env url = {}", url);
        log.info("env username = {}", username);
        log.info("env password = {}", password);

    }
}
