package com.cts.code.service;

import org.springframework.stereotype.Service;

import com.cts.code.entity.PensionDetail;
import com.cts.code.entity.PensionerDeatil;

@Service
public class ProcessPensionService {
	
	public PensionDetail calculatePension(PensionerDeatil pd)
	{
		PensionDetail pDetail = new PensionDetail();
		if(pd.getPensionIndicator().equals("self")) {
			long cal = (long)(0.80*pd.getSalaryEarned()+pd.getAllowances());
			pDetail.setPensionAmount(cal);
			
		}
		if(pd.getPensionIndicator().equals("family")) {
			long cal = (long)(0.50*pd.getSalaryEarned()+pd.getAllowances());
			pDetail.setPensionAmount(cal);
			
		}
		if(pd.getBankIndicator().equals("public")) {
			pDetail.setBankServiceCharge(500);
			
		}
		if(pd.getBankIndicator().equals("private")) {
			pDetail.setBankServiceCharge(550);
			
		}
		pDetail.setName(pd.getName());
		pDetail.setPensionIndicator(pd.getPensionIndicator());
		pDetail.setBankIndicator(pd.getBankIndicator());
		
		return pDetail;
		
	}

}
