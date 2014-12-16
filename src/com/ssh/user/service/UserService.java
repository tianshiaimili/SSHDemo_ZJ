package com.ssh.user.service;

import java.util.List;

import com.ssh.user.model.User;


/**     
 * 类名称：UserService   
 * 类描述：用户业务逻辑接口
 * 创建人：anan   
 * 创建时间：2012-12-21 下午10:58:32   
 * 修改人：anan  
 * 修改时间：2012-12-21 下午10:58:32   
 * 修改备注：   
 * @version        
 * */
public interface UserService {
	/**
	 * 判断用户是否存在
	 * @param userName
	 * @return user
	 * @ 
	 * */
	public boolean isExitUser(String userName) ;
	
	/**
	 * 判断用户是否存在
	 * @param userName passWord
	 * @return user
	 * @ 
	 * */
	public boolean isExitByNameAndPass(User user) ;
	
	/**
	 * 保存用户
	 * @param user
	 * @return boolean
	 * @ 
	 * */
	public void save(User user) ;
	
	/**
	 * 查询所有用户
	 * @param 
	 * @return List<User>
	 * @ 
	 * */
	public List<User> getUsers() ;
	/**
	 * 删除用户
	 * @param userId
	 * @return 
	 * @ 
	 * */
	public void del(int userId) ;
	
	/**
	 * 修改用户
	 * @param user
	 * @return 
	 * @ 
	 * */
	public void update(User user) ;
	
	/**
	 * 根据id获得user
	 * @param userId
	 * @return user
	 * @ 
	 * */
	public User getUserById(int userId) ;
	
	
}
