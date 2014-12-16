package com.ssh.user.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.user.dao.UserDao;
import com.ssh.user.model.User;

/**     
 * 类名称：LoginAction   
 * 类描述：用户控制器的实现
 * 创建人：anan   
 * 创建时间：2012-12-21 下午11:17:36   
 * 修改人：anan  
 * 修改时间：2012-12-21 下午11:17:36   
 * 修改备注：   
 * @version        
 * */
@Action(value = "loginAction", results = {
		@Result(name = "loginSuccess", location = "/loginSuss.jsp"),
		@Result(name = "loginFailer", location = "/loginFailer.jsp") })
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = -2266695172069461659L;
	//这里之所以可以通过@Resource 把userdao创建 是因为在UserDaoImpl类中使用@@Repository 把userdao注入到spring容器中了
	@Resource
	private UserDao userDao;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login(){
		boolean flag = userDao.isExitByNameAndPass(user);
		if(flag){
			System.out.println("suss");
			return "loginSuccess";
		}
		System.out.println("fail");
		return "loginFailer";
	}
}
