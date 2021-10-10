package com.myteam.mall.test;

import com.myteam.mall.util.MallUtil;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void testMd5(){
        String source = "123456";
        String encoding = MallUtil.md5(source);
        System.out.println(encoding);
    }

    @Test
    public void testInteger(){
        Integer i = 100;
        Integer j = 0;
        System.out.println( -i <= 0);
    }
}
