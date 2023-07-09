package com.demo.otp.service;

import com.demo.otp.utils.OTPGenerator;
import com.demo.otp.values.Mail;
import com.demo.otp.values.TempProfile;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Cacheable(value = "user")
public class HomeService {

    private final MailService mailService;

    private final CacheManager cacheManager;

    public HomeService(MailService mailService, CacheManager cacheManager) {
        this.mailService = mailService;
        this.cacheManager = cacheManager;
    }

    public String sendOtp(String email) {
        String otp = OTPGenerator.generateOTP();
        Mail mail = new Mail();
        mail.setMailFrom("bareetsingh0001@gmail.com");
        mail.setMailTo(email);
        mail.setMailSubject("OTP Verification");
        mail.setMailContent(otp);
        mailService.sendEmail(mail);

        String tempId = UUID.randomUUID().toString();
        TempProfile tempProfile = new TempProfile();
        tempProfile.setOtp(otp);
        tempProfile.setEmail(email);
        tempProfile.setTempId(tempId);
        Cache cache = cacheManager.getCache("user");
        cache.put(tempId, tempProfile);

        return tempId;
    }

    public String verifyOtp(String tempId, String otp) {
        Cache cache = cacheManager.getCache("user");
        TempProfile tempProfile = cache.get(tempId, TempProfile.class);

        if (tempProfile != null && tempProfile.getOtp().equals(otp)) {
            return "OTP verified Successfully";
        } else {
            return "Invalid OTP";
        }
    }

}
