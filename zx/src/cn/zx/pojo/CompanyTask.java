package cn.zx.pojo;

import java.util.Date;

public class CompanyTask {
    private Integer task_id;

    private Integer company_id;

    private String task_title;

    private Integer to_user;

    private Integer user_id;

    private Integer task_obj;

    private Date task_start_time;

    private Date task_end_time;

    private Date task_complete_time;

    private Integer task_progress;

    private Integer task_cd;

    private Integer task_important;

    private String task_content;

    private Integer task_status;

    private String task_del_reasion;

    private String task_reback_reasion;

    private Byte is_remark;

    private Byte is_forward;

    private Integer is_delay;

    private Integer is_cui;

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getTask_title() {
        return task_title;
    }

    public void setTask_title(String task_title) {
        this.task_title = task_title == null ? null : task_title.trim();
    }

    public Integer getTo_user() {
        return to_user;
    }

    public void setTo_user(Integer to_user) {
        this.to_user = to_user;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTask_obj() {
        return task_obj;
    }

    public void setTask_obj(Integer task_obj) {
        this.task_obj = task_obj;
    }

    public Date getTask_start_time() {
        return task_start_time;
    }

    public void setTask_start_time(Date task_start_time) {
        this.task_start_time = task_start_time;
    }

    public Date getTask_end_time() {
        return task_end_time;
    }

    public void setTask_end_time(Date task_end_time) {
        this.task_end_time = task_end_time;
    }

    public Date getTask_complete_time() {
        return task_complete_time;
    }

    public void setTask_complete_time(Date task_complete_time) {
        this.task_complete_time = task_complete_time;
    }

    public Integer getTask_progress() {
        return task_progress;
    }

    public void setTask_progress(Integer task_progress) {
        this.task_progress = task_progress;
    }

    public Integer getTask_cd() {
        return task_cd;
    }

    public void setTask_cd(Integer task_cd) {
        this.task_cd = task_cd;
    }

    public Integer getTask_important() {
        return task_important;
    }

    public void setTask_important(Integer task_important) {
        this.task_important = task_important;
    }

    public String getTask_content() {
        return task_content;
    }

    public void setTask_content(String task_content) {
        this.task_content = task_content == null ? null : task_content.trim();
    }

    public Integer getTask_status() {
        return task_status;
    }

    public void setTask_status(Integer task_status) {
        this.task_status = task_status;
    }

    public String getTask_del_reasion() {
        return task_del_reasion;
    }

    public void setTask_del_reasion(String task_del_reasion) {
        this.task_del_reasion = task_del_reasion == null ? null : task_del_reasion.trim();
    }

    public String getTask_reback_reasion() {
        return task_reback_reasion;
    }

    public void setTask_reback_reasion(String task_reback_reasion) {
        this.task_reback_reasion = task_reback_reasion == null ? null : task_reback_reasion.trim();
    }

    public Byte getIs_remark() {
        return is_remark;
    }

    public void setIs_remark(Byte is_remark) {
        this.is_remark = is_remark;
    }

    public Byte getIs_forward() {
        return is_forward;
    }

    public void setIs_forward(Byte is_forward) {
        this.is_forward = is_forward;
    }

    public Integer getIs_delay() {
        return is_delay;
    }

    public void setIs_delay(Integer is_delay) {
        this.is_delay = is_delay;
    }

    public Integer getIs_cui() {
        return is_cui;
    }

    public void setIs_cui(Integer is_cui) {
        this.is_cui = is_cui;
    }
}