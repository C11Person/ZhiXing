package cn.zx.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;

import cn.zx.dao.OiAuthRuleMapper;
import cn.zx.pojo.OiAuthRule;
import cn.zx.pojo.OiAuthRuleExample;
import cn.zx.pojo.OiAuthRuleExample.Criteria;
import cn.zx.pojo.OiType;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:SpringConfig.xml"})

public class TreeTest2{
	
	@Autowired
	OiAuthRuleMapper mapper;
	@Test
	public void loadTree() throws Exception{
		System.out.println(JSONArray.toJSONString(recursiveTree(79)));
		}
	public OiAuthRule recursiveTree(int cid) {
		//根据cid获取节点对象(SELECT * FROM tb_tree t WHERE t.cid=?)
		
		
		OiAuthRule node = mapper.selectByPrimaryKey(cid);
		//查询cid下的所有子节点(SELECT * FROM tb_tree t WHERE t.pid=?)
		OiAuthRuleExample example=new OiAuthRuleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(cid);
		createCriteria.andIslinkEqualTo(1);
		
		
		List<OiAuthRule> childTreeNodes = mapper.selectByExample(example); 
		//遍历子节点
		for(OiAuthRule child : childTreeNodes){
			OiAuthRule n = recursiveTree(child.getR_id()); //递归
		node.getNodes().add(n);
		}
		 
		return node;
		}
		}
	

