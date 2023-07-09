**OTP Verification in Java Spring Boot: Send and Verify OTPs**

Introduction:
It's a Java Spring Boot project that incorporates OTP (One-Time Password) verification to enhance security and user authentication. The project consists of two APIs: one for sending the OTP and storing it in a cache, and the other for verifying the OTP using a temporary ID. By implementing this OTP verification process, we ensure a reliable and secure user authentication mechanism.

Sending OTP and Storing in Cache:
The first API in our Spring Boot project is responsible for generating and sending the OTP. When a user initiates the OTP verification process, this API generates a unique OTP and stores it securely in a cache. This cache acts as a temporary storage mechanism to facilitate OTP verification later on. The API then generates and returns a temporary ID to the user.

Verifying OTP with Temporary ID:
The second API plays a crucial role in verifying the OTP entered by the user. The user needs to call this API along with the temporary ID and the OTP received through another channel (e.g., SMS or email). The API retrieves the stored OTP from the cache using the temporary ID and compares it with the OTP provided by the user. If they match, the verification process succeeds, indicating the user's authenticity.

-----
To Send Emails, We have to create a SMTM credentials from our Email, Here is the process:-
![image](https://github.com/BareetSingh/OtpDemoApp/assets/49482233/07e94323-f052-43d6-b972-e5fb1c5f5593)


![image](https://github.com/BareetSingh/OtpDemoApp/assets/49482233/b98f6108-3e99-49ae-bbf9-ecdb96785a3b)


