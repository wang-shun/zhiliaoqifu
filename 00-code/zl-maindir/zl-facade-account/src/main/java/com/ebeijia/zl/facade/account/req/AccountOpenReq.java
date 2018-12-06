package com.ebeijia.zl.facade.account.req;

import java.math.BigDecimal;

import com.ebeijia.zl.common.utils.req.BaseTxnReq;

/**
* 
* @Description: 账户开户请求参数
*
* @version: v1.0.0
* @author: zhuqi
* @date: 2018年12月3日 下午7:45:37 
*
* Modification History:
* Date         Author          Version
*-------------------------------------*
* 2018年12月3日     zhuqi           v1.0.0
 */
public class AccountOpenReq extends BaseTxnReq {

	private static final long serialVersionUID = -9160098953485698847L;


	/**
	 * 用戶名稱
	 */
	private String userName;
	
	
	/**
	 * 手機號
	 */
	private String mobilePhone;
	
	
	/**
	 * 身份證號
	 */
	private String icardNo;
	
	
	/**
	 * 所属企業
	 */
	private String companyId;
	
	/**
	 * 外部渠道號
	 */
	private String externalId;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public String getIcardNo() {
		return icardNo;
	}


	public void setIcardNo(String icardNo) {
		this.icardNo = icardNo;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getExternalId() {
		return externalId;
	}


	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	
	public static void main(String[] args) {
//        BigDecimal decimal = new BigDecimal(0);
//        System.out.println(decimal);
        BigDecimal setScale = new BigDecimal(0).setScale(4,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(setScale);
	}
}