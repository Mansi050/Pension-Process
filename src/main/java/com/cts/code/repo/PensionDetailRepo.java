package com.cts.code.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.code.entity.PensionDetail;

@Repository
public interface PensionDetailRepo extends JpaRepository<PensionDetail,String> {

}
