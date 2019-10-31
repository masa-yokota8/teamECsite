package com.internousdev.georgia.action;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.georgia.dao.UserInfoDAO;
import com.internousdev.georgia.util.CommonUtility;
import com.internousdev.georgia.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;
public class CreateUserConfirmAction extends ActionSupport implements SessionAware{
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String mail;
	private String userId;
	private String password;
	private String errorMessage;
	private List<String> familyNameEList;
	private List<String> firstNameEList;
	private List<String> familyNameKanaEList;
	private List<String> firstNameKanaEList;
	private List<String> mailEList;
	private List<String> userIdEList;
	private List<String> passwordEList;
	private Map<String, Object> session;

	public String execute() {
		InputChecker inputChecker = new InputChecker();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		CommonUtility commonUtility = new CommonUtility();
		String result = ERROR;

		//仮ユーザーIDのセッションタイムアウト
		if(!session.containsKey("tempUserId")){
			return "sessionTimeout";
		}

		//入力された値をsessionに入れる
		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("sex", sex);
		session.put("mail", mail);
		session.put("userIdForCreateUser", userId);
		session.put("password", password);

		//各入力項目の入力チェック
		familyNameEList=inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false);
		firstNameEList=inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false);
		familyNameKanaEList=inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false);
		firstNameKanaEList =inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false);
		userIdEList=inputChecker.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false);
		passwordEList=inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false);
		mailEList=inputChecker.doCheckForEmail("メールアドレス", mail, 10, 32);

		//各入力チェックのエラー有無を確認
		if(familyNameEList.isEmpty() && firstNameEList.isEmpty() && familyNameKanaEList.isEmpty() && firstNameKanaEList.isEmpty()
				&& userIdEList.isEmpty() && passwordEList.isEmpty() && mailEList.isEmpty()){

			//ユーザーの存在チェック
			if(userInfoDAO.isExistsUserInfo(userId)) {
				errorMessage = "使用できないユーザーIDです。";
			} else {
				result = SUCCESS;
				password = commonUtility.concealPassword(password);
			}
		}
		return result;
	}
	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public List<String> getFamilyNameEList(){
		return familyNameEList;
	}

	public List<String> getFirstNameEList(){
		return firstNameEList;
	}

	public List<String> getFamilyNameKanaEList(){
		return familyNameKanaEList;
	}

	public List<String> getFirstNameKanaEList(){
		return firstNameKanaEList;
	}

	public List<String> getUserIdEList(){
		return userIdEList;
	}

	public List<String> getPasswordEList(){
		return passwordEList;
	}

	public List<String> getMailEList() {
		return mailEList;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}

