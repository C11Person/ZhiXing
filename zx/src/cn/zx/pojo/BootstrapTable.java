package cn.zx.pojo;

public class BootstrapTable {
	private String order;
	private Integer offset;
	private String search;
	private String sort;
	private Integer limit;
	
	
	
	@Override
	public String toString() {
		return "BootstrapTable [order=" + order + ", offset=" + offset + ", search=" + search + ", sort=" + sort
				+ ", limit=" + limit + "]";
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
	
}
