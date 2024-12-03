package memory;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * 자동 구성 추가
 *
 * - @AutoConfiguration: 스프링 부트가 제공하는 자동 구성 기능을 적용할 때 사용하는 애노테이션
 * - @ConditionalOnProperty(name = "memory", havingValue = "on")
 *   - `memory=on` 이라는 환경 정보가 있을 때 라이브러리를 적용하도록 한다.
 *
 *   스프링 부트는 시작 시점에 `org.springframework.boot.autoconfigure.AutoConfiguration.imports` 의 정보를 읽어서 자동 구성으로 사용한다.
 */
@AutoConfiguration
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryAutoConfig {

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
