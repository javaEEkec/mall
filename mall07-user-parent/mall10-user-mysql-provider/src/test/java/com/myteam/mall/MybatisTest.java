package com.myteam.mall;

import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.mapper.UserPOMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserPOMapper userPOMapper;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.debug(connection.toString());
    }

    @Test
    public void testMapper(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String source = "123456";
        //SHA-256+随机盐+密钥对密码进行加密
        String encode = bCryptPasswordEncoder.encode(source);
        UserPO userPO = new UserPO(null,"2269213","ljs",encode,"abaaba","f","linjs6288@gmail.com",
                "13690596288","广州市天河区龙洞广东金融学院","img1.jpg",new Date());
        userPOMapper.insert(userPO);
    }

}
