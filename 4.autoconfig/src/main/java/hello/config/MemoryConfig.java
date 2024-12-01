package hello.config;

import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * 메모리 관련 라이브러리 설정
 *
 * @Conditional(MemoryCondition.class) - matches() 가 true 일때만 해당 빈 적용
 * - Condition 인터페이스를 구현한다.
 *
 * @ConditionalOnProperty(name = "memory", havingValue = "on")
 * - 스프링이 제공하는 @ConditionalOnXXX
 * - 앞서 만든 것과 동일하게 @Conditional(OnPropertyCondition.class) 어노테이션을 사용하고 있고,
 * - 그 안에는 내부적으로 Condition 인터페이스를 구현한 OnPropertyCondition 클래스가 있다.
 */
@Configuration
//@Conditional(MemoryCondition.class)
@ConditionalOnProperty(name = "memory", havingValue = "on")
public class MemoryConfig {

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }
}
