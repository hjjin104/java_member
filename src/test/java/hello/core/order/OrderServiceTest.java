package hello.core.order;

import hello.core.AppConfig;
import hello.core.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

        MemberService memberService;
        OrderService orderService;

        @BeforeEach
        public void beforeEach(){
            AppConfig appConfig = new AppConfig();
            memberService = appConfig.memberService();
            orderService = appConfig.orderService();
        }

        @Test
        void crateOrder() {
            /**
             * long을 사용해도 되지만 이를 쓰면 null을 넣을 수 없음
             * 이후에 DB 생성시 null을 사용할 수 있기 때문에 미리 고려
             */

            Long memberId = 1L;
            Member member = new Member(memberId, "Jin", Grade.VIP);
            memberService.join(member);

            Order order = orderService.createOrder(memberId, "Apple", 3000);

            Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
        }
}
