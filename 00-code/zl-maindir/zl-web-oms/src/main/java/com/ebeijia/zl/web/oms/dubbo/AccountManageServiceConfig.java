package com.ebeijia.zl.web.oms.dubbo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.MethodConfig;
import com.alibaba.dubbo.config.spring.ReferenceBean;
import com.ebeijia.zl.facade.account.service.AccountManageFacade;

/**
 * 服务暴露的接口 配置
 * @author zhuqiuyou
 *
 */
@Configuration
public class AccountManageServiceConfig extends DubboCustomerConfig {

	@Bean
	public ReferenceBean<AccountManageFacade> accountManageFacade() {
		
		ReferenceBean<AccountManageFacade> referenceBean=new ReferenceBean<AccountManageFacade>();
		referenceBean.setInterface(AccountManageFacade.class.getName());
		referenceBean.setVersion("1.0.0");
		referenceBean.setCluster("failfast");
		
		List<MethodConfig> methods=new ArrayList<MethodConfig>();
		/*** dubbo method registerUserInf config*/
		MethodConfig methodConfig=new MethodConfig();
		methodConfig.setName("createAccount");
		methodConfig.setTimeout(120000);
		methodConfig.setRetries(0);
		methods.add(methodConfig); //

		methodConfig=new MethodConfig();
		methodConfig.setName("createAccountList");
		methodConfig.setTimeout(60000);
		methodConfig.setRetries(0);
		methods.add(methodConfig); //
		referenceBean.setMethods(methods);
		
		return referenceBean;
	}
}
