package hello.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Import에 설정 정보를 추가하는 방법은 정적인 방법(보통 @Configuration)과
 * 동적인 방법(ImportSelector 인터페이스 구현)이 있는데,
 * 아래는 동적인 방법으로 구현하는 것을 보여준다.
 * - 아래 예제에서는 단순히 `hello.selector.HelloConfig` 설정 정보를 반환한다/
 */
public class HelloImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"hello.selector.HelloConfig"};
    }
}
