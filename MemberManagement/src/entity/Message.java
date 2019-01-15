package entity;

public class Message {
	private int id;
	private Member emp;//姓名
	private Car car;//车
	private Integer time;//剩余玩车时间
	private String ymd;//购买年份
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Member getEmp() {
		return emp;
	}
	public void setEmp(Member emp) {
		this.emp = emp;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public String getYmd() {
		return ymd;
	}
	public void setYmd(String ymd) {
		this.ymd = ymd;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}

	
}
