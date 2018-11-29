package com.lll.shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lll.shop.dao.GlobalconfigDao;
import com.lll.shop.pojo.BaseRes;
import com.lll.shop.pojo.GlobalconfigPojo;
import com.lll.shop.pojo.ResCode;
import com.lll.shop.pojo.UserPojo;
import com.lll.shop.pojo.VerifyCode;
import com.lll.shop.pojo.res.UserRes;
import com.lll.shop.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private GlobalconfigDao globalconfigDao;
	
	@RequestMapping("register")
	private BaseRes<UserRes> register(UserPojo userReq){
		log.info("用户注册请求：" + userReq.toString());
		BaseRes<UserRes> baseRes = new BaseRes<UserRes>();
		try {
			baseRes = userService.register(userReq);
			log.info("用户注册响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("用户注册抛出异常", e);
			baseRes.setRes(ResCode.SYSTEMERROR);
		}
		return baseRes;
	}
	
	/**
	 * 登录
	 * @param userReq
	 * @return
	 */
	@RequestMapping("login")
	private BaseRes<UserRes> login(UserPojo userReq){
		log.info("用户登录请求：" + userReq.toString());
		BaseRes<UserRes> baseRes = new BaseRes<UserRes>();
		try {
			baseRes = userService.login(userReq);
			log.info("用户登录响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("用户登录抛出异常", e);
			baseRes.setRes(ResCode.SYSTEMERROR);
		}
		return baseRes;
	}
	
	/**
	 * 检查登录
	 * @param userReq
	 * @return
	 */
	@RequestMapping("checkLogn")
	private BaseRes<UserRes> checkLogn(UserPojo userReq){
		log.info("用户检查登录请求：" + userReq.toString());
		BaseRes<UserRes> baseRes = new BaseRes<UserRes>();
		try {
			baseRes = userService.checkLogn(userReq);
			log.info("用户检查登录响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("用户检查登录抛出异常", e);
			baseRes.setRes(ResCode.SYSTEMERROR);
		}
		return baseRes;
	}
	/**
	 * 修改密码
	 * @param userReq
	 * @return
	 */
	@RequestMapping("changePwd")
	private BaseRes<UserRes> changePwd(UserPojo userReq){
		log.info("修改密码请求：" + userReq.toString());
		BaseRes<UserRes> baseRes = new BaseRes<UserRes>();
		try {
			baseRes = userService.changePwd(userReq);
			log.info("修改密码响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("修改密码抛出异常", e);
			baseRes.setRes(ResCode.SYSTEMERROR);
		}
		return baseRes;
	}
	
	/**
	 * 重置密码
	 * @param userReq
	 * @return
	 */
	@RequestMapping("resetPwd")
	private BaseRes<UserRes> resetPwd(UserPojo userReq){
		log.info("重置密码请求：" + userReq.toString());
		BaseRes<UserRes> baseRes = new BaseRes<UserRes>();
		try {
			GlobalconfigPojo globalconfigPojo =  globalconfigDao.getGlobalByKey("defaultPwd");
			userReq.setPassWord(globalconfigPojo.getValue());
			baseRes = userService.changePwd(userReq);
			log.info("重置密码响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("重置密码抛出异常", e);
			baseRes.setRes(ResCode.SYSTEMERROR);
		}
		return baseRes;
	}
	
	/**
	 * 发送验证码
	 * @param verifyCode
	 * @return
	 */
	@RequestMapping("sendCode")
	private BaseRes<VerifyCode> sendCode(VerifyCode verifyCode){
		log.info("发送验证码请求：" + verifyCode.toString());
		BaseRes<VerifyCode> baseRes = new BaseRes<VerifyCode>();
		try {
			baseRes = userService.sendCode(verifyCode);
			log.info("发送验证码响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("发送验证码抛出异常", e);
			baseRes.setRes(ResCode.SYSTEMERROR);
		}
		return baseRes;
	}
	
	/**
	 * 校验验证码
	 * @param verifyCode
	 * @return
	 */
	@RequestMapping("checkCode")
	private BaseRes<VerifyCode> checkCode(VerifyCode verifyCode){
		log.info("校验验证码是否正确请求：" + verifyCode.toString());
		BaseRes<VerifyCode> baseRes = new BaseRes<VerifyCode>();
		try {
			baseRes = userService.checkCode(verifyCode);
			log.info("校验验证码是否正确响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("校验验证码是否正确抛出异常", e);
			baseRes.setRes(ResCode.SYSTEMERROR);
		}
		return baseRes;
	}
	/**
	 * 上传头像
	 * @param userReq
	 * @return
	 */
	@RequestMapping("uploadHead")
	private BaseRes<UserPojo> uploadHead(UserPojo userReq,MultipartFile file){
		log.info("上传头像请求：" + userReq.toString());
		BaseRes<UserPojo> baseRes = new BaseRes<UserPojo>();
		try {
			baseRes = userService.uploadHead(userReq,file);
			log.info("上传头像响应:" + baseRes.toString());
		} catch (Exception e) {
			log.error("上传头像抛出异常", e);
			baseRes.setRes(ResCode.SYSTEMERROR);
		}
		return baseRes;
	}
}
