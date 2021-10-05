package controller;

import java.util.ArrayList;

import model.User;

public class UserManager {

	ArrayList<User> user = null;

	public UserManager() {
		this.user = new ArrayList<User>();
		// 임시아이디 저장
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		user.add(new User("red"));
	}

	public void join(String id) {
		// TODO Auto-generated method stub
		boolean check = true;
		for (User user : user) {
			if (user.getId().equals(id)) {
				check = false;
			}
		}
		if (check) {

			user.add(new User(id));
			System.out.println("[시스템] 가입완료");
		} else {
			System.out.println("[시스템]아이디중복");
		}
	}

	public void withdraw(String id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).getId().equals(id)) {
				user.remove(i);
				System.out.println("삭제완료");
			}
		}
	}

	public int findLog(String id) {
		// TODO Auto-generated method stub
		int check = 0;
		for (User user : user) {
			if (user.getId().equals(id)) {
				return check;
			} else {
				check++;
			}
		}
		return -1;
	}

	public void deleteitem() {
		// TODO Auto-generated method stub

	}

	public void printUserData() {
		// TODO Auto-generated method stub
		System.out.println("사용자");
		for (int i = 0; i < user.size(); i++) {
			System.out.printf("\"%s\"님 지불금액 : %d원\n", user.get(i).getId(), user.get(i).getmoney());
		}
	}
}
