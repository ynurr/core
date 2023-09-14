package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan ( //@Component 어노테이션 붙은 것들 찾아서 스프링 빈 등록해준다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 수동으로 등록하는 AppConfig 제외
)
public class AutoAppConfig {
}
