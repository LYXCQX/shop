package com.lll.shop.service;

import org.springframework.web.multipart.MultipartFile;

import com.lll.shop.pojo.BaseRes;
import com.lll.shop.pojo.UserPojo;
import com.lll.shop.pojo.res.UserRes;

public interface UserService {

	/**
	 * 用户注册
	 * @param userPojo
	 * @return
	 */
	public BaseRes<UserRes> register(UserPojo userPojo);

	/**
	 * 用户登录
	 * @param userReq
	 * @return
	 */
	public BaseRes<UserRes> login(UserPojo userReq);

	/**
	 * 修改密码
	 * @param userReq
	 * @return
	 */
	public BaseRes<UserPojo> changePwd(UserPojo userReq);

	/**
	 * 上传头像
	 * @param userReq
	 * @return
	 */
	public BaseRes<UserPojo> uploadHead(UserPojo userReq,MultipartFile file);

	/**
	 * 检查用户是否登录
	 * @param userReq
	 * @return
	 */
	public BaseRes<UserRes> checkLogn(UserPojo userReq);
	
}
