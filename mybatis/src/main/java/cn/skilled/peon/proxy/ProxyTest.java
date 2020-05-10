package cn.skilled.peon.proxy;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/5/10 0010 <br>
 */
public class ProxyTest {

    @Before
    public void init() {
        HttpProxy.init();
    }

    @Test
    public void testReqUrl() throws Exception {
        URL url = new URL("http://www.baidu.com");
        URLConnection con = url.openConnection();
        InputStream is = con.getInputStream();

    }
}
