package com.demo.otp.utils;

import java.util.Random;

public class OTPGenerator {

    public static String generateOTP() {
        Random random = new Random();
        int otp = 1000 + random.nextInt(9000); // Generate a random 4-digit number
        return String.valueOf(otp);
    }
}

