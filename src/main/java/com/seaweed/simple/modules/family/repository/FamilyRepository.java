package com.seaweed.simple.modules.family.repository;

import com.seaweed.simple.modules.family.model.FamilyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends JpaRepository<FamilyEntity,Long> {

}
