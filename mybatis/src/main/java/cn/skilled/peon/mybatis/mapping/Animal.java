package cn.skilled.peon.mybatis.mapping;

/**
 * 描述:  <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/6/10 0010 <br>
 */
public class Animal {

    private Animal parent;
    private String name;

    public Animal getParent() {
        return parent;
    }

    public void setParent(Animal parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
