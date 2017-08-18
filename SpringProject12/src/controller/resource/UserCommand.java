package controller.resource;

public class UserCommand {
	
	private String user;
	private String pass;
	private String name;
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {		
		return String.format(
				"[아뒤:%s,비번:%s,이름:%s]",
				user,pass,name);
	}
}
