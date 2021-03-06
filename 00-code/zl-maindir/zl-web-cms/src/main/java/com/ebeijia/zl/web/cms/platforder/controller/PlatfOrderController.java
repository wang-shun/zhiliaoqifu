package com.ebeijia.zl.web.cms.platforder.controller;

import com.ebeijia.zl.common.utils.domain.BaseResult;
import com.ebeijia.zl.common.utils.enums.GoodsEcomCodeTypeEnum;
import com.ebeijia.zl.common.utils.enums.PlatfOrderPayStatEnum;
import com.ebeijia.zl.common.utils.enums.SubOrderStatusEnum;
import com.ebeijia.zl.common.utils.tools.NumberUtils;
import com.ebeijia.zl.common.utils.tools.StringUtil;
import com.ebeijia.zl.shop.dao.order.domain.TbEcomPlatfOrder;
import com.ebeijia.zl.shop.dao.order.domain.TbEcomPlatfShopOrder;
import com.ebeijia.zl.shop.dao.order.service.ITbEcomPlatfShopOrderService;
import com.ebeijia.zl.web.cms.platforder.service.PlatfOrderInfService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("platforder")
public class PlatfOrderController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private PlatfOrderInfService platfOrderInfService;

	@Autowired
	private ITbEcomPlatfShopOrderService ecomPlatfShopOrderService;

	/**
	 * 查询电商平台一级订单信息
	 * 
	 * @param req
	 * @param platfOrder
	 * @return
	 */
	@RequestMapping(value = "/getPlatfOrderList")
	public ModelAndView getPlatfOrderList(HttpServletRequest req, TbEcomPlatfOrder platfOrder) {
		ModelAndView mv = new ModelAndView("platforder/listPlatfOrder");
		int startNum = NumberUtils.parseInt(req.getParameter("pageNum"), 1);
		int pageSize = NumberUtils.parseInt(req.getParameter("pageSize"), 10);
		PageInfo<TbEcomPlatfOrder> pageInfo = new PageInfo<>();
		try {
			pageInfo = platfOrderInfService.getPlatfOrderListPage(startNum, pageSize, platfOrder);
		} catch (Exception e) {
			logger.error("## 查询商城一级订单异常[{}]", e);
		}
		mv.addObject("payStatusList", PlatfOrderPayStatEnum.values());
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("platfOrder", platfOrder);
		return mv;
	}

	/**
	 * 查询电商平台二级订单信息(根据一级订单查询)
	 * 
	 * @param req
	 * @param platfShopOrder
	 * @return
	 */
	@RequestMapping(value = "/getPlatfShopOrderListByPlatfOrder")
	public ModelAndView getPlatfShopOrderListByPlatfOrder(HttpServletRequest req, TbEcomPlatfShopOrder platfShopOrder) {
		ModelAndView mv = new ModelAndView("platforder/listPlatfShopOrderByPlatfOrder");
		int startNum = NumberUtils.parseInt(req.getParameter("pageNum"), 1);
		int pageSize = NumberUtils.parseInt(req.getParameter("pageSize"), 10);
		String orderId = req.getParameter("orderId");
		if (!StringUtil.isNullOrEmpty(platfShopOrder.getOrderId())) {
			orderId = platfShopOrder.getOrderId();
		}
		PageInfo<TbEcomPlatfShopOrder> pageInfo = new PageInfo<>();
		if (!StringUtil.isNullOrEmpty(orderId)) {
			platfShopOrder.setOrderId(orderId);
			try {
				pageInfo = platfOrderInfService.getPlatfShopOrderListPageByPlatOrder(startNum, pageSize, platfShopOrder);
			} catch (Exception e) {
				logger.error("## 根据一级订单查询商城二级订单异常[{}]", e);
			}
		}
		mv.addObject("subOrderStatusList", SubOrderStatusEnum.values());
		mv.addObject("orderId", orderId);
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("platfShopOrder", platfShopOrder);
		return mv;
	}

	/**
	 * 电商二级订单查询列表
	 *
	 * @param req
	 * @param platfShopOrder
	 * @return
	 */
	@RequestMapping(value = "/getPlatfShopOrderList")
	public ModelAndView getPlatfShopOrderList(HttpServletRequest req, TbEcomPlatfShopOrder platfShopOrder) {
		ModelAndView mv = new ModelAndView("platforder/listPlatfShopOrder");
		int startNum = NumberUtils.parseInt(req.getParameter("pageNum"), 1);
		int pageSize = NumberUtils.parseInt(req.getParameter("pageSize"), 10);

		PageInfo<TbEcomPlatfShopOrder> pageInfo = new PageInfo<>();
		try {
			pageInfo = platfOrderInfService.getPlatfShopOrderListPage(startNum, pageSize, platfShopOrder);
		} catch (Exception e) {
			logger.error("## 查询商城二级订单异常[{}]", e);
		}
		mv.addObject("ecomCodeList", GoodsEcomCodeTypeEnum.values());
		mv.addObject("subOrderStatusList", SubOrderStatusEnum.values());
		mv.addObject("payStatusList", PlatfOrderPayStatEnum.values());
		mv.addObject("pageInfo", pageInfo);
		mv.addObject("platfShopOrder", platfShopOrder);
		return mv;
	}

	/**
	 * 针对二级订单进行发货处理
	 * @param req
	 * @return
	 */
	@PostMapping(value = "/orderDeliverGoods")
	public BaseResult<Object> orderDeliverGoods(HttpServletRequest req) {
		BaseResult<Object> result = platfOrderInfService.updateOrderGoodsDeliverCheck(req);
		return result;
	}

}