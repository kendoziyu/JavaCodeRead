package org.coderead.mybatis.beans;

import java.io.Serializable;
import java.util.function.UnaryOperator;

/**
 * @author tommy
 * @title: Comment
 * @projectName coderead-mybatis
 * @description: 评论实体
 * @date 2020/5/2910:21 PM
 */
public class Comment implements Serializable {

    private String id;
    private Integer blogId;
    private String body;
    private User user;
    private Blog blog;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
