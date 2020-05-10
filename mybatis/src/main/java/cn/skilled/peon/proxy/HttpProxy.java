package cn.skilled.peon.proxy;

import sun.net.www.protocol.http.Handler;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.net.*;

/**
 * 描述: Http代理 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/5/10 0010 <br>
 */
public class HttpProxy {

    public static void init() {
        // 我需要一个工厂对象，所以我这边自定义一个
        URL.setURLStreamHandlerFactory(new ProxyHttpUrlConnectionFactory());
    }

    static class ProxyHttpUrlConnectionFactory implements URLStreamHandlerFactory {

        public URLStreamHandler createURLStreamHandler(String protocol) {
            System.out.println("调用了createURLStreamHandler");
            if ("http".equalsIgnoreCase(protocol)) {
                return new AgentHttpHandler();
            } else if ("https".equalsIgnoreCase(protocol)) {
                return new AgentHttpsHandler();
            }
            return null;
        }

        private class AgentHttpsHandler extends sun.net.www.protocol.https.Handler {

            protected URLConnection openConnection(URL u) throws IOException {
                return this.openConnection(u, null);
            }

            @Override
            protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
                HttpURLConnection connection = (HttpURLConnection) super.openConnection(url, proxy);
                return new ProxyHttpUrlConnection(connection, url);
            }
        }

        private class AgentHttpHandler extends sun.net.www.protocol.http.Handler {

            protected URLConnection openConnection(URL u) throws IOException {
                return this.openConnection(u, null);
            }

            @Override
            protected URLConnection openConnection(URL url, Proxy proxy) throws IOException {
                HttpURLConnection connection = (HttpURLConnection) super.openConnection(url, proxy);
                return new ProxyHttpUrlConnection(connection, url);
            }
        }
    }
}
