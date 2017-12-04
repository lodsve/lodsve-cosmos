package com.alibaba.common;

/**
 * fast dfs配置.
 *
 * @author sunhao(sunhao.java@gmail.com)
 * @version 1.0 2017-12-4-0004 11:09
 */
public class FastDfsConfig {
    private int connectTimeout = 5;
    private int networkTimeout = 30;
    private String charset;
    private int trackerHttpPort = 80;
    private boolean antiStealToken = false;
    private String secretKey;
    private String server;

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getNetworkTimeout() {
        return networkTimeout;
    }

    public void setNetworkTimeout(int networkTimeout) {
        this.networkTimeout = networkTimeout;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getTrackerHttpPort() {
        return trackerHttpPort;
    }

    public void setTrackerHttpPort(int trackerHttpPort) {
        this.trackerHttpPort = trackerHttpPort;
    }

    public boolean isAntiStealToken() {
        return antiStealToken;
    }

    public void setAntiStealToken(boolean antiStealToken) {
        this.antiStealToken = antiStealToken;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}
