package com.cts.code.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.code.entity.PensionDetail;
import com.cts.code.entity.PensionerDeatil;
import com.cts.code.proxy.ProcessPensionProxy;
import com.cts.code.repo.PensionDetailRepo;
import com.cts.code.repo.ProcessRepository;
//import com.cts.code.repo.PensionDetailRepo;
//import com.cts.code.repo.ProcessRepository;
import com.cts.code.service.ProcessPensionService;

import ch.qos.logback.classic.Logger;

@RestController
@CrossOrigin(origins = "*")
public class ProcessPensionController {
	
	Logger logger = (Logger) LoggerFactory.getLogger(ProcessPensionController.class);
	
	@Autowired
	ProcessPensionProxy proxy;
	
	@Autowired
	ProcessPensionService calcuatePensionService;
	
	@Autowired
	ProcessRepository repository;
	
	@Autowired
	PensionDetailRepo repo;
	
	@GetMapping("/get-health")
	public ResponseEntity<?> healthCheckMethod() {
		logger.debug("Health check method");
		return ResponseEntity.ok("Health check successful");
	}
	
	@PostMapping("/process-pension/{adharCard}")
	public PensionDetail getValue(@RequestHeader(name="Authorization") String token, @PathVariable("adharCard") Long adharCard) throws Exception{
		try {
		logger.info("Getting details based on Aadhar Card");
		PensionerDeatil retrieveDetail = proxy.retrieveDetail(token, adharCard); //Retrieving Data based on Aadhar
		repository.save(retrieveDetail); //Saving Data
		if(retrieveDetail.getBankName()!=null) {
		logger.info("Calculating values based on Aadhar Card");
		PensionDetail calculatePension = calcuatePensionService.calculatePension(retrieveDetail); //ctrl+1 to local varible
		repo.save(calculatePension);
		
		return calculatePension;	
		} else {
			logger.info("Wrong Adhar Number");
			return null;
		}
		}
		catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
		
	}
	
	

}
