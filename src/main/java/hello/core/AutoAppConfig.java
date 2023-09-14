package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan ( //@Component 어노테이션 붙은 것들 찾아서 스프링 빈 등록해준다
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 수동으로 등록하는 AppConfig 제외
)
public class AutoAppConfig {

    @Bean(name= "memoryMemberRepository") // 수동 빈 등록과 자동 빈 등록에서 빈 이름이 충돌되면?
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
