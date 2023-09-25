package com.jiquan.user.entity.req;

import com.jiquan.bean.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-09-25 17:57:02
 */
@Data
public class SysUserReq extends PageRequest implements Serializable {

    private String name;
    
    private Integer age;

}

