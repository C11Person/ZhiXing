package cn.zx.pojo;

import java.util.Date;

public class CompanyPostLevel {
    private Short post_le_id;

    private Short post_id;

    private Integer company_id;

    private Integer level;

    private String level_name;

    private Integer o;

    private Boolean status;

    private String remark;

    private Boolean isdelete;

    private Date create_time;

    private Date update_time;

    public Short getPost_le_id() {
        return post_le_id;
    }

    public void setPost_le_id(Short post_le_id) {
        this.post_le_id = post_le_id;
    }

    public Short getPost_id() {
        return post_id;
    }

    public void setPost_id(Short post_id) {
        this.post_id = post_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name == null ? null : level_name.trim();
    }

    public Integer getO() {
        return o;
    }

    public void setO(Integer o) {
        this.o = o;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
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