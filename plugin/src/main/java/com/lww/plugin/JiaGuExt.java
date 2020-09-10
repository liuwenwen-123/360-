package com.lww.plugin;

public class JiaGuExt {
//     360 账号密码
    private String username;
    private String userpwd;

//    签领 路径
    private String  keyStorePath;
    //    签领 密码
    private String  keyStorePwd;
    //    签领 别名
    private String  keyStoreAlias;
    //     别名密码
    private String  keyStoreAliasPwd;
// 加固工具 路径
    private String  jiaguToolsPath;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public String getKeyStorePwd() {
        return keyStorePwd;
    }

    public void setKeyStorePwd(String keyStorePwd) {
        this.keyStorePwd = keyStorePwd;
    }

    public String getKeyStoreAlias() {
        return keyStoreAlias;
    }

    public void setKeyStoreAlias(String keyStoreAlias) {
        this.keyStoreAlias = keyStoreAlias;
    }

    public String getKeyStoreAliasPwd() {
        return keyStoreAliasPwd;
    }

    public void setKeyStoreAliasPwd(String keyStoreAliasPwd) {
        this.keyStoreAliasPwd = keyStoreAliasPwd;
    }

    public String getJiaguToolsPath() {
        return jiaguToolsPath;
    }

    public void setJiaguToolsPath(String jiaguToolsPath) {
        this.jiaguToolsPath = jiaguToolsPath;
    }
}
