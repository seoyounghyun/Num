package controller.annotation;

public class LoginCommand {
	//파라미터명과 일치 시키자
	//※속성(멤버변수)는 소문자로 시작해야한다
	
	private String user;
	private String pass;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
