package hello.core;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args){
        //AppConfig를 하나 만들어서 이를 통해 멤버 서비스를 생성
//        AppConfig appConfig = new AppConfig();
//
//        MemberService memberService = appConfig.memberService(); //new MemberServiceImpl();

        /*
        스프링은 모든 것이 ApplicationContext라는 것으로 실행
        AppConfig에 있는 환경설정 정보를 가지고 스프링 컨테이너에 넣고 관리함
         */

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        //new Member(1L, "memberA", Grade.VIP);
        //이 상태에서 command+option+v 를 누르면 아래의 내용과 같이 자동생성 됨
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        //확인해보기
        Member findMember = memberService.findMember(1L);
//        memberService.findMember(1L);
        System.out.println("new member: "+ memberA.getName());
        System.out.println("find member: "+ memberA.getName());

    }
}
