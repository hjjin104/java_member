package hello.core.member;

import hello.core.AppConfig;
import hello.core.Grade;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class MemberServiceTest {

    MemberService memberService;

    //@BeforeEach : 각 테스트 시작 전 무조건 실행이 되는 것
    @BeforeEach
    public void beforeEach(){
        //AppConfig를 만들고 멤버 서비스 할당
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();

    }

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
