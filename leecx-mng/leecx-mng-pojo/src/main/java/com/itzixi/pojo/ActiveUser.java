package com.itzixi.pojo;

import java.util.Date;
import java.util.List;

/**
 * @Title: ActiveUser.java
 * @Package com.itzixi.pojo
 * @Description: 用户信息
 * Copyright: Copyright (c) 2016
 * Company:Nathan.Lee.Salvatore
 * 
 * @author leechenxiang
 * @date 2017年2月17日 下午7:49:15
 * @version V1.0 
 */
public class ActiveUser implements java.io.Serializable {	// 必须实现序列化
	
	private static final long serialVersionUID = 7224034033637128982L;
	
	private String userId;			// 用户id（主键）
	private String username;		// 用户登录账号
	private String nickname;		// 用户昵称
	private String realname;		// 用户真实姓名
	private String mobile;			// 用户手机
	private String email;			// 用户email
	
	private String adminUserType;		// 权限类型
	
	private String faceImage;		// 用户头像
    private String faceImageSmall;	// 用户头像（小兔）
	
    private String idcardNum;		// 身份证
    private Integer balance;		// 余额
    private Integer age;			// 年龄
    private Integer sex;			// 性别
    private String signature;		// 签名
    private Integer job;			// 职位
    private Integer workYears;		// 工作年限
    private String province;		// 省
    private String city;			// 市
    private String district;		// 区
    private String address;			// 地址
    private Integer status;			// 状态
    private String lastLoginIp;		// 最后登陆IP
	private Date lastLoginTime;		// 最后登录时间

	private String userToken;	// 用户登录的时候分配的token
	
//	private List<SysPermission> menus;// 菜单
//	private List<SysPermission> permissions;// 权限
	
	public ActiveUser() {
		super();
	}
	
	public ActiveUser(String userId) {
		super();
		this.userId = userId;
	}
	
	public ActiveUser(ActiveUser user) {
		super();
		this.userId = user.getUserId();
		this.username = user.getUsername();
		this.nickname = user.getNickname();
	}

	public ActiveUser(String userId, String username, String nickname) {
		super();
		this.userId = userId;
		this.username = username;
		this.nickname = nickname;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcardNum() {
		return idcardNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getJob() {
		return job;
	}

	public void setJob(Integer job) {
		this.job = job;
	}

	public Integer getWorkYears() {
		return workYears;
	}

	public void setWorkYears(Integer workYears) {
		this.workYears = workYears;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getFaceImage() {
		return faceImage;
	}

	public void setFaceImage(String faceImage) {
		this.faceImage = faceImage;
	}

	public String getFaceImageSmall() {
		return faceImageSmall;
	}

	public void setFaceImageSmall(String faceImageSmall) {
		this.faceImageSmall = faceImageSmall;
	}

	public String getAdminUserType() {
		return adminUserType;
	}

	public void setAdminUserType(String adminUserType) {
		this.adminUserType = adminUserType;
	}


}
