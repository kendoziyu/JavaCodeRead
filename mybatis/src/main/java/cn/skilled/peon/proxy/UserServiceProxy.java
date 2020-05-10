package cn.skilled.peon.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;

/**
 * 描述: 为UserService设置动态代理 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/5/10 0010 <br>
 */
public class UserServiceProxy implements InvocationHandler {


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用了方法" + method.getName());
        return null;
    }

    public static void main(String[] args) throws Exception {
        UserServiceProxy proxy = new UserServiceProxy();
        ClassLoader classLoader = new URLClassLoader(new URL[0]);
        UserService userService = (UserService)
                Proxy.newProxyInstance(classLoader, new Class[] { UserService.class }, proxy);
        userService.getNameById(1);
       createProxyClass();
    }

    private static void createProxyClass() throws Exception{
        byte[] classes = ProxyGenerator.generateProxyClass("Proxy$1", new Class[]{UserService.class});
        String outputPath = System.getProperty("user.dir")
                + "/mybatis/target/Proxy$1.class";
        Files.write(new File(outputPath).toPath(), classes);
    }
}
