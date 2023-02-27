package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO      NOT NULL NUMBER         
	TITLE   NOT NULL VARCHAR2(1000) 
	POSTER  NOT NULL VARCHAR2(1000) 
	MSG              CLOB           
	ADDRESS NOT NULL VARCHAR2(500)  
	HIT              NUMBER 
 */
@Getter
@Setter
public class SeoulShopVO {
	private int no,hit;
	private String title,poster,msg,address;
}
