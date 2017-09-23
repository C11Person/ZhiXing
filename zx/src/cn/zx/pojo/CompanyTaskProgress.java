package cn.zx.pojo;

import java.util.Date;

public class CompanyTaskProgress {
    private Integer pro_id;

    private Integer task_id;

    private Integer task_progress;

    private String task_text;

    private String task_staffer;

    private Date update_time;

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public Integer getTask_id() {
        return task_id;
    }

    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }

    public Integer getTask_progress() {
        return task_progress;
    }

    public void setTask_progress(Integer task_progress) {
        this.task_progress = task_progress;
    }

    public String getTask_text() {
        return task_text;
    }

    public void setTask_text(String task_text) {
        this.task_text = task_text == null ? null : task_text.trim();
    }

    public String getTask_staffer() {
        return task_staffer;
    }

    public void setTask_staffer(String task_staffer) {
        this.task_staffer = task_staffer == null ? null : task_staffer.trim();
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}