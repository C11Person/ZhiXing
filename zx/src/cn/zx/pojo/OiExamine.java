package cn.zx.pojo;

public class OiExamine {
    private Integer ex_id;

    private String license_id;

    private String use_name;

    private Integer phone;

    private Byte status;

    public Integer getEx_id() {
        return ex_id;
    }

    public void setEx_id(Integer ex_id) {
        this.ex_id = ex_id;
    }

    public String getLicense_id() {
        return license_id;
    }

    public void setLicense_id(String license_id) {
        this.license_id = license_id == null ? null : license_id.trim();
    }

    public String getUse_name() {
        return use_name;
    }

    public void setUse_name(String use_name) {
        this.use_name = use_name == null ? null : use_name.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}