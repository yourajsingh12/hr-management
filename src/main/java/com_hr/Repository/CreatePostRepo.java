package com_hr.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com_hr.Entity.CreatePost;

@Repository
public interface CreatePostRepo extends JpaRepository<CreatePost,Integer>
{

	
	
}
