package com.sist.manager;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.net.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.sist.vo.MovieVO;
// https://www.kobis.or.kr/kobis/business/main/main.do
/*
 *   일일 박스오피스
 *   실시간 예매율
 *     좌석점유율순위
 *   온라인상영관 일일
 */
@Component("mm")
public class MovieManager {
   public static void main(String[] args) {
      MovieManager m = new MovieManager();
      m.movieListData(1);
   }
   
   private String[] strUrl = {"","searchMainDailyBoxOffice.do","searchMainRealTicket.do",
         "searchMainDailySeatTicket.do","searchMainOnlineDailyBoxOffice.do"};
   public List<MovieVO> movieListData(int no) {
      List<MovieVO> list = new ArrayList<MovieVO>();
      /*
      try {
         URL url = new URL("https://www.kobis.or.kr/kobis/business/main/" + strUrl[no]);
         HttpURLConnection conn = (HttpURLConnection)url.openConnection();
         if(conn != null) { // 연결이 되었다면
            BufferedReader br =
                  new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while(true) {
               String data = br.readLine();
               if(data == null) break;
               System.out.println(data);
            }
         }
      } catch (Exception e) {}*/
      try {
         Document doc = Jsoup.connect("https://www.kobis.or.kr/kobis/business/main/" + strUrl[no]).get();
         System.out.println(doc.toString());
      } catch (Exception e) {
         // TODO: handle exception
      }
      return list;
   }
}