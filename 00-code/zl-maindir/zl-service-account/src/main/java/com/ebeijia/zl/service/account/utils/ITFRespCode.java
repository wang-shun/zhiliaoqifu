package com.ebeijia.zl.service.account.utils;

/**
	 *
	 * 核心接口返回码
	 *
	 */
	public enum ITFRespCode {
		CODE00("00", "交易成功"),
		CODE1001("1001", "查发卡行"),
		CODE1003("1003", "无效商户"),
		CODE1004("1004", "受限商户"),
		CODE1006("1006", "无效合同"),
		CODE1007("1007", "终端已经下载过TMK"),
		CODE1008("1008", "终端未签到"),
		CODE1009("1009", "文件不存在"),
		CODE1010("1010", "文件打开错误"),
		CODE1012("1012", "无效交易"),
		CODE1013("1013", "无效金额"),
		CODE1014("1014", "无效卡号包括销毁状态"),
		CODE1015("1015", "卡未找到"),
		CODE1016("1016", "卡未激活"),
		CODE1017("1017", "与原交易卡号不符"),
		CODE1020("1020", "无效应答"),
		CODE1021("1021", "账户不匹配"),
		CODE1022("1022", "怀疑操作有误"),
		CODE1023("1023", "不可接受的手续费"),
		CODE1025("1025", "未找到原交易"),
		CODE1026("1026", "原交易不成功"),
		CODE1027("1027", "退款金额大于支付金额"),
		CODE1031("1031", "路由失败-机构不支持"),
		CODE1034("1034", "有作弊嫌疑"),
		CODE1036("1036", "卡已锁定"),
		CODE1039("1039", "交易日期有误"),
		CODE1040("1040", "请求的功能尚不支持"),
		CODE1041("1041", "卡已挂失"),
		CODE1042("1042", "无效账户商户合同下未关联账户"),
		CODE1044("1044", "卡被注销"),
		CODE1045("1045", "卡被冻结"),
		CODE1051("1051", "余额不足"),
		CODE1054("1054", "过期的卡"),
		CODE1055("1055", "密码错"),
		CODE1056("1056", "无此卡记录"),
		CODE1057("1057", "不允许持卡人进行的交易"),
		CODE1058("1058", "不允许终端进行的交易"),
		CODE1061("1061", "单笔交易金额超限"),
		CODE1063("1063", "余额不正确"),
		CODE1064("1064", "与原交易金额不符"),
		CODE1065("1065", "提现次数超限"),
		CODE1066("1066", "充值次数超限"),
		CODE1067("1067", "单日累计交易超限"),
		CODE1068("1068", "单月累计交易超限"),
	    CODE1069("1069", "银行卡交易超限"),
		CODE1072("1072", "无效IC卡信息"),
		CODE1074("1074", "cvv2不正确"),
		CODE1075("1075", "密码错误次数超限"),
		CODE1077("1077", "pos批次不一致重新签到"),
		CODE1080("1080", "购卡次数超限"),
		CODE1090("1090", "系统正在批处理日切中"),
		CODE1091("1091", "通信失败"),
		CODE1092("1092", "设施找不到或无法达到"),
		CODE1094("1094", "重复交易"),
		CODE1095("1095", "加密失败"),
		CODE1096("1096", "系统故障"),
		CODE1097("1097", "无效终端"),
		CODE1099("1099", "格式错误"),
		CODE10A0("10A0", "MAC错");

		private String code;

		private String value;

		ITFRespCode(String code, String value) {
			this.code = code;
			this.value = value;
		}

		public String getCode() {
			return code;
		}

		public String getValue() {
			return value;
		}

		public static ITFRespCode findByCode(String code) {
			for (ITFRespCode itf : ITFRespCode.values()) {
				if (itf.code.equalsIgnoreCase(code)) {
					return itf;
				}
			}
			return null;
		}
	}
