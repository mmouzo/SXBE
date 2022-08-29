package model.entity;

public class Student {
	
	public String cie;
	public String name;
	
	public Student(String cie, String name) {
		this.cie = cie;
		this.name = name;
	}

	public String getCie() {
		return cie;
	}

	public void setCie(String cie) {
		this.cie = cie;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [cie=" + cie + ", name=" + name + "]";
	}
	
	
	
	

}
