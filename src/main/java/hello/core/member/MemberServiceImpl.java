package hello.core.member;

public class MemberServiceImpl implements MemberService{
    //가입을 하고 회원을 찾으려면 앞서 만든 MemberRepository 인터페이스가 필요함

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
