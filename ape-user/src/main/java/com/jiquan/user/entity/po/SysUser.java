package com.jiquan.user.entity.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.jiquan.entity.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-09-25 17:57:02
 */
@Data
@TableName("sys_user")
public class SysUser implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    
    private String name;
    
    private Integer age;

}

