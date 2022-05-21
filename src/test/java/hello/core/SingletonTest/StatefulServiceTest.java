package hello.core.SingletonTest;

import hello.core.beanfind.ApplicationContextExtendsFindTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: 사용자 A가 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB: 사용자 B가 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA: 사용자 A가 주문 금액 조회
        int price = statefulService1.getPrice();

        //기댓값은 1000원이지만 20000원을 출력
        //사용자 A의 주문 후 사용자 B가 주문을 바꿔버렸기 때문
        System.out.println("price = "+price);

        assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
