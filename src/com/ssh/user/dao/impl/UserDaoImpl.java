package com.ssh.user.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.ssh.user.dao.UserDao;
import com.ssh.user.model.User;
import com.ssh.util.MyHibernateDaoSupport;
/**     
 * 类名称：UserDaoImpl   
 * 类描述：用户控制dao实现数据库操作接口实现
 * 创建人：anan   
 * 创建时间：2012-12-21 下午11:07:43   
 * 修改人：anan  
 * 修改时间：2012-12-21 下午11:07:43   
 * 修改备注：   
 * @version        
 * */
@Repository("userDao")
public class UserDaoImpl extends MyHibernateDaoSupport implements UserDao{

	public boolean addUser(User user)  {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.save(user);
//		session.saveOrUpdate(arg0);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} 
		session.close();
		return true;
	}

	public void delUser(int userId) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		User u = new User(userId);
		session.delete(u);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		session.close();
	}

	public void updateUser(User user) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.update(user);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
	}

	public List<User> selectUser()  {
		List<User> users = new ArrayList<User>();
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		List list = session.createQuery("From User").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			User u = (User) iterator.next();
			users.add(u);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return users;
	}

	public User getUserByUserId(int userId)  {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		//load 是说明数据库中一定存在这条记录，没有则报出：ObjectNotFoundException
		//get 如果查不到记录，返回的是一个null
		User user = (User)session.load(User.class, userId);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return user;
	}

	public boolean isExitByName(String userName)  {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		List user = (List)session.createQuery("From User u where u.userName=:userName").setString("userName", userName).list();
		if(user.size()>0){
			try {
				tc.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return true;
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return false;
	}

	/**
	 * 登录查询...通过user
	 */
	public boolean isExitByNameAndPass(User user)  {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		List users = (List)session.createQuery("From User u where u.userName=:userName and u.passWord=:passWord").setString("userName", user.getUserName()).setString("passWord", user.getPassWord()).list();
//		session.saveOrUpdate(arg0, arg1);
		if(users.size()>0){
			try {
				tc.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session.close();
			return true;
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return false;
	}

}
