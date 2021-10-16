package com.myteam.mall.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userId;

    private String userAcct;

    private String userName;

    private String nickname;

    private String gender;

    private String email;

    private String contactPhone;

    private String address;

    private String image;

    private String createTime;
}
