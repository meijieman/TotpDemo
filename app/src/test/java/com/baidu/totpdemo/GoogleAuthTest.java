package com.baidu.totpdemo;

/**
 * https://iminto.github.io/post/totp%E7%AE%97%E6%B3%95java%E7%89%88%E6%9C%AC/
 *
 * @author meijie05
 * @since 2021/4/6 12:05 AM
 */

import org.junit.Test;

public class GoogleAuthTest {

    @Test
    public void genSecretTest() {
        String secret = GoogleAuthenticator.generateSecretKey();
        System.out.println("secret=" + secret);
        String url = GoogleAuthenticator.getQRBarcodeURL("testuser", "testhost", secret);
        System.out.println("Please register " + url);
        System.out.println("Secret key is " + secret);
    }

    // Change this to the saved secret from the running the above test.
    static String savedSecret = "VGH25A7M54QPME5F";

    @Test
    public void authTest() throws Exception {
        // enter the code shown on device. Edit this and run it fast before the code expires!
        long code = 146841;
        long t = System.currentTimeMillis();
        GoogleAuthenticator ga = new GoogleAuthenticator();
        ga.setWindowSize(5); //should give 5 * 30 seconds of grace...
        boolean r = ga.check_code(savedSecret, code, t);
        System.out.println("Check code = " + r);
    }
}
