package com.example.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dao.CollectionDao;
import com.entity.Collection;
import com.entity.User;


/**
 * 控制器层，返回json格式数据
 * @author Ruan
 *
 */
@RestController
@RequestMapping("collection")
public class Controller {
	
	@Autowired
	private CollectionDao dao;
	@Value("${url}")
	private String url;
	@Value("${uid}")
	private String uid;
	//start是开始查询的位置，end是查询的条数
	private static int start=0;
	private static int end=100;
	
	@RequestMapping("hello")
	public String hello(){
		User user=new User();
		user.setEmail("11627@qq.com");
		user.setGender(1);
		user.setPhone("777777");
		user.setUsername("普通用户");
		dao.addnew(user);
		System.err.println("导出成功");
		
		Collection co=new Collection();
		//co.set质地类别2("玉");
		
		if(co.get主键()!=null){
			dao.addnew1(co);
		}
		Integer c=dao.count();
		System.out.println("表中的数据有"+c+"条");
		return "hello";
	}
	
	
	@Scheduled(cron="*/5 * * * * ?")
	/**
	 * 根据提供的接口定时获取数据
	 * 每隔5秒就把查出的数据插入到数据库中
	 */
	public void add() throws ClientProtocolException, IOException {
		/*System.err.println("定时输出了吗");
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String urlNameString="http://192.168.66.230:8080/zsbwg/"
				+ "query-info!getMuscolls.json?token=c0e4a60ac0ef7f5ef2838b906cd86a0b"
				+ "&intervalNum=(START,END)&ipConfig=0.0.0.0";
		
		//第一次查询的是0-100条的数据
		String start1=start+"";
		String end1=end+"";
		//字符串的替换
		urlNameString=urlNameString.replace("START",start1);
		urlNameString=urlNameString.replace("END",end1);
		
		HttpGet httpget = new HttpGet(urlNameString);
		CloseableHttpResponse response = httpclient.execute(httpget);
		String result= EntityUtils.toString(response.getEntity(),"utf-8");
		
		System.err.println(result);
		//插入操作前数据库中的记录条数
		int beforeInsert=dao.count();
		JSONArray arr = JSONArray.parseArray(result);
         for(int i=0;i<arr.size();i++) {
      	   JSONObject oob=(JSONObject) arr.get(i);
      	   String data=oob.toString();
      	   System.out.println("数组对象"+i+":"+data);
      	 //把获取的字符串对象封装到类里面
           Collection coll = JSON.parseObject(data, Collection.class);
           if(coll!=null){
           dao.addnew1(coll);
           }
           
         }
         //插入完成后，数据库中记录的条数
         int afterInsert=dao.count();
         //受影响的条数
         int row=afterInsert-beforeInsert;
         start+=end;
         end=row;//查询的条数
        */ 
	}
	
	
	/**
	 * 获取藏品信息
	 * 参数直接写死
	 */
	@RequestMapping("list")
	public void list() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String urlNameString="http://192.168.66.230:8080/zsbwg/"
				+ "query-info!getMuscolls.json?token=c0e4a60ac0ef7f5ef2838b906cd86a0b"
				+ "&intervalNum=2&ipConfig=0.0.0.0";
		HttpGet httpget = new HttpGet(urlNameString);
		CloseableHttpResponse response = httpclient.execute(httpget);
		String result= EntityUtils.toString(response.getEntity(),"utf-8");
		
