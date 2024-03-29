package com.example.formationapi.controller;

import com.example.formationapi.entity.Formation;
import com.example.formationapi.entity.Member;
import com.example.formationapi.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("members")
@CrossOrigin("*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return memberService.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }
    @GetMapping("/formationsByMember/{memberId}")
    public List<Formation> getFormationsByMemberId(@PathVariable Long memberId) {
        return memberService.getFormationsByMemberId(memberId);
    }
    @GetMapping("/search")
    public List<Member> searchMembers(@RequestParam(name="keyword",defaultValue = "")String keyword){
        return memberService.searchMember("%"+keyword+"%");
    }


}

