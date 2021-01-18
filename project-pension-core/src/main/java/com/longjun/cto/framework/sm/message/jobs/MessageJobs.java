package com.longjun.cto.framework.sm.message.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.eims.cto.framework.module.base.jobs.BaseJobs;
import com.longjun.cto.framework.sm.message.service.IMessageEmailService;
import com.longjun.cto.framework.sm.message.service.IMessagePushService;
import com.longjun.cto.framework.sm.message.service.IMessageSmsService;

/**
 * 消息定时任务
 * 
 * @author yangxuan
 * @date 2019年4月8日 下午3:49:48
 */
@Component
public class MessageJobs extends BaseJobs {

	@Autowired
	private IMessageSmsService iMessageSmsService;

	@Autowired
	private IMessageEmailService iMessageEmailService;

	@Autowired
	private IMessagePushService iMessagePushService;

	/**
	 * 短信定时任务 5秒发送一次
	 */
	@Scheduled(fixedRate = 1000 * 5)
	public void sendSmsJobs() {
		if (!isRun()) {
			return;
		}
		log.info("短信发送任务开始");
		final String taskId = "sm-message-sendSmsJobs";
		try {
			if (lock(taskId)) {
				iMessageSmsService.sendJobs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			unlock(taskId);
		}
	}

	/**
	 * 邮件定时任务 5秒发送一次
	 */
	@Scheduled(fixedRate = 1000 * 5)
	public void sendEmailJobs() {
		if (!isRun()) {
			return;
		}
		log.info("邮件发送任务开始");
		final String taskId = "sm-message-sendEmailJobs";
		try {
			if (lock(taskId)) {
				this.iMessageEmailService.sendJobs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			unlock(taskId);
		}
	}

	/**
	 * 推送定时任务 5秒发送一次
	 */
	@Scheduled(fixedRate = 1000 * 5)
	public void sendPushJobs() {
		if (!isRun()) {
			return;
		}
		log.info("推送发送任务开始");
		final String taskId = "sm-message-sendPushJobs";
		try {
			if (lock(taskId)) {
				this.iMessagePushService.sendJobs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			unlock(taskId);
		}
	}

	/**
	 * 推送定时任务 60秒发送一次
	 */
	@Scheduled(fixedRate = 1000 * 30)
	public void sendPushPlainJobs() {
		if (!isRun()) {
			return;
		}
		log.info("推送发送任务开始");
		final String taskId = "sm-message-sendPushPlainJobs";
		try {
			if (lock(taskId)) {
				this.iMessagePushService.sendPushPlainJobs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			unlock(taskId);
		}
	}

}
