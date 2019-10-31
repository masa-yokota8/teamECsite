package com.internousdev.georgia.dto;

public class UserInfoDTO {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String userId;
	private String userPassword;
	private String userSex;
	private String userEmail;

	//姓
	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	//名
	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//姓ふりがな
	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	//名ふりがな
	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	//ユーザーID
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	//パスワード
	public String getUserPassword(){
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	//性別
	public String getUserSex(){
		return userSex;
	}
	public void setUserSex(String userSex){
		this.userSex = userSex;
	}

	//メール
	public String getUserEmail(){
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}