package com.sist.web.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/*
 *  cno int
 *  image varchar(4000)
 *  name varchar(34)
 *  tel varchar(100)
 *  address varchar(500)
 *  camp_env varchar(300)
 *  camp_type varchar(300)
 *  homepage varchar(300)
 *  period varchar(300)
 *  day varchar(100)
 *  hit int
 */
@Entity
@Table(name="camp")
@Getter
@Setter
public class CampEntity {
   @Id
   private int cno;
   private int hit;
   private String image,name,tel,address,camp_env,camp_type,homepage,period,day;
}