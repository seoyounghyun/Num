package controller.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//[현재 클래스는 어노테이션으로 AOP구현시, 사용할 Advice다]
/*
* @Aspect어노테이션]
* 1]이 클래스는 Advice역할을 하는 클래스라는 것을
* 컴파일러에게 알려주는 어노테이션
*/
@Aspect
public class AdviceUsingAnnotation {
	/*
	  * 공통 관심 사항을 위빙할 타겟클래스의
	  * 어느 지점에 주입할것인지 정의
	  * 
	  * Pointcut설정시 execution명시자 형식의 문자열 지정
	  * 
	  *  execution명시자:
	  *  Advice를 적용할 패키지,클래스 그리고 
	  *  메서드를 표현할때 사용
	  형식:execution(접근지정자패턴 리턴타입패턴 패키지이름패턴/메서드이름패턴/(파라미터 패턴)) 
	  =>AspectJ표현식이라고 함
	  
	  접근지정자패턴:생략가능(public ,protected등)
	  *:모든 값
	  ..:0개 이상이라는 의미
	  public * spring.aop..*(..)=>
	  접근지정자가 public이고 모든 리턴타입에 대해 spring.aop패키지 
	  및 그 이하에 있는 모든 패키지의
	  모든 메서드에 대해 그리고 인자가 0개이상인 모든 메서드를 의미함.
	  */ 
	 //2]타겟 클래스의 어느 지점에 현 Advice를 삽입(위빙)
	 //  할지 포인트 컷 설정	
	@Pointcut("execution(public * controller.ajax..*(..))")
	//Pointcut를 지정할 메소드 원형 정의
	//(단, 반환타입은 무조건 void,메소드명 임의)
	public void advice(){}
	//3]공통로직을 Around Advice로 설정
	//  이 Advice를 Around Advice로 설정하겠다라는 의미
	@Around("advice()")
	public Object cross_cutting_concern(
			ProceedingJoinPoint point)
	throws Throwable{
		//[대상 클래스의 핵심 메소드(getTotal()) 호출전 수행할 공통로직]
		//삽입할 대상클래스의 메소드명 얻기(확인용)
		String coreLogic=point.getSignature().toShortString();
		System.out.println("대상 클래스의 핵심 로직 메소드명:"+coreLogic);
		long startTime=System.currentTimeMillis();
		//[대상 클래스의 핵심 메소드(getTotal()) 호출]
		Object object=point.proceed();
		//[대상 클래스의 핵심 메소드(getTotal()) 호출후 수행할 공통로직]
		long endTime=System.currentTimeMillis();
		System.out.println(coreLogic+"의 실행시간:"+(endTime-startTime)/1000.0+"초");
		return object;
	}/////////////////////////////////////
}
