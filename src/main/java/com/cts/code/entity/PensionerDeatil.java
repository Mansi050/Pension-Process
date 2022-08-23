package com.cts.code.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class PensionerDeatil {
	@Id

	private long adhaarNumber;
	private String name;
	private String dob;
	private String panCard;
	private long salaryEarned;
	private long allowances;
	private String pensionIndicator; // (self or family)
	private String bankName;
	private long accountNumber;
	private String bankIndicator; //(private or public)

	public PensionerDeatil() {
		super();
	}
	
	public PensionerDeatil(Long adhar, String name, String dob, String panCard, Long salaryEarned, Long allowances,
			String pensionIndicator, String bankName, Long accountNumber, String bankIndicator) {
		super();
		this.adhaarNumber = adhar;
		this.name = name;
		this.dob = dob;
		this.panCard = panCard;
		this.salaryEarned = salaryEarned;
		this.allowances = allowances;
		this.pensionIndicator = pensionIndicator;
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.bankIndicator = bankIndicator;

	}

}
