package com.jiquan.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Component
public class CustomMetaObjectHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		this.strictInsertFill(metaObject, "createBy", String.class, "jiquan");
		this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
		this.strictInsertFill(metaObject, "deleteFlag", Integer.class, 0);
		this.strictInsertFill(metaObject, "version", Integer.class, 0);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.strictUpdateFill(metaObject, "updateBy", String.class, "updater");
		this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
	}
}
