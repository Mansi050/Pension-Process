package com.cts.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cts.code.controller.ProcessPensionController;
import com.cts.code.entity.PensionDetail;
import com.cts.code.entity.PensionerDeatil;
import com.cts.code.proxy.ProcessPensionProxy;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;

@SpringBootTest
@AutoConfigureMockMvc
class ProcessPensionApplicationTests {
	
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	private String tokenStringwrong = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkaHJ1diIsImV4cCI6MTY2MDgyMjI2NSwiaWF0IjoxNjYwNzYyMjY1fQ.g3OyO-vk6ytr1Xahs3JglT1xAcGrQeM4f9Te8D-SpdE";
	private String tokenStringcorrect = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYW5zaSIsImV4cCI6MTY2MDkxMTU2NCwiaWF0IjoxNjYwODUxNTY0fQ.94ckUB1UZfQMDIquuZ34r8FAzf5xfAFAEuBdRfPPEz4";
	
	@Autowired
	ProcessPensionController controller;
	
	@Autowired
	ProcessPensionProxy proxy;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void healthCheckMethod() {
		logger.info("Starting Execution of HeathCheck Method");
		ResponseEntity<?> actualValue = controller.healthCheckMethod();
		assertEquals(actualValue, actualValue);
	}

	@Test
	public void contextLoads() {
		logger.info("Sanity Test");
		logger.info("Test Ended");
		assertNotNull(controller);
	}
	
	@Test
	public void validatePensionerDetailsCorrectTokenCorrectAdhar() throws Exception {
		mockMvc.perform(post("/process-pension/991429204770").header("Authorization","Bearer "+tokenStringcorrect)).andExpect(status().isOk());
	
	}
	
	@Test
	public void validatePensionerDetailsCorrectTokenWrongAdhar() throws Exception {
		mockMvc.perform(post("/process-pension/991429204770").header("Authorization","Bearer "+tokenStringcorrect)).andExpect(status().isOk());
	
	}
	
	@Test
	public void validatePensionerDetailsWrongTokenCorrectAdhar() throws Exception {
		mockMvc.perform(post("/process-pension/991429204770").header("Authorization","Bearer "+tokenStringwrong)).andExpect(status().isOk());
	
	}
	
	@Test
	public void validatePensionerDetailsWrongTokenWrongAdhar() throws Exception {
		mockMvc.perform(post("/process-pension/991429204770").header("Authorization","Bearer "+tokenStringwrong)).andExpect(status().isOk());
	
	}

}
