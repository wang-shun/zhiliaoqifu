package com.ebeijia.zl.web.oms.providerChnl.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ebeijia.zl.common.utils.enums.TelRechargeConstants.providerOrderRechargeState;
import com.ebeijia.zl.common.utils.tools.NumberUtils;
import com.ebeijia.zl.common.utils.tools.StringUtil;
import com.ebeijia.zl.facade.telrecharge.domain.ProviderOrderInf;
import com.ebeijia.zl.facade.telrecharge.service.ProviderOrderInfFacade;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping(value = "provider/providerOrderInf")
public class ProviderOrderInfController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ProviderOrderInfFacade providerOrderInfFacade;

	/**
	 * 供应商订单列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listProviderOrderInf")
	public ModelAndView listProviderOrderInf(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("provider/providerOrderInf/listProviderOrderInf");
		String operStatus = StringUtil.nullToString(req.getParameter("operStatus"));
		int startNum = NumberUtils.parseInt(req.getParameter("pageNum"), 1);
		int pageSize = NumberUtils.parseInt(req.getParameter("pageSize"), 10);
		try {
			ProviderOrderInf providerOrderInf = this.getProviderOrderInf(req);
			PageInfo<ProviderOrderInf> pageList = providerOrderInfFacade.getProviderOrderInfPage(startNum, pageSize, providerOrderInf);
			mv.addObject("pageInfo", pageList);
			mv.addObject("providerOrderInf", providerOrderInf);
		} catch (Exception e) {
			logger.error("## 供应商订单列表查询异常", e);
		}
		mv.addObject("rechargeStateList", providerOrderRechargeState.values());
		mv.addObject("operStatus", operStatus);
		return mv;
	}

	/**
	 * 封装供应商订单
	 * 
	 * @param req
	 * @return
	 */
	public ProviderOrderInf getProviderOrderInf(HttpServletRequest req) {
		ProviderOrderInf providerOrderInf = new ProviderOrderInf();
		providerOrderInf.setRegOrderId(StringUtil.nullToString(req.getParameter("regOrderId")));
		providerOrderInf.setChannelOrderId(StringUtil.nullToString(req.getParameter("channelOrderId")));
		providerOrderInf.setBillId(StringUtil.nullToString(req.getParameter("billId")));
		return providerOrderInf;
	}
}