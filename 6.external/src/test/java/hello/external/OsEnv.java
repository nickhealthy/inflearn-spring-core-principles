package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * OS 환경변수 외부설정
 * - 아래와 같이 System.getenv() 메서드를 통해 OS 환경 변수를 조회할 수 있다.
 * - 개발/운영 서버 별로 환경 변수 등록을 다르게 해 System.getenv("변수명") 방식으로 조회하면 서버 별로 다른 환경을 구성할 수 있다.
 */
@Slf4j
public class OsEnv {

    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            log.info("env {}={}", key, System.getenv(key));
        }
    }
}
