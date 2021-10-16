package com.myteam.mall;

import com.myteam.mall.entity.po.OnlineProduct;
import com.myteam.mall.entity.po.OrderPO;
import com.myteam.mall.entity.po.UserPO;
import com.myteam.mall.entity.vo.OrderProductUserVO;
import com.myteam.mall.entity.vo.PortalCategoryVO;
import com.myteam.mall.entity.vo.ProductSimpleVO;
import com.myteam.mall.entity.vo.UserDetailVO;
import com.myteam.mall.mapper.OnlineProductMapper;
import com.myteam.mall.mapper.UserPOMapper;
import com.myteam.mall.service.api.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MybatisTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserPOMapper userPOMapper;

    @Autowired
    private OnlineProductMapper onlineProductMapper;

    @Autowired
    private OrderService orderService;

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

    @Test
    public void testSelectID(){
        UserPO userPO = userPOMapper.selectByPrimaryKey(6);
        System.out.println(userPO);
    }

    @Test
    public void testCopy(){
        UserPO userPO = userPOMapper.selectByPrimaryKey(1);
        UserDetailVO userDetailVO = new UserDetailVO();
        BeanUtils.copyProperties(userPO,userDetailVO);
        System.out.println(userPO);
        System.out.println(userDetailVO);
    }

    @Test
    public void testLoadCategoryData(){
        List<PortalCategoryVO> portalCategoryVOList = onlineProductMapper.selectPortalCategoryVOList();

        for (PortalCategoryVO portalCategoryVO : portalCategoryVOList) {
            String category = portalCategoryVO.getCategory();
            log.info("category="+category);
            List<ProductSimpleVO> productSimpleVOList = portalCategoryVO.getProductSimpleVOList();
            for (ProductSimpleVO productSimpleVO: productSimpleVOList) {
                if (productSimpleVO == null){
                    continue;
                }
                log.info(productSimpleVO.toString());
            }
        }
    }

    @Test
    public void testSelectProductsByKeyword(){
        List<ProductSimpleVO> productSimpleVOList = onlineProductMapper.selectProductsByKeyword("水果");
        for (ProductSimpleVO p:
             productSimpleVOList) {
            if (p == null){
                continue;
            }
            log.info(p.toString());
        }
    }

    @Test
    public void testSelectProductById(){
        OnlineProduct onlineProduct = onlineProductMapper.selectByPrimaryKey(3);
        System.out.println(onlineProduct);
    }


    @Test
    public void testOrderById(){
        List<OrderProductUserVO> order = orderService.getOrderByUserId(7);
        System.out.println(order);
    }

    @Test
    public void getLastOrder(){
        OrderPO lastOrder = orderService.getLastOrder();
        System.out.println(lastOrder);
    }

    @Test
    public void insertRelation(){
        orderService.insertInnerOrderProduct(1,1);
    }
}
