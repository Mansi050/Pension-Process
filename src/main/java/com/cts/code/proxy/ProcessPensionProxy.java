package com.cts.code.proxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.code.entity.PensionerDeatil;

@FeignClient(name="pensioner-detail",url="localhost:8089")
public interface ProcessPensionProxy {
	
	@GetMapping("/pensioner-detail/{adharCard}")
	public PensionerDeatil retrieveDetail(@RequestHeader(name="Authorization") String token, @PathVariable("adharCard") Long adharCard);

}
