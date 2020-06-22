package org.coderead.mybatis.ognl.beans;

import java.util.List;
import java.util.Map;

public class CollectionsObject {

    private List list;

    private Map map;

    private Object[] array;

    private String key;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Object[] getArray() {
        return array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
