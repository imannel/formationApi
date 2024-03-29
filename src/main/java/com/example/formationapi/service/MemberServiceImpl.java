package com.example.formationapi.service;


import com.example.formationapi.entity.Member;
import com.example.formationapi.entity.Formation;
import com.example.formationapi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
@Override
    public Member getMemberById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(()->new RuntimeException("Member does not exist"));

    }
@Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }
@Override
    public Member updateMember(Long memberId, Member member) {
        if (memberRepository.existsById(memberId)) {
            member.setId(memberId);
            return memberRepository.save(member);
        }
        return null;
    }
@Override
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }


@Override
    public List<Formation> getFormationsByMemberId(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return member.getFormations();
    }
    @Override
    public List<Member> searchMember(String keyword) {
        return memberRepository.searchMember(keyword);
    }


}
