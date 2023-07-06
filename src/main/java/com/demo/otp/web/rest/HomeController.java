package com.demo.otp.web.rest;

import com.demo.otp.service.HomeService;
import org.springframework.web.bind.annotation.*;

import java.util.InvalidPropertiesFormatException;

@RestController
@RequestMapping("/otp")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @PostMapping("/send")
    public String sendOTP(@RequestParam("email") String email) throws InvalidPropertiesFormatException {
        return homeService.sendOtp(email);
    }

    @GetMapping("/verify/{tempId}")
    public String verifyOtp(@PathVariable("tempId") String tempId,
                            @RequestParam("otp") String otp
    ) throws InvalidPropertiesFormatException {
        return homeService.verifyOtp(tempId, otp);
    }
}
