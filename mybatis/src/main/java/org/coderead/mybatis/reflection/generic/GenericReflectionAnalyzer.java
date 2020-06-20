package org.coderead.mybatis.reflection.generic;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 描述: 泛型反射类测试 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/19 0019 <br>
 */
public class GenericReflectionAnalyzer {

    public static void main(String[] args) {
        // read class name from command line args or user input
        String name;
        if (args.length > 0)
            name = args[0];
        else
        {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter Class name (e.g. java.util.Collection) :");
            name = in.next();

            try {
                // print generic info for class and public methods
                Class<?> cl = Class.forName(name);
                PrintTypeHelper.printClass(cl);
                for (Method method : cl.getDeclaredMethods()) {
                    PrintTypeHelper.printMethod(method);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


}
