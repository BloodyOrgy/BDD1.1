package data;

import lombok.Value;

public class DataHelper {
    private DataHelper(){
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo ("vasya","qwerty123");
    }

    public static AuthInfo getOtherAuthInfo(AuthInfo original) {
        return new AuthInfo ("vasya","123qwerty");
    }


    public static VerificationCode getVerificationCodeFor(AuthInfo original) {
        return new VerificationCode("12345");
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    @Value
    public static class VerificationCode {
        String code;
    }
}
