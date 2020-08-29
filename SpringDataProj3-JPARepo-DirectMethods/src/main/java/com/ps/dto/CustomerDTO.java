package com.ps.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements Serializable {

	@NonNull
	private Integer cNo;
	private String cName;
	private String cAddrs;
	private Double billAmt;
}
