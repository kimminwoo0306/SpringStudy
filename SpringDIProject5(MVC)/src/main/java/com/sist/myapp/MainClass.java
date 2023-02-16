package com.sist.myapp;

import org.springframework.stereotype.Component;

/*
 *    어노테이션
 *    ------
 *    = 메모리 할당 (객체생성)
 *             @Component
 *                  |
 *     --------------------------------------------------------------
 *     |            |           |              |                    |
 *  @Repository    @Service   @Controller    @RestController      @ControllerAdvice
 *  =============================> 기능별로 구분
 *  @Repository : DAO 클래스를 알려준다
 *  @Service    : BI (DAO여러개를 묶어서 사용)
 *  ----------------------------------------------------------------
 *  @Controller : Model (화면 전환)
 *  @RestController   : Model (데이터 전송)
 *  ------ 다른 프로그램과 연동 (Front : Ajax, Vue, React) => Json
 *  @ControllerAdvice :
 *  ---------------------------------------------------------------- 웹
 *    = 주입
 *    @Qualifier : 특정 객체를 지정 
 *    @Inject : 주입
 *    @Autowired : 자동 주입 => Spring에 의해서 객체를 찾아서 자동으로 메모리 주소를 넘겨준다
 *      private A a;
 *      public void setA(A a)
 *      {
 *      }
 *      ======================== p:a-ref(수동)
 *      @Autowired
 *      private A a;
 *      ----------------------------------- 메모리 할당이 아니라 주입(DI)
 *      @PostConstructor : init-method
 *      @PreDestroy : destroy-method
 *    = 공통모듈 : AOP
 *      @Aspect
 *        @Before
 *        @After
 *        @Around
 *        @After-Reterning
 *        @After-Throwing
 */
@Component // 스프링에서 관리 요청 (객체생성 -> DI -> 객체 소멸) => 메모리 할당 (DL => 자동으로 id가 생성 => mainClass)
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}





