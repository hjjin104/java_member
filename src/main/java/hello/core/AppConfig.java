package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;

public class AppConfig {
    //어디서든 AppConfig를 통해 멤버 서비스를 불러다 쓸 수 있음
    //생성자 주입

    //@Bean : 스프링 컨테이너에 등록하겠다
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
    @Bean
    public OrderService orderService(){
        //구체적인 것을 여기서 선택하도록 함
        //생성자 주입
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
    @Bean
    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    private DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
