package org.coderead.mybatis.reflection.enclosingclass;

public class TopLevelClass {

    private final int id;

    public TopLevelClass(int id) {
        this.id = id;
    }

    /**
     * 匿名内部类
     * @return
     */
    public Object buildAnonymousClass() {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
                System.out.println("EnclosingClass: " + this.getClass().getEnclosingClass());
                System.out.println("DeclaringClass: " + this.getClass().getDeclaringClass());
            }
        };
        return task;
    }

    /**
     * 本地类(在方法内声明的有名字的类)
     * @return
     */
    public Object buildLocalClass() {

        class LocalClass {
            final int number;
            LocalClass(int number) {
                this.number = number;
            }
        }

        LocalClass obj = new LocalClass(this.id + 100);
        return obj;
    }

    /**
     * 嵌套类(静态成员类)
     */
    public static class NestedClass {
        public static final String TAG = "Hello Word";
    }

    /**
     * 内部类(非静态成员类)
     */
    public class InnerClass {

        public int getId() {
            return id;
        }
    }
}
