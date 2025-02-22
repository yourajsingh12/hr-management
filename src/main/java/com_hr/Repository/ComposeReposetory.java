package com_hr.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com_hr.Entity.ComposeEntity;

@Repository
public interface ComposeReposetory extends JpaRepository<ComposeEntity,Integer>
{
 public List<ComposeEntity>findByParentUkid(Integer parentUkid);
	
}
