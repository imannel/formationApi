package com.example.formationapi.service;

import com.example.formationapi.entity.Formation;
import com.example.formationapi.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();

    Member getMemberById(Long memberId);

    Member createMember(Member member);

    Member updateMember(Long memberId, Member member);

    void deleteMember(Long memberId);

    List<Formation> getFormationsByMemberId(Long memberId);
    public List<Member> searchMember(String keyword);

    }
