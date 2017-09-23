package cn.zx.pojo;

import java.util.Date;

public class CompanyPropaganda {
    private Integer p_id;

    private String p_title;

    private String pic_URL;

    private Date create_time;

    private Date end_time;

    private Integer status;

    private Integer o;

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title == null ? null : p_title.trim();
    }

    public String getPic_URL() {
        return pic_URL;
    }

    public void setPic_URL(String pic_URL) {
        this.pic_URL = pic_URL == null ? null : pic_URL.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getO() {
        return o;
    }

    public void setO(Integer o) {
        this.o = o;
    }
}