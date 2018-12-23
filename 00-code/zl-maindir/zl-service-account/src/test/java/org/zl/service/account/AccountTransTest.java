package org.zl.service.account;


import java.math.BigDecimal;

import com.ebeijia.zl.facade.account.req.AccountConsumeReqVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONArray;
import com.ebeijia.zl.AccountApp;
import com.ebeijia.zl.common.utils.IdUtil;
import com.ebeijia.zl.common.utils.domain.BaseResult;
import com.ebeijia.zl.common.utils.enums.SpecAccountTypeEnum;
import com.ebeijia.zl.common.utils.enums.TransChnl;
import com.ebeijia.zl.common.utils.enums.TransCode;
import com.ebeijia.zl.common.utils.enums.UserChnlCode;
import com.ebeijia.zl.common.utils.enums.UserType;
import com.ebeijia.zl.facade.account.req.AccountRechargeReqVo;
import com.ebeijia.zl.facade.account.req.AccountTransferReqVo;
import com.ebeijia.zl.facade.account.service.AccountTransactionFacade;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApp.class)//这里的Application是springboot的启动类名
public class AccountTransTest {

	@Autowired
	private AccountTransactionFacade  accountTransactionFacade;


	/**
	 * 给供应商充值
	 * 
	* @Description: 该函数的功能描述
	*
	* @param:描述1描述
	*
	* @version: v1.0.0
	* @author: zhuqi
	* @date: 2018年12月14日 上午9:41:38 
	*
	* Modification History:
	* Date         Author          Version
	*-------------------------------------*
	* 2018年12月14日     zhuqi           v1.0.0
	 */
/*    @Test
   public void executeRechargeToPrivoder() throws Exception{
    	AccountRechargeReqVo req=new AccountRechargeReqVo();
    	
    	req.setTransId(TransCode.MB20.getCode());
    	req.setTransChnl(TransChnl.CHANNEL0.toString());
    	req.setUserChnl(UserChnlCode.USERCHNL1001.getCode());
    	req.setUserChnlId("300000000000000000000000");
    	req.setUserType(UserType.TYPE300.getCode());
    	req.setFromCompanyId("300000000000000000000000");
    	req.setTransAmt(new BigDecimal(500000));
    	req.setUploadAmt(new BigDecimal(500000));
    	req.setDmsRelatedKey(IdUtil.getNextId());
    	req.setPriBId(SpecAccountTypeEnum.A00.getbId());
    	req.setTransDesc("供应商上账");
    	
    	accountTransactionFacade.executeRecharge(req);
   }*/

	/**
	 * 分销商充值
	 * @throws Exception
	 */
 /*   @Test
   public void executeRechargeToRetail() throws Exception{

    	AccountRechargeReqVo req=new AccountRechargeReqVo();
    	req.setTransId(TransCode.MB20.getCode());
    	req.setTransChnl(TransChnl.CHANNEL0.toString());
    	req.setUserChnl(UserChnlCode.USERCHNL1001.getCode());
    	req.setUserChnlId("0e04cf948e2af629a334c7c71fa3f8888");
    	req.setUserType(UserType.TYPE400.getCode());
    	req.setFromCompanyId("0e04cf948e2af629a334c7c71fa3f8888");
    	req.setTransAmt(new BigDecimal(50000000));
    	req.setUploadAmt(new BigDecimal(5000000));
    	req.setDmsRelatedKey(IdUtil.getNextId());
    	req.setPriBId(SpecAccountTypeEnum.B06.getbId());
    	req.setTransDesc("分销商充值");
    	accountTransactionFacade.executeRecharge(req);
   }*/
	
	
	
