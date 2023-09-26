package com.jiquan.user.entity.req;

import com.jiquan.bean.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2023-09-25 17:57:02
 */
@Data
public class SysUserReq extends PageRequest implements Serializable {

    private Long id;

    private String name;
    
    private Integer age;

}

