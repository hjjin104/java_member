package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //가입을 하고 회원을 찾으려면 앞서 만든 MemberRepository 인터페이스가 필요함


    private final MemberRepository memberRepository;
    // MemberServiceImpl는 MemoryMemberRepository를 의존하지 않음
    /*
    단지 MemberRepository 인터페이스만 의존
    MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지(주입될 지) 알 수 없다
    MemberServiceImpl의 생성자를 통해 어떤 구현 객체를 주입할지는 오직 외부 (AppConfig)에서 결정
    MemberServiceImpl은 이제부터 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중
     */
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
