package cn.zx.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;

import cn.zx.dao.OiAuthRuleMapper;
import cn.zx.dao.OiRoleMapper;
import cn.zx.pojo.OiAuthRule;
import cn.zx.pojo.OiAuthRuleExample;
import cn.zx.pojo.OiAuthRuleExample.Criteria;
import cn.zx.pojo.OiRole;
import cn.zx.pojo.OiType;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:SpringConfig.xml"})

public class TreeTest5{
	
	@Autowired
	OiRoleMapper rolemapper;
	@Autowired
	OiAuthRuleMapper mapper;
	@Test
	public void loadTree() throws Exception{
		OiRole role=createrole(1);
		List<Object> list=new ArrayList<Object>();
		
		OiAuthRule recursiveTree = recursiveTree(1);
		list.add(role);
		list.add(recursiveTree);
		System.out.println(JSONArray.toJSONString(list));
		//System.out.println(JSONArray.toJSONString(recursiveTree));
		}
	
	public OiRole createrole(int id){
OiRole role = rolemapper.selectByPrimaryKey(id);
		
		List<Integer>  roles=new ArrayList<>();
		String[] str_ids = role.getRules().split(",");
		//组装id集合
		for ( String string: str_ids) {
			roles.add(Integer.parseInt(string));
		}
		role.setRules(null);
		role.setRule(roles);
		return role;
	}
	
	public OiAuthRule recursiveTree(int cid) {
		//根据cid获取节点对象(SELECT * FROM tb_tree t WHERE t.cid=?)
		
		
		OiAuthRule node = mapper.selectByPrimaryKey(cid);
		//查询cid下的所有子节点(SELECT * FROM tb_tree t WHERE t.pid=?)
		OiAuthRuleExample example=new OiAuthRuleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(cid);
		
		
		List<OiAuthRule> childTreeNodes = mapper.selectByExample(example); 
		//遍历子节点
		for(OiAuthRule child : childTreeNodes){
			OiAuthRule n = recursiveTree(child.getR_id()); //递归
		node.getNodes().add(n);
		}
		 
		return node;
		}
		}
	

