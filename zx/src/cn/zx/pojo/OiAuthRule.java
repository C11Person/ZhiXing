package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class OiAuthRule {
    private Integer r_id;

    private Integer pid;

    private String name;

    private String title;

    private String icon;

    private Integer type;

    private Integer status;

    private Integer islink;

    private Integer o;

    private String tips;
    
    private List<OiAuthRule> nodes = new ArrayList<OiAuthRule>();
    

    public List<OiAuthRule> getNodes() {
		return nodes;
	}

	public void setNodes(List<OiAuthRule> nodes) {
		this.nodes = nodes;
	}

	public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIslink() {
        return islink;
    }

    public void setIslink(Integer islink) {
        this.islink = islink;
    }

    public Integer getO() {
        return o;
    }

    public void setO(Integer o) {
        this.o = o;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }
}