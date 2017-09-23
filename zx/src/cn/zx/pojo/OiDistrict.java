package cn.zx.pojo;

public class OiDistrict {
    private Short district_id;

    private Short pid;

    private String district;

    private Boolean level;

    public Short getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Short district_id) {
        this.district_id = district_id;
    }

    public Short getPid() {
        return pid;
    }

    public void setPid(Short pid) {
        this.pid = pid;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public Boolean getLevel() {
        return level;
    }

    public void setLevel(Boolean level) {
        this.level = level;
    }
}