		/*
		 * 首先看上面的能否顺利的接受json数据并解析。
		 * 先查2条数据，若成功，则接着用下列的方式进行改进
		 * 那就直接不用requestmapping了,
		 * 
		 * 写个定时任务，每5秒获取100条数据
		 * 动态的获取数据的条数，每次获取100条，然后插入到数据库中
		 * 
		 * 存在的问题：你每次查100条，若最后的数据是201条，
		 * 你10秒后查出了200条并顺利的插入了数据库中
		 * 第15秒时你选择的是200-300
		 * 但是你只是插入了一条，
		 * 如果那边更新了数据库，有202条了
		 * 
		 * 但是在20秒的时候，你插入的数据是300-400的，所以也就是来拿数据都查不出来
		 * 所以我感觉要从数据库返回影响的行数来作为end,end+row
		 * 
		 * 把两个变量都设为静态的
		 * （0,100）
		 * （start,end）
		 * 
		 * 插入数据库后，返回受影响的行数
		 * start=end;
		 * end+=count-row;
		 * 
		 * String start1=start+"";
		 * String end1=end+"";
		 * String urlNameString="http://192.168.66.230:8080/zsbwg/"
				+ "query-info!getMuscolls.json?token=c0e4a60ac0ef7f5ef2838b906cd86a0b"
				+ "&intervalNum=(START,END)&ipConfig=0.0.0.0";
		 *urlNameString=urlNameString.replace("START",start1);
		 *urlNameString=urlNameString.replace("END",end1);
		 *发送请求，获取json数据，进行解析
		 *在解析的for循环里面添加数据到数据库中
		 *
		 * System.out.println(end1);
		 * 最后输出end的值
		 * 测试时输出了两个5秒就停止服务，然后把end的值和数据库中的id相比较
		 * 
		 * 验证机制：写个数据库的查询语句，传入id的值，查出返回的collection对象，然后toString
		 * 
		 */
		
		//解析json字符串,先转成对象数组
		
		/* JSONArray arr = JSONArray.parseArray(result);
         for(int i=0;i<arr.size();i++) {
      	    JSONObject oob=(JSONObject) arr.get(i);
      	   System.out.println("数组对象"+oob.toString());
      	   难道把对象先转为单个对象的字符串String str=oob.toString()
      	   然后直接把对象封装到类里面去
      	   User user = JSON.parseObject(data, User.class);
      	   最后调用dao.addnew(user),添加数据到数据库中
         }
         System.err.println("成功将数据导进数据库");*/
	}
	
	@RequestMapping("show")
	public String show() throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String urlNameString=url+"?uid="+uid+"";
	    //String uid1=uid+"";
		//urlNameString=urlNameString.replace("UID",uid1);
		HttpGet httpget = new HttpGet(urlNameString);
		
		CloseableHttpResponse response = httpclient.execute(httpget);
		String result= EntityUtils.toString(response.getEntity(),"utf-8");
		System.err.println(result);
		
		//解析json字符串
        //将Json字符串转为java对象
		JSONObject obj = JSONObject.parseObject(result);
		 //获取Object中的state
        System.err.println("state:" + obj.getString("state"));
        //获取json字符串中的对象数据
        String data=obj.getString("data");
        System.err.println(data);
        //把获取的字符串对象封装到类里面
        User user = JSON.parseObject(data, User.class);
        
        dao.addnew(user);
        
        System.err.println(user.getUsername()+" "+user.getEmail()+" "+user.getGender()
        +" "+user.getPhone());
       
        
        
        //若是标准的json类格式，则直接转换成对象
        //Collection collection = JSON.parseObject(result, Collection.class);
        //result是json数组字符串，先转成Java对象，再遍历
        //JSONObject obj = JSONObject.fromObject(result);
        
        String str="["+data+","+data+"]"; 
        JSONArray arr = JSONArray.parseArray(str);
           for(int i=0;i<arr.size();i++) {
        	   JSONObject oob=(JSONObject) arr.get(i);
        	   System.out.println("数组对象"+i+":"+oob.toString());
           }
        
		return result.toString();
	}
	
	//记得在方法上添加参数，token和number
	
	@RequestMapping("UserInfo")
    public String getWeChatUserInfo(String uid){
        String urlNameString ="http://localhost:8080/users/get_by_uid?uid=UID"; 
        //"https://api.weixin.qq.com/sns/userinfo?access_token=TOKEN&openid=OPENID";
        //urlNameString=urlNameString.replace("TOKEN", token);
        urlNameString=urlNameString.replace("UID",uid);
        String result="";
          try {
                // 根据地址获取请求
                HttpGet request = new HttpGet(urlNameString);//这里发送get请求
                // 获取当前客户端对象
                HttpClient httpClient = new DefaultHttpClient();
                // 通过请求对象获取响应对象
                HttpResponse response = httpClient.execute(request);
                 System.err.println(response.getEntity().toString());
                // 判断网络连接状态码是否正常(0--200都数正常)
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result= EntityUtils.toString(response.getEntity(),"utf-8");
                    System.out.println(result);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return result;
        //....result是用户信息,站内业务以及具体的json转换这里也不写了...
    }
	

}


