package com.example.muhammadahsan.facebook;

public class login {

    public login(String a){
        loginName=a;
    }

    private String loginName="Muhammad Ahsan";
    private String password;

    public void setLoginName(String ln){
        loginName=ln;
    }
    public String getLoginName(){
        return loginName;
    }


    public void setPassword(String ln){
        password=ln;
    }
    public String getPassword(){
        return password;
    }

}
