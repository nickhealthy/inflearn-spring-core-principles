package hello.datasource;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;
import java.util.List;

/**
 * 강의: 외부설정 사용 - @ConfigurationProperties 검증
 * - 검증기 덕분에 애플리케이션 로딩 시점에서 편리하게 설정 정보를 검증할 수 있다.
 */
@Getter
@ConfigurationProperties("my.datasource")
@Validated
public class MyDataSourcePropertiesV3 {

    @NotEmpty
    private final String url;
    @NotEmpty
    private final String username;
    @NotEmpty
    private final String password;
    private final Etc etc;

    public MyDataSourcePropertiesV3(String url, String username, String password, Etc etc) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.etc = etc;
    }

    @Getter
    public static class Etc {
        @Min(1)
        @Max(999)
        private final int maxConnection;
        @DurationMin(seconds = 1)
        @DurationMax(seconds = 60)
        private final Duration timeout;
        private final List<String> options;

        public Etc(List<String> options, Duration timeout, int maxConnection) {
            this.options = options;
            this.timeout = timeout;
            this.maxConnection = maxConnection;
        }
    }
}
