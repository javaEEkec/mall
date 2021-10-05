package com.myteam.mall.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ljs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private String userName;

    private String email;
}
