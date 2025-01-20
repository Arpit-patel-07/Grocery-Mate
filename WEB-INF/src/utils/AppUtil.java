package utils;

import java.util.Random;
import java.util.Date;

public class AppUtil {
    static Random random = new Random();
    
    public static String generateEmailVerificationCode() {
        return new Date().getTime()+"_"+Math.abs(random.nextLong());
    }

    public static int generateOTP() {
        return random.nextInt(888889) + 111111;
    }
}


