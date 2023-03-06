package com.sist.common;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.web.bind.annotation.ControllerAdvice;
/*
 * 	  스프링 : 객체 생성 ~ 소멸 (필요시마다 호출이 가능 => 기본 싱글턴) => 핵심만 코딩
 * 	1. 메모리 할당 (제외 : VO (사용자 정의 데이터형), Mapper(인터페이스)) ==> 기능별분리해서 저장
 *     @Component => OpenAPI (일반클래스)
 *     @Repository => DAO (저장소 : 데이터베이스 관련) => 테이블 1개 연결
 *     @Service => DAO가 여러개인 경우 (Join, SubQuery...)
 *     ----------------------------------------------- 1) Service VS DAO
 *     @Controller : 브라우저와 연결 (DispatcherServlet이 위임) : 파일명 (화면 이동)
 *     @RestController : 다른 프로그램과 연결 (자바스크립트와 연결, Kotlin연결)
 *     @ControllerAdvice : Controller에서 공통 예외처리
 *     @RestControllerAdvice : RestController에서 공통 예외처리
 *     @Configuration : 자바로 환경설정 (스프링 셋팅)
 *  2. 주입
 *     일반 문자열 주입 => @Value
 *     클래스 객체 주소 주입 => @Autowired, @Resource(가장 많이 사용), @Qualifier
 *                                     ---------------------- 특정 객체 지정
 *                      => @Autowired + @Qualifier = @Resource
 *                      => @Qualifier("id명"), @Resource(name="id명") => JDK1.8
 *   => DI / AOP / Transaction
 *   => 자바
 *      => 캡슐화 VS 은닉화
 *      => 상속 VS 포함
 *      => 오버로딩 VS 오버라이딩
 *      => 추상 클래스 VS 인터페이스
 *      => 객체란?
 *      => 예외처리의 종류 (예외복구, 예외회피)
 *      => 컬렉션의 종류 (List,Map,Set)
 *                              ----이중 for
 *      => 쓰레드 부분
 *   => 오라클
 *      => JOIN / SubQuery / View (Sql문장이 길거나 반복적인 문장 사용시 사용)
 *      => Index (***************)
 *      => Procedure VS Function VS Trigger
 *      => 데이터형 (BLOB, BFILE)
 *   => HTML / CSS
 *      => 시멘텍 / GET / POST
 *   => JSP
 *      GET / POST
 *      Cookie / Session
 *      MVC
 *   => Front-End : VueJS / ReactJS 차이점 => 장,단점
 *      자바스크립트 : var/let/const, Arrow 함수, 클로저 => ajax/axios
 *   => 면접관 : 5명 => 3문제 (15문제)
 */
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
/*
 *   1. RunTimeException : NumberFormatException / NullPointerException / ClassCastException
 *   2. SQLException
 *   3. IOException
 *   4. Exception
 */
public class CommonException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex)
	{
		System.out.println("========== RuntimeException ==========");
		System.out.println(ex.getMessage());
		System.out.println("======================================");
	}
	@ExceptionHandler(SQLException.class)
	public void sqlException(SQLException ex)
	{
		System.out.println("========== SQLException ==========");
		System.out.println(ex.getMessage());
		System.out.println("======================================");
	}
	@ExceptionHandler(IOException.class)
	public void ioException(IOException ex)
	{
		System.out.println("========== IOException ==========");
		System.out.println(ex.getMessage());
		System.out.println("======================================");
	}
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex)
	{
		System.out.println("========== Exception ==========");
		System.out.println(ex.getMessage());
		System.out.println("======================================");
	}
}
