package controller.aop;

/*
 * 공통관점(공통로직)을 주입받는 대상 클래스
 */
public class TargetObject {
	//속성(멤버변수)]
	private int start;
	private int end;
	//SETTER인젝션 주입-와이어링한다.
	public void setStart(int start) {
		this.start = start;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	//핵심 로직]-핵심로직 전후에 
	//공통관점(Around Advice) 주입-위빙한다.
	public int getTotal(){
		int total=0;
		for(int i=start;i<=end ;i++) total+=i;
		return total;
	}
	
}
