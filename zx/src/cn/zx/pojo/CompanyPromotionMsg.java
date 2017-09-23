package cn.zx.pojo;

import java.util.Date;

public class CompanyPromotionMsg {
    private Integer promotion_msg_id;

    private Integer promotion_id;

    private Integer company_id;

    private Integer user_id;

    private Integer obj_user;

    private String title;

    private Integer is_vote;

    private Date create_time;

    private Date end_time;

    private Date update_time;

    private Integer status;

    public Integer getPromotion_msg_id() {
        return promotion_msg_id;
    }

    public void setPromotion_msg_id(Integer promotion_msg_id) {
        this.promotion_msg_id = promotion_msg_id;
    }

    public Integer getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Integer promotion_id) {
        this.promotion_id = promotion_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getObj_user() {
        return obj_user;
    }

    public void setObj_user(Integer obj_user) {
        this.obj_user = obj_user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getIs_vote() {
        return is_vote;
    }

    public void setIs_vote(Integer is_vote) {
        this.is_vote = is_vote;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}