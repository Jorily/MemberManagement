package biz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Employee;

public class Manage{
	ArrayList<Employee> emps=new ArrayList<Employee>();
	private static final String fileName="c:/test/stus.txt";
//	Employee[] emps = new Employee[3];
	Scanner sc = new Scanner(System.in);
//	int num = 0;// 记录学生数

	public void input() {
		while (true) {
			Employee emp = new Employee();
			System.out.println("请输入第" + (emps.size() + 1) + "个小会员的姓名");
			emp.setName(sc.next());
			System.out.println("请输入第" + (emps.size() + 1) + "个小会员的性别");
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
			System.out.println("请输入第" + (emps.size() + 1) + "个小会员的年龄");
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
//			if (num == emps.length) {
//				int newLength = (int) (emps.length * 1.5);
//				Employee[] temps = new Employee[newLength];
//				for (int i = 0; i < emps.length; i++) {
//					temps[i] = emps[i];
//				}
//				emps = temps;
//			}
//			emps[num] = emp;
			emps.add(emp);
//			num++;
			save();
			System.out.println("是否继续录入 y/n?");
			String type = sc.next();
			if (!type.equals("y")) {
				break;
			}
		}
	}

	public void show() {
		for (Employee em:emps) {
				System.out.println(em.getName()+"\t"+em.getSex()+"\t"+em.getAge());
		}
	}
	public void save(){
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(emps);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void load(){
		try {
			File file=new File(fileName);
			if(file.exists()){
			FileInputStream	fis = new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			emps=(ArrayList<Employee>) ois.readObject();
			ois.close();
			fis.close();
			}
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Manage ma = new Manage();
		System.out.println("欢迎进入会员管理系统");
		while (true) {
			ma.load();
			System.out.println("1 录入 2展示 3退出");
			int type = sc.nextInt();
			if (type == 1) {
				ma.input();
			} else if (type == 2) {
				ma.show();
			} else if (type == 3) {
				break;
			}
		}
	}
}
