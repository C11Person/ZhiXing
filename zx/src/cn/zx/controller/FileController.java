package cn.zx.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/file")
public class FileController {
	
	@RequestMapping("/test.do")
	@ResponseBody
	public String test(String a,MultipartFile file,HttpServletRequest request) throws IllegalStateException, IOException{
		System.out.println(a);
		System.out.println(file.getName());
		System.out.println("comming!");
		String path = request.getSession().getServletContext().getRealPath("/images");
		System.out.println("path>>"+path);
		
		String fileName = file.getOriginalFilename();
		System.out.println("fileName>>"+fileName);
		
		File dir = new File(path, fileName);
		System.out.println("dir.exists()>>"+dir.exists());
		
		if(!dir.exists()){
			dir.mkdirs();
		}
		
		System.out.println("dir.exists()>>"+dir.exists());
		file.transferTo(dir);
		
		
		return "ok";
		
	}
	
	
	@RequestMapping("/upload.do")
    @ResponseBody
	public String insert(@RequestParam("file")MultipartFile attach,
			HttpServletRequest request,
			HttpServletResponse response){
		 String path = request.getSession().getServletContext().getRealPath("/statics/images") ;
		 String oldFileName = attach.getOriginalFilename();//原文件名		
		String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀    	 
		String fileName = System.currentTimeMillis()+RandomUtils.nextInt(1000000)+"_Personal.jpg";
		File targetFile = new File(path, fileName);
		
		JSONObject json = new JSONObject();
		if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
        //保存  
        try {  
        	attach.transferTo(targetFile);
        } catch (Exception e) {  
            e.printStackTrace();  
            request.setAttribute("uploadFileError", " * 上传失败！");
            return json.toJSONString();
        }  
        json.put("msg","success");
		 //companyBasicService.insertDemo(targetFile.getPath());
		 json.put("filePath",targetFile.getPath());
	     System.out.println("json="+json.toJSONString());
		 return json.toJSONString();
		
	}
}
