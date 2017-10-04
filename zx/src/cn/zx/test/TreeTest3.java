package cn.zx.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONArray;

import cn.zx.dao.OiTypeMapper;


import cn.zx.pojo.OiType;
import cn.zx.pojo.OiTypeExample;
import cn.zx.pojo.OiTypeExample.Criteria;
import cn.zx.service.OiDistrictService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:SpringConfig.xml"})

public class TreeTest3{
	
	@Autowired
	OiTypeMapper mapper;
	@Test
	public void loadTree() throws Exception{
		System.out.println(JSONArray.toJSONString(recursiveTree(1)));
		}
	public OiType recursiveTree(int cid) {
		//根据cid获取节点对象(SELECT * FROM tb_tree t WHERE t.cid=?)
		
		
		OiType node = mapper.selectByPrimaryKey(cid);
		//查询cid下的所有子节点(SELECT * FROM tb_tree t WHERE t.pid=?)
		OiTypeExample example=new OiTypeExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andPidEqualTo(cid);
		
		
		List<OiType> childTreeNodes = mapper.selectByExample(example); 
		//遍历子节点
		for(OiType child : childTreeNodes){
			OiType n = recursiveTree(child.getType_id()); //递归
		node.getNodes().add(n);
		}
		 
		return node;
		}
		}
	

