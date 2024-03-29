package com.example.formationapi.service;

import com.example.formationapi.entity.Formation;
import com.example.formationapi.entity.Member;
import com.example.formationapi.repository.MemberRepository;


import java.util.List;

public interface FormationService {
    public List<Formation> getAllFromations();
    public Formation getFormationById(Long id);
    public Formation createFormation(Formation formation);
    public void deleteFormation(Long id);
    public Formation updateFormation(long id, Formation newFormation);
    public List<Formation> searchFormation(String keyword);

    List<Member> getMembersByFormationId(Long formationId);
    public Formation assignMemberToFormation(Long formationId, Member member);
    public void removeMemberFromFormation(Long formationId, Long memberId);
}
