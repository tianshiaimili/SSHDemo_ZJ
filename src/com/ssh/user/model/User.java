package com.ssh.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**     
 * 类名称：User   
 * 类描述：用户信息实体
 * 创建人：anan   
 * 创建时间：2012-12-21 下午10:55:19   
 * 修改人：anan  
 * 修改时间：2012-12-21 下午10:55:19   
 * 修改备注：   
 * @version        
 * */
@Entity
@Table(name = "user")
public class User {
	/**
	 * 用户id
	 */
	private int userId;
	
	/**
	 * 用户名
	 */
	@Column(name = "userName", length = 50)
	private String userName;
	
	/**
	 * 用户登录密码
	 */
	@Column(name = "passWord", length = 50)
	private String passWord;

	@Id
	@Column(name = "userId")
//	@GenericGenerator(name ="generator", strategy = "identity") 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(generator = "generator") 
//	@GenericGenerator(strategy = GenerationType.IDENTITY) 
//	@GenericGenerator(name ="generator", strategy = "increment")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public User(int userId, String userName, String passWord) {
		this.userId = userId;
		this.userName = userName;
		this.passWord = passWord;
	}

	public User(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public User(int userId) {
		this.userId = userId;
	}

	public User() {
		
	}

}
