package com.wang.crud.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author zsw
 * @create 2021-12-07 22:21
 */

public class jedisTest {
    @Test
    public void testJ() throws InterruptedException {

        String code =getCode();
        String phone="17860550672";
        setCode(phone,code);
        Jedis jedis = new Jedis("192.168.154.128",6379);
        String verifyCode=jedis.get("VerifyCode"+phone +"code");
//        Thread.sleep(7000);
        System.out.println(verifyCode);
        String testcode ="12345";
        boolean con=verify(testcode,verifyCode);
        System.out.println(con);


    }

    public static boolean verify(String code1,String code2){
        if (code1.equals(code2)){
            return true;
        }else{
            return  false;
        }


    }


    public  static int setCode(String phone,String code){
        Jedis jedis = new Jedis("192.168.154.128",6379);
         String verifyCode ="VerifyCode"+phone +"code";
         String verifyCount ="verifyCount" +phone+"count";
        String count = jedis.get(verifyCount);
        System.out.println(count);
        if (count==null){
             jedis.setex(verifyCount,24*60*60,"1");

         }else if (Integer.parseInt(count)<3){
                   jedis.incr(verifyCount);
        }else {
            return 0;
        }
        jedis.setex(verifyCode,120,code);
        jedis.close();
        return  1;
    }





//     生成验证码
    public  static  String  getCode(){
        Random random = new Random();
        String s="";
        for (int i = 0; i <6; i++) {
            int code = random.nextInt(10);

            s=s+code;
        }

        return s;
    }












}
