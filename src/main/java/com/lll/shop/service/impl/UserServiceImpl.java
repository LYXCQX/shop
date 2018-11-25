package com.lll.shop.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.lll.shop.dao.UserDao;
import com.lll.shop.pojo.BaseRes;
import com.lll.shop.pojo.ResCode;
import com.lll.shop.pojo.UserPojo;
import com.lll.shop.pojo.res.UserRes;
import com.lll.shop.service.UserService;
import com.lll.shop.util.DateUtil;
import com.lll.shop.util.MD5Util;

@Service
public class UserServiceImpl implements UserService{

	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	/**
	 * 用户注册
	 */
	@Override
	public BaseRes<UserRes> register(UserPojo userPojo) {
		BaseRes<UserRes> res =new BaseRes<UserRes>();
		UserPojo user = userDao.selectUser(userPojo);
		if(user != null) {
			res.setRes(ResCode.USER_HASUSER);
		}else {
			String salt = UUID.randomUUID().toString();
			userPojo.setSalt(salt);
			userPojo.setLoginId(UUID.randomUUID().toString());
			//用户密码加密
			userPojo.setPassWord(MD5Util.Md5(userPojo.getPassWord()+salt));
			userPojo.setLastLogInTime(new Date());
			userDao.saveUser(userPojo);
			res.setData(toJava(userPojo));
		}
		return res;
	}

	/**
	 * 用户登录
	 */
	@Override
	public BaseRes<UserRes> login(UserPojo userReq) {
		BaseRes<UserRes> res =new BaseRes<UserRes>();
		UserPojo user = userDao.selectUser(userReq);
		if(user != null) {
			//用户密码加密，校验
			String upassword = MD5Util.Md5(userReq.getPassWord()+user.getSalt());
			if(!upassword.equals(user.getPassWord())) {
				res.setRes(ResCode.USER_PASSWORDERROR);
			}else {
				UserPojo UserPojo=new UserPojo();
				//随便设置，数据库+1
				UserPojo.setLoginCount(1);
				UserPojo.setLastLogInTime(new Date());
				UserPojo.setCellPhone(userReq.getCellPhone());
				userDao.updateUser(UserPojo);
				res.setData(toJava(user));
			}
		}else {
			res.setRes(ResCode.USER_NOREGISTER);
		}
		return res;
	}

	/**
	 * 重置，修改密码
	 */
	@Override
	public BaseRes<UserPojo> changePwd(UserPojo userReq) {
		BaseRes<UserPojo> res = new BaseRes<UserPojo>();
		String salt = UUID.randomUUID().toString();
		userReq.setSalt(salt);
		// 用户密码加密
		userReq.setPassWord(MD5Util.Md5(userReq.getPassWord() + salt));
		userDao.updateUser(userReq);
		return res;
	}

	/**
	 * 上传头像
	 */
	@Override
	public BaseRes<UserPojo> uploadHead(UserPojo userReq,MultipartFile file) {
		BaseRes<UserPojo> res = new BaseRes<UserPojo>();
		File dest = new File(userReq.getHeadFile());
		// 判断文件父目录是否存在
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		try {
			file.transferTo(dest); // 保存文件
		} catch (IOException e) {
			log.error("用户上传头像失败", e);
			res.setRes(ResCode.USER_UPLOADHEAD);
		}
		userDao.updateUser(userReq); 
		return res;
	}

	/**
	 * 检查用户是否登录
	 */
	@Override
	public BaseRes<UserRes> checkLogn(UserPojo userReq) {
		BaseRes<UserRes> res = new BaseRes<UserRes>();
		UserPojo user = userDao.selectUserByLoginId(userReq);
		if (user != null && DateUtil.compare_date(DateUtil.getAfterTme(user.getLastLogInTime(), 30) , new Date())) {
			// 随便设置，数据库+1
//			userReq.setLoginCount(1);
			res.setData(toJava(user));
		} else {
			res.setRes(ResCode.USER_NOTLOGIN);
		}
		return res;
	}
	public UserRes toJava(UserPojo userPojo) {
		return JSON.toJavaObject(JSON.parseObject(JSON.toJSONString(userPojo)), UserRes.class) ;
	}
}
