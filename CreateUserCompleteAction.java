package com.internousdev.georgia.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.georgia.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		String sex;

		//仮ユーザーIDのセッションの存在確認
		if(!session.containsKey("tempUserId")){
			return "sessionTimeout";
		}

		//性別をSQLの入力にあわせる
		if(session.get("sex").toString().equals("男性")) {
			sex = "0";
		} else {
			sex = "1";
		}

		//DBにユーザーを登録及びLoginActionで使用するcreateUserFlagの生成
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		if (userInfoDAO.createUser(session.get("userIdForCreateUser").toString(),
				session.get("password").toString(),
				session.get("familyName").toString(),
				session.get("firstName").toString(),
				session.get("familyNameKana").toString(),
				session.get("firstNameKana").toString(),
				sex,
				session.get("mail").toString())){
			result = SUCCESS;
			session.put("createUserFlag", "1");
		}

		//不要なsessionの値を破棄
		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("sex");
		session.remove("mail");
		session.remove("sexList");

		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
