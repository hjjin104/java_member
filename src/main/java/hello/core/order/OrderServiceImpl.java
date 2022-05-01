package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //멤버 리포지토리에서 회원을 찾기 위함
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //고정 할인 정책도 필요
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //정률 할인 정책
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //멤버를 찾기
        Member member = memberRepository.findById(memberId);

        //OrderService 입장에서 할인에 대한 것은 잘 모름. 할인에 대한 건 discountPolicy가 알아서 해.
        //단일 체계 원칙으로 잘 설계된 것!
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);

        //주문 생성 요청이 오면 회원 정보를 조회하고 할인 정책을 적용한 다음 주문 객체를 생성해서 반환
        // 메모리 회원 리포지토리와 고정 금액 할인 정책 구현체로 생성
    }
}
