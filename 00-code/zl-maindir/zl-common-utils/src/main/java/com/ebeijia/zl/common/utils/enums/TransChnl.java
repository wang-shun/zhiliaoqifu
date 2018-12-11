package com.ebeijia.zl.common.utils.enums;
/**
 * 交易渠道
 * @author Administrator
 *
 */
public enum TransChnl {

	CHANNEL0("10001001"),//管理平台
	//		CHANNEL1("40001001"),// 商户开户、客户开户、密码重置、消费 (从微信公众号发起) /** 公众号（开茂）使用 **/
	CHANNEL1("40001010"),// 商户开户、客户开户、密码重置、消费 (从微信公众号发起) /** 公众号（衡翮）使用 **/
	CHANNEL2("40002001"),// 充值、商户提现  (从微信公众号发起)
	CHANNEL3("40003001"),// 充值、商户提现  (从支付宝发起)
	CHANNEL4("40004001"),// 充值、商户提现  (从嘉福平台发起)
	CHANNEL5("40005001"),// 充值、商户提现  (从网银向本系统发起)
	CHANNEL6("40006001"),// all  (从电商端发起)
	CHANNEL7("40001002"),// 消费 (会员卡兼容通卡)
	CHANNEL8("40007001"),//手机充值(话费充值)
	CHANNEL9("40008001"),//卡券集市
	CHANNEL10("40007002"),//手机充值（流量充值）
	CHANNEL11("40009001");//电商平台发起组合支付

	private final String value;

	TransChnl(String value) {
		this.value = value;
	};

	@Override
	public String toString() {
		return this.value;
	}

	public static TransChnl findByCode(String code) {
		for (TransChnl t : TransChnl.values()) {
			if (t.value.equalsIgnoreCase(code)) {
				return t;
			}
		}
		return null;
	}
}