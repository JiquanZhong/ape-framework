package com.jiquan.user.controller;

import com.alibaba.fastjson.JSON;
import com.jiquan.redis.util.RedisShareLockUtil;
import com.jiquan.user.UserApplication;
import com.jiquan.user.delayQueue.MassMailTask;
import com.jiquan.user.delayQueue.MassMailTaskService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.UUID;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@SpringBootTest(classes = {UserApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class MassMailTaskTest {
	@Resource
	private MassMailTaskService massMailTaskService;

	@Resource
	private RedisShareLockUtil redisShareLockUtil;

	@Test
	public void push() throws Exception {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		MassMailTask massMailTask = new MassMailTask();
		massMailTask.setTaskId(1L);
		massMailTask.setStartTime(simpleDateFormat.parse("2023-10-03 02:13:00"));
		massMailTaskService.pushMassMailTaskQueue(massMailTask);
		log.info("定时任务已插入！");
	}

	@Test
	public void deal() {
		String lockKey = "test.delay.task";
		String requestId = UUID.randomUUID().toString();
		try {
			boolean locked = redisShareLockUtil.lock(lockKey, requestId, 5L);
			if (!locked) {
				return;
			}
			Set<Long> taskIdSet = massMailTaskService.pollMassMailTaskQueue();
			log.info("DelayTaskTest.deal.taskIdSet:{}", JSON.toJSON(taskIdSet));
			if (CollectionUtils.isEmpty(taskIdSet)) {
				return;
			}
			// 执行其他的业务逻辑
		} catch (Exception e) {
			log.error("延时任务拉取执行失败：{}", e.getMessage(), e);
		} finally {
			redisShareLockUtil.unlock(lockKey,requestId);
		}
	}
}
