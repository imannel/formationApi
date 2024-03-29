package com.example.formationapi.service;

import com.example.formationapi.entity.Formation;
import com.example.formationapi.entity.Member;
import com.example.formationapi.repository.FormationRepository;
import com.example.formationapi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FormationServiceImpl implements FormationService {
    @Autowired
     private FormationRepository formationRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public List<Formation> getAllFromations() {
        return formationRepository.findAll();
    }

    @Override
    public Formation getFormationById(Long id) {
        return formationRepository.findById(id).orElseThrow(()->new RuntimeException("formation not found"));
    }

    @Override
    public Formation createFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }

    @Override
    public Formation updateFormation(long id, Formation newFormation) {
        Formation formation = formationRepository.findById(id).orElseThrow(()->new RuntimeException("formation not found"));

        formation.setTitle(newFormation.getTitle());
        formation.setDescription(newFormation.getDescription());
        formation.setDateStart(newFormation.getDateStart());
        formation.setDateEnd(newFormation.getDateEnd());
        return formationRepository.save(formation);

    }

    @Override
    public List<Formation> searchFormation(String keyword) {
        return formationRepository.searchFormation(keyword);
    }
    @Override
    public List<Member> getMembersByFormationId(Long formationId) {
        Formation formation = formationRepository.findById(formationId)
                .orElseThrow(() -> new RuntimeException("Formation not found"));
        return formation.getMembers();
    }

    @Override
    public Formation assignMemberToFormation(Long formationId, Member member) {
        Member savedMember = memberRepository.save(member);

        Formation formation = formationRepository.findById(formationId)
                .orElseThrow(() -> new RuntimeException("Formation not found"));

        List<Member> members = formation.getMembers();
        members.add(savedMember);
        formation.setMembers(members);

        return formationRepository.save(formation);
    }

    @Override
    public void removeMemberFromFormation(Long formationId, Long memberId) {
        Formation formation = formationRepository.findById(formationId).orElseThrow(() -> new RuntimeException("Formation not found"));
        formation.getMembers().removeIf(member->member.getId().equals(memberId));
        formationRepository.save(formation);
    }
}