 /**
  * 
 * @Description: 供应商转账给ZL平台
 *
 * @param:描述1描述
 *
 * @version: v1.0.0
 * @author: zhuqi
 * @date: 2018年12月14日 上午10:04:34 
 *
 * Modification History:
 * Date         Author          Version
 *-------------------------------------*
 * 2018年12月14日     zhuqi           v1.0.0
  */
//  @Test
// public void executePrivoderTransferToZL() throws Exception{
//	  AccountTransferReqVo req=new AccountTransferReqVo();
//  	
//  	req.setTransId(TransCode.MB40.getCode());
//  	req.setTransChnl(TransChnl.CHANNEL0.toString());
//  	req.setUserChnl(UserChnlCode.USERCHNL1001.getCode());
//  	req.setUserChnlId("300000000000000000000000");
//  	req.setUserType(UserType.TYPE300.getCode());
//  
//  	req.setTransAmt(new BigDecimal(500000));
//  	req.setUploadAmt(new BigDecimal(500000));
//  	req.setDmsRelatedKey(IdUtil.getNextId());
//  	req.setTfrOutUserId("300000000000000000000000");
//	req.setTfrOutBId(SpecAccountTypeEnum.A00.getbId());
//	req.setTfrInUserId("200000000000000000000000");
//	req.setTfrInBId(SpecAccountTypeEnum.A00.getbId());
//  	
//  	accountTransactionFacade.executeTransfer(req);
// }
	
	
 /**
  * 
 * @Description: 知了转账给企业
 *
 * @param:描述1描述
 *
 * @version: v1.0.0
 * @author: zhuqi
 * @date: 2018年12月14日 上午10:25:31 
 *
 * Modification History:
 * Date         Author          Version
 *-------------------------------------*
 * 2018年12月14日     zhuqi           v1.0.0
  */
//  @Test
// public void executePrivoderTransferToZL() throws Exception{
//	  AccountTransferReqVo req=new AccountTransferReqVo();
//  	
//  	req.setTransId(TransCode.MB40.getCode());
//  	req.setTransChnl(TransChnl.CHANNEL0.toString());
//  	req.setUserChnl(UserChnlCode.USERCHNL1001.getCode());
//  	req.setUserChnlId("200000000000000000000000");
//  	req.setUserType(UserType.TYPE200.getCode());
//  
//  	req.setTransAmt(new BigDecimal(500000));
//  	req.setUploadAmt(new BigDecimal(500000));
//  	req.setDmsRelatedKey(IdUtil.getNextId());
//  	req.setTfrOutUserId("200000000000000000000000");
//	req.setTfrOutBId(SpecAccountTypeEnum.A00.getbId());
//	req.setTfrInUserId("200000000000000000000001");
//	req.setTfrInBId(SpecAccountTypeEnum.A00.getbId());
//  	
//	BaseResult<Object> result= accountTransactionFacade.executeTransfer(req);
//	
//	System.out.println(JSONArray.toJSONString(result));
// }
	
	

//  @Test
// public void executeRechargeToUser() throws Exception{
//	  AccountTransferReqVo req=new AccountTransferReqVo();
//  	
//	req.setTransId(TransCode.MB50.getCode());
//	req.setTransChnl(TransChnl.CHANNEL0.toString());
//	req.setUserChnl(UserChnlCode.USERCHNL1001.getCode());
//	req.setUserChnlId("200000000000000000000001");
//	req.setUserType(UserType.TYPE200.getCode());
//
//	req.setTransAmt(new BigDecimal(500000));
//	req.setUploadAmt(new BigDecimal(500000));
//	req.setDmsRelatedKey(IdUtil.getNextId());
//	req.setTfrOutUserId("200000000000000000000001");
//	req.setTfrOutBId(SpecAccountTypeEnum.A00.getbId());
//	req.setTfrInUserId("13501755206");
//	req.setTfrInBId(SpecAccountTypeEnum.A00.getbId());
//	
//	BaseResult<Object> result= accountTransactionFacade.executeTransfer(req);
//	
//	System.out.println(JSONArray.toJSONString(result));
// }


   @Test
   public void executeConsumeToRetail() throws Exception{

	   AccountConsumeReqVo req=new AccountConsumeReqVo();
    	req.setTransId(TransCode.MB10.getCode());
    	req.setTransChnl(TransChnl.CHANNEL0.toString());
    	req.setUserChnl(UserChnlCode.USERCHNL1001.getCode());
    	req.setUserChnlId("0e04cf948e2af629a334c7c71fa3f8888");
    	req.setUserType(UserType.TYPE400.getCode());
    	req.setTransAmt(new BigDecimal(1000));
    	req.setUploadAmt(new BigDecimal(1000));
    	req.setDmsRelatedKey(IdUtil.getNextId());
    	req.setPriBId(SpecAccountTypeEnum.B06.getbId());
    	req.setTransDesc("分销商消费");
	   BaseResult result=accountTransactionFacade.executeConsume(req);
	   System.out.println(JSONArray.toJSONString(result));
   }
	
}