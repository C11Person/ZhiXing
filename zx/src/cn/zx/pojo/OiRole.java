package cn.zx.pojo;

public class OiRole {
    private Integer o_r_id;

    private String o_r_userid;

    private String o_r_password;

    private String title;

    private Byte status;

    private String rules;

    public Integer getO_r_id() {
        return o_r_id;
    }

    public void setO_r_id(Integer o_r_id) {
        this.o_r_id = o_r_id;
    }

    public String getO_r_userid() {
        return o_r_userid;
    }

    public void setO_r_userid(String o_r_userid) {
        this.o_r_userid = o_r_userid == null ? null : o_r_userid.trim();
    }

    public String getO_r_password() {
        return o_r_password;
    }

    public void setO_r_password(String o_r_password) {
        this.o_r_password = o_r_password == null ? null : o_r_password.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules == null ? null : rules.trim();
    }
}