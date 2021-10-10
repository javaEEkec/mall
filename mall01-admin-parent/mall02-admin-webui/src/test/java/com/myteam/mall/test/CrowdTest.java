package com.myteam.mall.test;


import com.github.pagehelper.PageInfo;
import com.myteam.mall.entity.Admin;
import com.myteam.mall.entity.InventoryProductVO;
import com.myteam.mall.entity.Shop;
import com.myteam.mall.mapper.AdminMapper;
import com.myteam.mall.mapper.InventoryProductMapper0;
import com.myteam.mall.service.api.AdminService;
import com.myteam.mall.service.api.InventoryProductService;
import com.myteam.mall.service.api.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringJUnitConfig(locations = {"classpath:spring-persist-tx.xml","classpath:spring-persist-mybatis.xml"})
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private ShopService shopService;

    @Autowired
    private InventoryProductService inventoryProductService;

    @Autowired
    private InventoryProductMapper0 inventoryProductMapper0;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testInsertAdmin(){
        Admin admin  = new Admin(null,"22305","jessie","123456","user_admin");
        int count = adminMapper.insert(admin);
        System.out.println(count);

    }

    @Test
    public void testTx(){
        Admin admin  = new Admin(null,"22692","ljs","123456","user_admin");
        adminService.saveAdmin(admin);
    }

    @Test
    public void saveShop(){
        Shop shop = new Shop(null,"10004","platform33","老刘","1254862588","12345");

        shopService.saveShop(shop);
    }

    @Test
    public void testPageShop(){
        PageInfo<Shop> pageInfo = shopService.getPageInfo("", 1, 2);
        System.out.println(pageInfo);
    }

    @Test
    public void testInventoryProductVOPageInfo(){
        PageInfo<InventoryProductVO> productPageInfo = inventoryProductService.getProductPageInfo("", 1, 5);
        System.out.println(productPageInfo);
    }

    @Test
    public void testGetInventoryNum(){
        Integer integer = inventoryProductMapper0.selectInventoryNum(1);
        System.out.println("inventoryNum="+integer);
    }

    @Test
    public void testChangeInventoryNum(){
        inventoryProductService.increaseOrDecreaseInventory(1,110);
    }

}
