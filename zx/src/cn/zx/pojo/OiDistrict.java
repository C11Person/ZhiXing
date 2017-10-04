package cn.zx.pojo;

import java.util.ArrayList;
import java.util.List;

public class OiDistrict {
    private Integer district_id;

    private Integer pid;

    private String district;

    private Integer level;

    private Integer status;
    
    private List<OiDistrict> nodes = new ArrayList<OiDistrict>();

    @Override
	public String toString() {
		return "OiDistrict [district_id=" + district_id + ", pid=" + pid + ", district=" + district + ", level=" + level
				+ ", status=" + status + ", nodes=" + nodes + "]";
	}

	public List<OiDistrict> getNodes() {
		return nodes;
	}

	public void setNodes(List<OiDistrict> nodes) {
		this.nodes = nodes;
	}

	public Integer getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(Integer district_id) {
        this.district_id = district_id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}