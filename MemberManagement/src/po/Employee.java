package po;
public class Employee {
	 String name;
	 String sex;
	 int age;
//	public Employee(String n,String s,int a){
//		name=n;
//		if(s.equals("男")||s.equals("女")){
//			sex=s;
//		}else{
//			sex="男";
//		}
//		if(a>0&&a<18){
//			age=a;
//		}else{
//			age=10;
//		}
//	}
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
}
