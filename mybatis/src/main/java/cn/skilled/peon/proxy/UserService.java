package cn.skilled.peon.proxy;

/**
 * 描述: 模拟一个用户服务 <br>
 *
 * @author: skilled-peon <br>
 * @date: 2020/5/10 0010 <br>
 */
public interface UserService {

    String getNameById(int id);

    void editName(int id, String newName);
}
