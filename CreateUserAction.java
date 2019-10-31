package com.internousdev.georgia.action;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private String backFlag;

	public String execute() {
		if(!session.containsKey("tempUserId")){
			return "sessionTimeout";
		}

		//createUserConfirm.jspで"戻る"を押した場合はsessionを保持
		if(backFlag == null) {
			session.remove("familyName");
			session.remove("firstName");
			session.remove("familyNameKana");
			session.remove("firstNameKana");
			session.remove("sex");
			session.remove("sexList");
			session.remove("mail");
			session.remove("password");
			session.remove("userIdForCreateUser");
		}

		//sessionにsexがあればその値を表示
		if(!session.containsKey("sex")){
			session.put("sex", "男性");
		}else {
			session.put("sex", session.get("sex").toString());
		}

		//性別のリストを生成
		if(!session.containsKey("sexList")){
			List<String> sexList=new ArrayList<String>();
			sexList.add("男性");
			sexList.add("女性");
			session.put("sexList", sexList);
		}

		return SUCCESS;
	}

	public String getBackFlag(){
		return backFlag;
	}
	public void setBackFlag(String backFlag) {
		this.backFlag = backFlag;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
