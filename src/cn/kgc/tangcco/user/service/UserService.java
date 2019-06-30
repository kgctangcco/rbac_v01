package cn.kgc.tangcco.user.service;

import cn.kgc.tangcco.user.entity.User;

public interface UserService {
	/**
	 * 登录
	 * @param user	用户对象
	 * @return		用户对象
	 */
	User login(User user);
}
