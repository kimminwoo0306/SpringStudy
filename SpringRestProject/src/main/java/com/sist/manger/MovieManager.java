package com.sist.manger;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.util.*;
import java.io.*;
import java.net.*;
/*
 * 	searchMainDailyBoxOffice.do 일일 박스오피스
 * 	searchMainRealTicket.do 실시간 예매율
 * 	searchMainOnlineDailyBoxOffice.do 온라인상영관 일일
 * https://www.kobis.or.kr/kobis/business/main/
 */
@Component
public class MovieManager {
	public static void main(String[] args) {
		MovieManager mm=new MovieManager();
		mm.movieSite(1);
	}
	public String movieSite(int no)
	{
		String url="";
		switch(no)
		{
		case 1:
			url="https://www.kobis.or.kr/kobis/business/main/searchMainDailyBoxOffice.do";
			break;
		case 2:
			url="https://www.kobis.or.kr/kobis/business/main/searchMainRealTicket.do";
			break;
		case 3:
			url="https://www.kobis.or.kr/kobis/business/main/searchMainOnlineDailyBoxOffice.do";
			break;
		}
		String json="";
		try
		{
			Document doc=Jsoup.connect(url).get();
			System.out.println(doc.toString());
			json=doc.toString();
		}catch(Exception ex) {}
		return json;
	}
}
