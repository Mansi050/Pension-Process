package com.cts.code.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.code.entity.PensionerDeatil;

@Repository
public interface ProcessRepository extends JpaRepository<PensionerDeatil, String> {
	
	

}
