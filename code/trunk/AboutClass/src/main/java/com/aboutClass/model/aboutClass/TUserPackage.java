package com.aboutClass.model.aboutClass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.aboutClass.model.IdEntity;

/**
 * TUserPackage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_user_package")
public class TUserPackage extends IdEntity{
	private static final long serialVersionUID = 1L;
	private String name;
	@Column(name = "user_id")
	private int userId;
	@Column(name = "agency_num")
	private int agencyNum;
	@Column(name = "compete_num")
	private int competeNum;
	@Column(name = "consultancy_num")
	private int consultancyNum;
	@Column(name = "industry_num")
	private int industryNum;
	@Column(name = "nexus_num")
	private int nexusNum;
	@Column(name = "orderunit_num")
	private int orderunitNum;
	@Column(name = "project_num")
	private int projectNum;
	@Column(name = "regulator_num")
	private int regulatorNum;
	@Column(name = "report_num")
	private int reportNum;
	@Column(name = "subscriber_num")
	private int subscriberNum;
	@Column(name = "tenders_num")
	private int tendersNum;
	private String remark;
	
	public TUserPackage() {
		
	}
	public int getAgencyNum() {
		return this.agencyNum;
	}

	public void setAgencyNum(int agencyNum) {
		this.agencyNum = agencyNum;
	}

	public int getCompeteNum() {
		return this.competeNum;
	}

	public void setCompeteNum(int competeNum) {
		this.competeNum = competeNum;
	}

	public int getConsultancyNum() {
		return this.consultancyNum;
	}

	public void setConsultancyNum(int consultancyNum) {
		this.consultancyNum = consultancyNum;
	}

	public int getIndustryNum() {
		return this.industryNum;
	}

	public void setIndustryNum(int industryNum) {
		this.industryNum = industryNum;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNexusNum() {
		return this.nexusNum;
	}

	public void setNexusNum(int nexusNum) {
		this.nexusNum = nexusNum;
	}

	public int getOrderunitNum() {
		return this.orderunitNum;
	}

	public void setOrderunitNum(int orderunitNum) {
		this.orderunitNum = orderunitNum;
	}

	public int getProjectNum() {
		return this.projectNum;
	}

	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}

	public int getRegulatorNum() {
		return this.regulatorNum;
	}

	public void setRegulatorNum(int regulatorNum) {
		this.regulatorNum = regulatorNum;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getReportNum() {
		return this.reportNum;
	}

	public void setReportNum(int reportNum) {
		this.reportNum = reportNum;
	}

	public int getSubscriberNum() {
		return this.subscriberNum;
	}

	public void setSubscriberNum(int subscriberNum) {
		this.subscriberNum = subscriberNum;
	}

	public int getTendersNum() {
		return this.tendersNum;
	}

	public void setTendersNum(int tendersNum) {
		this.tendersNum = tendersNum;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

}