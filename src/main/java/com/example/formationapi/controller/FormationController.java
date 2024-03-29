package com.example.formationapi.controller;

import com.example.formationapi.entity.Formation;
import com.example.formationapi.entity.Member;
import com.example.formationapi.service.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/formations")
@CrossOrigin("*")

public class FormationController {
    private final FormationService formationService;

    @Autowired
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping
    public List<Formation> getAllFormations() {
        return formationService.getAllFromations();
    }

    @GetMapping("/{id}")
    public Formation getFormationById(@PathVariable Long id) {
        return formationService.getFormationById(id);

    }

    @PostMapping
    public ResponseEntity<Formation> createFormation(@RequestBody Formation formation) {
        Formation createdFormation = formationService.createFormation(formation);
        return new ResponseEntity<>(createdFormation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formation> updateFormation(@PathVariable Long id, @RequestBody Formation newFormation) {
        Formation updatedFormation = formationService.updateFormation(id, newFormation);
        if (updatedFormation != null) {
            return new ResponseEntity<>(updatedFormation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFormation(@PathVariable Long id) {
        formationService.deleteFormation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public List<Formation> searchFormations(@RequestParam(name="keyword",defaultValue = "")String keyword){
        return formationService.searchFormation("%"+keyword+"%");
    }
    @GetMapping("/membersByFormation/{formationId}")
    public List<Member> getMembersByFormationId(@PathVariable Long formationId) {
        return formationService.getMembersByFormationId(formationId);
    }
    @PutMapping("/{formationId}/members")
    public Formation assignMemberToFormation(@PathVariable Long formationId, @RequestBody Member member) {
        return formationService.assignMemberToFormation(formationId, member);
    }
    @DeleteMapping("/{formationId}/members/{memberId}")
    public ResponseEntity<?> removeMemberFromFormation(@PathVariable Long formationId, @PathVariable Long memberId) {
        formationService.removeMemberFromFormation(formationId, memberId);
        return ResponseEntity.ok().build();
    }
}
