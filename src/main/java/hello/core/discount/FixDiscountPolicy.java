package hello.core.discount;

import hello.core.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        //등급이 VIP 여야만 할인된다는 조건
        if(member.getGrade()== Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
}
