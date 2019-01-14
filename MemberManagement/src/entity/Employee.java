package entity;

import java.io.Serializable;

public class Employee implements Serializable{
	private int id;//会员id
	private String name;//会员的名字
	private String sex;//会员的性别
	private int age;//会员的年龄
	private String telephone;//会员的联系方式
	private Group gp;//会员所在的组别

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Group getGp() {
		return gp;
	}

	public void setGp(Group gp) {
		this.gp = gp;
	}
}
