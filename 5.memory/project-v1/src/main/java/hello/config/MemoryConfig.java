package hello.config;

import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링 부트 자동 구성을(AutoConfiguration)사용하는 것이 아니기 때문에
 * 스프링 부트에서 해당 라이브러리를 사용하려면 직접 빈을 등록해줘야 한다.
 *
 * - 만약 이런 방법을 채택할 시 규모가 큰 라이브러리라고 가정했을 떄 라이브러리 내부에 어떤 빈을 등록해야 하는지 알아야하고,
 * - 그것을 하나하나의 빈으로 등록해야 하는 과정이 있어야 하므로 상당히 귀찮은 작업이 될 수도 있다.
 * - 이를 방지하기 위해 스프링 부트 자동 구성을 사용한다.
 */
@Configuration
public class MemoryConfig {

    @Bean
    public MemoryFinder memoryFinder() {
        return new MemoryFinder();
    }

    @Bean
    public MemoryController memoryController() {
        return new MemoryController(memoryFinder());
    }
}
