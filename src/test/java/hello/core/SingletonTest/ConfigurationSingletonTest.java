package hello.core.SingletonTest;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.order.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1.조회: 호출할 때마다 같은 객체 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        //2.조회: 호출할 때마다 같은 객체 반환
        OrderService orderService = ac.getBean("orderService", OrderService.class);


        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
        //참조값이 같은 것 확인
        System.out.println("memberService1 = "+ memberService1);
        System.out.println("orderService = "+ orderService);
        System.out.println("memberRepository = "+ memberRepository);
    }
}
