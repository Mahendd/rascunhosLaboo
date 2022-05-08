package models;

public class AuthToken {
    public AuthToken(){

    }
    private String Access_token;
    private String token_type;
    private String expires_in;
    private String refresh_token;

    public String getAccess_token() {
        return Access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }
}
