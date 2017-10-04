package cn.zx.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.zx.dao.CompanyDepartMapper;
import cn.zx.pojo.CompanyDepart;
import cn.zx.pojo.CompanyDepartExample;
import cn.zx.pojo.TreeModel;
import cn.zx.service.CompanyDepartService;
import cn.zx.tool.TreeUtil;

@Service("companyDepartService")
public class CompanyDepartServiceImpl implements CompanyDepartService {
	@Autowired
	CompanyDepartMapper companyDepartMapper;
	
	//构造单位及部门树形结构
	private List<CompanyDepart> selectChildren(String id,Integer company_id){
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("company_id", company_id);
		para.put("pid", id);
		return companyDepartMapper.list(para);
		
	}
	
	@Override
	public TreeModel selectTree(String id,Integer company_id, boolean containsDept) {
		TreeModel tm = new TreeModel();
		//在此只保留部门或单位的id及name属性,可拓展
		
		String[] s = new String[] { "getDept_id", "getDept_name" };//存放你想获取的值
		List<CompanyDepart> li = this.selectChildren(id, company_id);
		this.tree(tm, li, s, containsDept, company_id);		
		return tm;
	}
	
	private void tree(TreeModel tm, List<CompanyDepart> li, String[] s,boolean containsDept,Integer company_id){
		if (!CollectionUtils.isEmpty(li)) {
			for (int i = 0; i < li.size(); i++) {
				TreeModel ntm = new TreeModel();
				CompanyDepart dept=li.get(i);
				
				TreeUtil.copyModel(ntm, dept, s);// 复制值到TreeModel  
				tm.getChildren().add(ntm);// 添加到孩子节点列表
				
				
				List<CompanyDepart> list = this.selectChildren(dept.getDept_id().toString(),company_id);
				tree(ntm, list, s, containsDept,company_id);// 递归，实现无限层级
			}
		}
	}

	

	@Override
	public List<CompanyDepart> selectDepartByCompanyId(CompanyDepartExample companyDepartExample) {
		return companyDepartMapper.selectByExample(companyDepartExample);
	}

	@Override
	public List<CompanyDepart> selectDeptName(Integer dept_id, Integer company_id) {
		// TODO Auto-generated method stub
		return companyDepartMapper.selectDeptName(dept_id, company_id);
	}

	@Override
	public int insertSelective(CompanyDepart record) {
		// TODO Auto-generated method stub
		return companyDepartMapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKeySelective(List<CompanyDepart> list) {
		// TODO Auto-generated method stub
		int row=0;
		for (int i = 0; i < list.size(); i++) {
			i=companyDepartMapper.updateByPrimaryKeySelective(list.get(i));
			row+=i;
		}
		return 0;
	}

	  
}
