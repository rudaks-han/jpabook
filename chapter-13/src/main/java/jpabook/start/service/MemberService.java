package jpabook.start.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import jpabook.start.jpo.Member;
import jpabook.start.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void register(Member member) {
        memberRepository.save(member);
    }

    public Member find(Long id) {
        Member member = memberRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("member id not exists: " + id));

        return member;
    }
}
