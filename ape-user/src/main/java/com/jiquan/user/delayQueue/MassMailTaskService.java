package com.jiquan.user.delayQueue;

import com.jiquan.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Slf4j
@Service
public class MassMailTaskService {
	private static final String MASS_MAIL_TASK_KEY = "massMailTask";

	@Resource
	private RedisUtil redisUtil;

	public void pushMassMailTaskQueue(MassMailTask massMailTask){
		Date startTime = massMailTask.getStartTime();
		if(startTime == null) return;
		if(startTime.compareTo(new Date()) <= 0) return;
		log.info("获取延迟群发任务，taskIdSet：{}", JSON.toJSON(massMailTask));
		redisUtil.zadd(MASS_MAIL_TASK_KEY, massMailTask.getTaskId(), startTime.getTime());
	}

	public Set<Long> pollMassMailTaskQueue(){
		Set<String> taskIdSet = redisUtil.rangeByScore(MASS_MAIL_TASK_KEY, 0, System.currentTimeMillis());

		log.info("获取延迟群发任务，taskIdSet：{}", JSON.toJSON(taskIdSet));
		if(CollectionUtils.isEmpty(taskIdSet)) return Collections.EMPTY_SET;

		redisUtil.removeZsetList(MASS_MAIL_TASK_KEY, taskIdSet);
		return taskIdSet.stream().map(n -> Long.parseLong(n)).collect(Collectors.toSet());
	}

}
