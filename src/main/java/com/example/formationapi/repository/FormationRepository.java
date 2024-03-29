package com.example.formationapi.repository;

import com.example.formationapi.entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FormationRepository extends JpaRepository<Formation,Long> {
     @Query ("select f from Formation f where f.title like :kw")
     List<Formation> searchFormation(@Param("kw")String keyword);
}
