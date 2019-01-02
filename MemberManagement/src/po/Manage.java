package po;

import java.util.Scanner;

public class Manage {

	Employee[] emps = new Employee[3];
	Scanner sc = new Scanner(System.in);
	int num = 0;// 记录学生数

	public void a() {
		while (true) {
			Employee emp = new Employee();
			System.out.println("请输入第" + (num + 1) + "个小会员的姓名");
			emp.setName(sc.next());
			System.out.println("请输入第" + (num + 1) + "个小会员的性别");
			while (true) {
				String s = sc.next();
				if (s.equals("男")) {
					emp.setSex(s);
					break;
				} else if (s.equals("女")) {
					emp.setSex(s);
					break;
				} else {
					System.out.println("输入错误，请重新输入");
				}
			}
			System.out.println("请输入第" + (num + 1) + "个小会员的年龄");
			while (true) {
				int ag = sc.nextInt();
				if (ag > 0 && ag < 20) {
					emp.setAge(ag);
					break;
				} else {
					System.out.println("输入不符合常理，请重新输入");
				}
			}
			// Employee emp = new Employee(name,sex,age);
			if (num == emps.length) {
				int newLength = (int) (emps.length * 1.5);
				Employee[] temps = new Employee[newLength];
				for (int i = 0; i < emps.length; i++) {
					temps[i] = emps[i];
				}
				emps = temps;
			}
			emps[num] = emp;
			num++;
			System.out.println("是否继续录入 y/n?");
			String type = sc.next();
			if (!type.equals("y")) {
				break;
			}
		}
	}

	public void b() {
		for (int j = 0; j < num; j++) {
			if (emps[j] != null) {
				System.out.println(emps[j].getName() + "\t" + emps[j].getSex() + "\t" + emps[j].getAge());
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Manage ma = new Manage();
		System.out.println("欢迎进入会员管理系统");
		while (true) {
			System.out.println("1 录入 2展示 3退出");
			int type = sc.nextInt();
			if (type == 1) {
				ma.a();
			} else if (type == 2) {
				ma.b();
			} else if (type == 3) {
				break;
			}
		}
	}
}
