package com.internousdev.georgia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.georgia.dto.UserInfoDTO;
import com.internousdev.georgia.util.DBConnector;
public class UserInfoDAO {

	//ログイン、パスワード再設定　ユーザーが存在するか
	public boolean isExistsUserInfo(String userId, String password) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;
		String sql = "SELECT * FROM user_info WHERE user_id = ? AND password = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//マイページ　ユーザーIDからユーザー情報を取り出す
	public UserInfoDTO getUserInfo(String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO dto= new UserInfoDTO();
		String sql = "SELECT * FROM user_info WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setUserPassword(rs.getString("password"));
				dto.setUserEmail(rs.getString("email"));
				dto.setUserId(rs.getString("user_id"));
				dto.setUserSex(rs.getString("sex"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	//ユーザー作成　ユーザーIDの存在チェック
	public boolean isExistsUserInfo(String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;
		String sql = "SELECT user_id FROM user_info WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//パスワード再設定　
	public boolean resetPassword(String password, String userId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result=false;
		String sql = "UPDATE user_info SET password = ?, update_date = now() WHERE user_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, userId);
			int i= ps.executeUpdate();
			if (i > 0) {
				result = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	//ユーザー登録　
	public boolean createUser(String userId, String password,
			String familyName, String firstName,
			String familyNameKana, String firstNameKana,
			String sex, String mail) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;
		String sql = "INSERT INTO user_info(user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, regist_date, update_date) values(?,?,?,?,?,?,?,?,now(),now())";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, sex);
			ps.setString(8, mail);
			int i = ps.executeUpdate();
			if (i > 0){
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
