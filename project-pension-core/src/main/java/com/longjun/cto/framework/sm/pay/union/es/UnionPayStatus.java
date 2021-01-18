package com.longjun.cto.framework.sm.pay.union.es;

/**
 * 银联支付状态枚举
 * 
 * @author yangxuan
 * @date Nov 2, 2019 - 10:18:56 AM
 */
public enum UnionPayStatus {

	/**
	 * 新订单
	 */
	NEW_ORDER,

	/**
	 * 不明确的交易状态
	 */
	UNKNOWN,

	/**
	 * 在指定时间段内未支付时关闭的交 易;在交易完成全额退款成功时关 闭的交易;支付失败的交易。
	 */
	TRADE_CLOSED,

	/**
	 * 交易创建，等待买家付款。
	 */
	WAIT_BUYER_PAY,

	/**
	 * 支付成功
	 */
	TRADE_SUCCESS,

	/**
	 * 订单转入退货流程 退货可能是部分也可能 是全部。
	 */
	TRADE_REFUND,

	;

}
