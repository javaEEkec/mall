package com.myteam.mall.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ljs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {

    private String userAcct;

    private String userName;

    private String userPswd;

    private String email;

    private String contactPhone;
}
