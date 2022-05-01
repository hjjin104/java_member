package hello.core.member;

import hello.core.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    //테스트할 기능
    void join(){
        //given: 이러이러한 것이 주어졌을 때
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when:이렇게 했을 때
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then: 이런 결과가 나온다
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
