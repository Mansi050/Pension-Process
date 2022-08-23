package com.cts.code.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PensionDetail {
	@Id
	private String name;
	private String pensionIndicator;
	private String bankIndicator;
	private long pensionAmount;
	private long bankServiceCharge;
	
}
