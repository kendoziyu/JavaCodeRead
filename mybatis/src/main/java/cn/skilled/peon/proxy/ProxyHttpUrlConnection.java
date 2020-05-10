package cn.skilled.peon.proxy;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.net.URL;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/5/10 0010 <br>
 */
public class ProxyHttpUrlConnection extends java.net.HttpURLConnection {

    private HttpURLConnection connection;

    public ProxyHttpUrlConnection(HttpURLConnection connection, URL url) {
        super(url);
        this.connection = connection;
    }

    public void disconnect() {
        connection.disconnect();
    }

    public boolean usingProxy() {
        return false;
    }

    public void connect() throws IOException {
        long begin = System.currentTimeMillis();
        connection.connect();
        System.out.println("连接用时 ：" + (System.currentTimeMillis() - begin) + "毫秒");
    }


}
