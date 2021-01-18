package com.longjun.cto.framework.sm.pay.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.eims.cto.framework.module.base.jobs.BaseJobs;
import com.longjun.cto.framework.sm.pay.service.IPayOrderApi;
import com.longjun.cto.framework.sm.pay.service.IPayRefundOrderService;

/**
 * 订单支付定时任务
 * @author yangxuan
 * @date 2019年3月25日 下午1:40:44
 */
//@Component
public class PayOrderJobs extends BaseJobs{
	
	@Autowired
	IPayOrderApi iPayOrderApi;
	
	@Autowired
	IPayRefundOrderService iPayRefundOrderService; 

	
	
	@Scheduled(fixedRate = 1000 * 30)
	public void execBuzNotifyJobs() {
		if(!isRun()){
			return;
		}
		log.info("标准业务模块-支付模块-定时任务-异步通知结果处理开始");
		final String taskId = "Jobs-service-module-pay-execBuzNotifyJobs";
		try{
			if(lock(taskId)) {
				this.iPayOrderApi.execBuzNotifyJobs();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			unlock(taskId);
		}
	}
	
	/**
	 * 退款定时任务
	 */
//	@Scheduled(fixedRate = 1000 * 30)
	public void refundsJobs() {
		if(!isRun()){
			return;
		}
		log.info("标准业务模块-支付模块-定时任务-退款定时任务开始");
		final String taskId = "Jobs-service-module-pay-refundsJobs";
		try{
			if(lock(taskId)) {
				this.iPayRefundOrderService.refundsJobs();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			unlock(taskId);
		}
	}
	 
	/**
	 * 退款查询定时任务
	 */
//	@Scheduled(fixedRate = 1000 * 30)
	public void refundsQueryJobs() {
		if(!isRun()){
			return;
		}
		log.info("标准业务模块-支付模块-定时任务-退款查询定时任务开始");
		final String taskId = "Jobs-service-module-pay-refundsQueryJobs";
		try{
			if(lock(taskId)) {
				this.iPayRefundOrderService.refundsQueryJobs();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			unlock(taskId);
		}
	}
	 

}
