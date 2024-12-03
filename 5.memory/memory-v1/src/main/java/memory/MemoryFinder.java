package memory;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

/**
 * 외부에서 가져다 쓰는 '라이브러리'라고 가정
 *
 * JVM에서 메모리 정보를 실시간으로 조회하는 기능이다.
 * max는 JVM이 사용할 수 있는 최대 메모리, 이 수치를 넘어가면 OOM(Out Of Memory)이 발생한다.
 * total은 JVM이 확보한 전체 메모리(JVM은 처음부터 max까지 다 확보하지 않고 필요할 때마다 조금씩 확보한다.)
 * free는 total 중에 사용하지 않은 메모리(JVM이 확보한 전체 메모리 중에 사용하지 않은 것)
 */
@Slf4j
public class MemoryFinder {

    public Memory get() {
        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        long used = total - free;
        return new Memory(used, max);
    }

    @PostConstruct
    public void init() {
        log.info("init memoryFinder");
    }
}
