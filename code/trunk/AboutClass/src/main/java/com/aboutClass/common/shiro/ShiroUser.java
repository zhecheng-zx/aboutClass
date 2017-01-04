package com.aboutClass.common.shiro;

import java.io.Serializable;

import com.aboutClass.model.aboutClass.TUser;
import com.aboutClass.model.aboutClass.TUserPackage;
import com.aboutClass.utils.DateUtils;

public class ShiroUser implements Serializable {
	private static final long serialVersionUID = -1373760761780840081L;
	public Long id;
	public String phone;
	public String name;
	public TUser user;
	public TUserPackage uPackage;
	public int province;
	public int city;
	public int country;
	public int packageId;
	public ShiroUser(TUser user,TUserPackage uPackage) {
		this.id = user.getId();
		this.phone = user.getPhone();
		this.name = user.getName();
		this.user = user;
		this.uPackage = uPackage;
		this.province = user.getProvince();
		this.city = user.getCity();
		this.country = user.getCountry();
		this.packageId = user.getPackageId().intValue();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public TUserPackage getuPackage() {
		return uPackage;
	}
	public void setuPackage(TUserPackage uPackage) {
		this.uPackage = uPackage;
	}
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getCountry() {
		return country;
	}
	public void setCountry(int country) {
		this.country = country;
	}
	public int getPackageId() {
		return packageId;
	}
	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}
	public String getPackageIdString(){
		String str = "";
		if(packageId == 1){
			str = "免费用户(三次机会)";
		}else if(packageId == 2){
			str = "初级用户";
		}else if(packageId == 3){
			str = "中级用户";
		}else if(packageId == 4){
			str = "高级用户";
		}else {
			str = "";
		}
		return str;
	}
	
}
