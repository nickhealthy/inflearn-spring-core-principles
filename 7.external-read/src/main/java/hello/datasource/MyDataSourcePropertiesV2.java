package hello.datasource;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.Duration;
import java.util.List;

/**
 * 강의: 외부설정 사용 - @ConfigurationProperties 생성자
 * - 앞서 만든 `MyDataSourcePropertiesV1`에서는 자바빈 프로퍼티 설정 방식으로 인한 Setter로 값이 외부 설정 값이 변경되는 문제가 발생될 수 있다.
 * - 따라서 생성자를 사용해서 중간에 데이터를 변경하는 실수를 근본적으로 방지할 수 있다.
 * - 생성자를 만들어 두면 생성자를 통해서 설정 정보를 주입한다.
 */
@Data
@ConfigurationProperties("my.datasource")
public class MyDataSourcePropertiesV2 {

    private String url;
    private String username;
    private String password;
    private Etc etc;

    // @DefaultValue: 해당 값을 찾을 수 없는 경우 기본값을 사용한다.
    // - 타입에 따른 기본값이 들어감(null, 0 etc..)
    public MyDataSourcePropertiesV2(String url, String username, String password, @DefaultValue Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {
        private final int maxConnection;
        private final Duration timeout;
        private final List<String> options;

        // @DefaultValue("DEFAULT"): 외부 설정에서 해당 값을 찾을 수 없는 경우 해당 애노테이션을 통해 기본값으로 설정할 수 있다.
        public Etc(@DefaultValue("DEFAULT") List<String> options, Duration timeout, int maxConnection) {
            this.options = options;
            this.timeout = timeout;
            this.maxConnection = maxConnection;
        }
    }
}
