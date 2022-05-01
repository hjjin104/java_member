package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    //멤버 리포지토리에서 회원을 찾기 위함
    private final MemberRepository memberRepository;
    //고정 할인 정책도 필요
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //정률 할인 정책
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private DiscountPolicy discountPolicy;
    //추상(인터페이스)에만 의존할 수 있도록 코드 수정, but 구현체(구현 클래스)가 없기 때문에 NPE(null pointer exception) 발생

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

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
