package com.baidu.totpdemo;

import org.junit.Test;

/**
 * TODO
 *
 * @author meijie05
 * @since 2021/4/5 4:21 PM
 */

public class TOTPTest {

    private String mTotp;

    @Test
    public void test1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int j = 0; j < 10; j++) {
                        String totp = TOTP.generateMyTOTP("account01", "12345");
                        System.out.println(String.format("其他线程==> 加密后: %s", totp));
                        System.out.println("=========================");
                        Thread.sleep(1500);
                    }
                } catch (final Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (int j = 0; j < 100; j++) {
//                        Thread.sleep(100);
//                        System.out.println("柔性校验： " + verifyTOTPFlexibility("account01", "12345", mTotp));
//                    }
//                } catch (final Exception e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }).start();
        try {
            for (int j = 0; j < 10; j++) {
                mTotp = TOTP.generateMyTOTP("account01", "12345");
                System.out.println(String.format("加密后: %s", mTotp));
                Thread.sleep(1000);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

}
