package cn.zx.pojo;

import java.util.Date;

public class CompanyPost {
    private Integer post_id;

    private Integer company_id;

    private String post_name;

    private String post_remark;

    private Integer o;

    private Integer isdelete;

    private Date create_time;

    private Date update_time;

    public Integer getPost_id() {
        return post_id;
    }

    public void setPost_id(Integer post_id) {
        this.post_id = post_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name == null ? null : post_name.trim();
    }

    public String getPost_remark() {
        return post_remark;
    }

    public void setPost_remark(String post_remark) {
        this.post_remark = post_remark == null ? null : post_remark.trim();
    }

    public Integer getO() {
        return o;
    }

    public void setO(Integer o) {
        this.o = o;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}