package hello.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * `@Profile` 애노테이션을 사용하면 해당 프로필이 활성화된 경우에만 빈을 등록한다.
 * - `default` 프로필(기본값)이 활성화 되어 있으면 `LocalPayClient` 를 빈으로 등록한다.
 * - `prod` 프로필이 활성화 되어 있으면 `ProdPayClient` 를 빈으로 등록한다.
 */
@Slf4j
@Configuration
public class PayConfig {

    @Bean
    @Profile("default")
    public LocalPayClient localPayClient() {
        log.info("LocalPayClient 빈 등록");
        return new LocalPayClient();
    }

    @Bean
    @Profile("prod")
    public ProdPayClient prodPayClient() {
        log.info("ProdPayClient 빈 등록");
        return new ProdPayClient();
    }
}
