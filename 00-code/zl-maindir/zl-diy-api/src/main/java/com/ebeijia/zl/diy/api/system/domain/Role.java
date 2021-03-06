package com.ebeijia.zl.diy.api.system.domain;

import com.ebeijia.zl.diy.api.base.domain.BaseEntity;

public class Role extends BaseEntity implements java.io.Serializable {

	private String id;
	private String roleName; // 角色名称
	private String description; // 备注
	private String loginType;
	private Integer seq; // 排序号
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
}
