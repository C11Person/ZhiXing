package cn.zx.pojo;

public class CompanyRole {
    private Integer user_id;

    private String c_r_userid;

    private String c_r_password;

    private String title;

    private Integer status;

    private String rules;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getC_r_userid() {
        return c_r_userid;
    }

    public void setC_r_userid(String c_r_userid) {
        this.c_r_userid = c_r_userid == null ? null : c_r_userid.trim();
    }

    public String getC_r_password() {
        return c_r_password;
    }

    public void setC_r_password(String c_r_password) {
        this.c_r_password = c_r_password == null ? null : c_r_password.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
    }
}