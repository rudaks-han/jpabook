package jpabook.start.service;

import jpabook.start.jpo.Member;
import jpabook.start.repository.MemberRepository;
import jpabook.start.repository.NoResultExceptionTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Transactional
public class MemberService {
    @Autowired
    private NoResultExceptionTestRepository noResultExceptionTestRepository;

    @Autowired
    private MemberRepository memberRepository;

    public void register(Member member) {
        memberRepository.save(member);
    }

    public Member find(Long id) {
        return memberRepository.findOne(id);
    }

    public Member findAll() {
        return noResultExceptionTestRepository.findAllMember();
    }

}
