package com.boliangshenghe.weibodata.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.boliangshenghe.weibodata.common.PageBean;
import com.boliangshenghe.weibodata.entity.WeiboLonlat;
import com.boliangshenghe.weibodata.pojo.JsonGaodeBean;
import com.boliangshenghe.weibodata.service.WeiboDataCoordinateService;
import com.boliangshenghe.weibodata.service.WeiboLonlatService;
import com.boliangshenghe.weibodata.util.CommonUtils;
import com.boliangshenghe.weibodata.util.HttpClientUtil;

/**
 * @author xuzj
 *
 */
@Controller
@RequestMapping("/lonlat")
public class WeiboLonlatController {
	
	@Autowired
	public WeiboDataCoordinateService weiboDataCoordinateService;
	@Autowired
	public WeiboLonlatService weiboLonlatService;
	
	@RequestMapping
	public String defaultIndex(){
		return "redirect:/lonlat/list";
	}
	
	/**
	 * 根据weiboLonlat。id获取地址，再调用高德地图获取经纬度
	 * 再将经纬度插入
	 * @param model
	 * @param id
	 * @return
	 * 
	 * http://restapi.amap.com/v3/geocode/geo?key=9380c464b9a4a9ecc686cd57ff994f0c&address=新兴街南一巷&city=
	 */
	@RequestMapping("getLatlon")
	public String getLatlon(Model model,Integer id,String city){
		
		WeiboLonlat weiboLonlat = weiboLonlatService.selectByPrimaryKey(id);
		if(weiboLonlat.getLatitude()==null || weiboLonlat.getLatitude().equals("")){
			try {
				Map<String,String> map = new HashMap<String,String>();
				map.put("key", CommonUtils.GAODEKEY);
				map.put("address",weiboLonlat.getCoordinate());
				map.put("city",city);
				String retu = HttpClientUtil.doGet("http://restapi.amap.com/v3/geocode/geo",map);
				
				JSONObject jsonObj = JSONObject.parseObject(retu);
				JsonGaodeBean gaodeBean = JSON.toJavaObject(jsonObj, JsonGaodeBean.class);
				String lonlat = gaodeBean.getGeocodes().get(0).getLocation();
				String lon = lonlat.substring(0, lonlat.indexOf(","));
				String lat = lonlat.substring(lonlat.indexOf(",")+1, lonlat.length());
				weiboLonlat.setLongitude(lon);
				weiboLonlat.setLatitude(lat);
				weiboLonlat.setOpertime(new Date());
				weiboLonlatService.updateByPrimaryKeySelective(weiboLonlat);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(weiboLonlat.getCoordinate()+" --------异常地址");
				//e.printStackTrace();
			}
		}
		return "redirect:/lonlat/list";
	}
	
	/**
	 * 根据weiboLonlat。id获取地址，再调用高德地图获取经纬度
	 * 再将经纬度插入
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping("getAllLatlon")
	public String getAllLatlon(Model model,String ids){
		
		String[] idmore = ids.split(",");
		for (String id : idmore) {
			WeiboLonlat weiboLonlat = weiboLonlatService.selectByPrimaryKey(Integer.valueOf(id));
			try {
				if(weiboLonlat.getLatitude()==null || weiboLonlat.getLatitude().equals("")){
					Map<String,String> map = new HashMap<String,String>();
					map.put("key", CommonUtils.GAODEKEY);
					map.put("address",weiboLonlat.getCoordinate());
					String retu = HttpClientUtil.doGet("http://restapi.amap.com/v3/geocode/geo",map);
					JSONObject jsonObj = JSONObject.parseObject(retu);
					JsonGaodeBean gaodeBean = JSON.toJavaObject(jsonObj, JsonGaodeBean.class);
					String lonlat = gaodeBean.getGeocodes().get(0).getLocation();
					String lon = lonlat.substring(0, lonlat.indexOf(","));
					String lat = lonlat.substring(lonlat.indexOf(",")+1, lonlat.length());
					weiboLonlat.setLongitude(lon);
					weiboLonlat.setLatitude(lat);
					weiboLonlat.setOpertime(new Date());
					weiboLonlatService.updateByPrimaryKeySelective(weiboLonlat);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(weiboLonlat.getCoordinate()+" --------异常地址");
			}
		}
		return "redirect:/lonlat/list";
	}
	
	/**
	 * 获取经纬度的列表
	 * @param weiboLonlat
	 * @param model
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("list")
	public String index(WeiboLonlat weiboLonlat,Model model,
			@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo){
		PageBean<WeiboLonlat> page =  weiboLonlatService.getWeiboLonlatByPage(weiboLonlat,pageNo,10);
//		System.out.println(page.getTotal());
		model.addAttribute("page", page);
		return "lonlat/list";
	}
	
	/**
	 * 添加一条记录到经纬度表
	 * @param model
	 * @param uid
	 * @param coordinate
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String index(Model model,String uid,String coordinate){
		WeiboLonlat weiboLonlat = new WeiboLonlat();
		weiboLonlat.setCoordinate(coordinate);
		weiboLonlat.setUid(uid);
		weiboLonlat.setCreatetime(new Date());
		/**
		 * 确保一个uid只有一条记录
		 */
		weiboLonlatService.deleteByUid(uid);
		
		int i = weiboLonlatService.insertSelective(weiboLonlat);
		if(i>0){
			return "success";
		}else{
			return "fali";
		}
	}
	
	/**
	 * 上传
	 * @param request
	 * @param response
	 * @param file
	 * @param model
	 * @return
	 */
	@RequestMapping("/uploadfile")
	public String uploadfile(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("file") CommonsMultipartFile file,Model model) {
		String fileName = file.getOriginalFilename();
//		System.out.println(fileName);
		
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			InputStream is = null;
			try {
				is = file.getInputStream();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HSSFWorkbook hssfWorkbook = null;
			try {
				hssfWorkbook = new HSSFWorkbook(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 获取每一个工作薄
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			if (hssfSheet == null) {
				model.addAttribute("message", "没有数据，请检查原始文档！");
				return "redirect:/lonlat/list"; 
			}
			
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					WeiboLonlat weiboLonlat = new WeiboLonlat();
					HSSFCell uid = hssfRow.getCell(0);
					weiboLonlat.setUid(getNoValue(uid));
					HSSFCell coordinate = hssfRow.getCell(1);
					if (getNoValue(coordinate).trim().equals("")) {
						continue;
					}
					weiboLonlat.setCoordinate(getNoValue(coordinate));
					Map<String,String> map = new HashMap<String,String>();
					map.put("key", CommonUtils.GAODEKEY);
					map.put("address",getNoValue(coordinate));
					String lon = "";
					String lat = "";
					try {
						String retu = HttpClientUtil.doGet("http://restapi.amap.com/v3/geocode/geo",map);
						JSONObject jsonObj = JSONObject.parseObject(retu);
						JsonGaodeBean gaodeBean = JSON.toJavaObject(jsonObj, JsonGaodeBean.class);
						String lonlat = gaodeBean.getGeocodes().get(0).getLocation();
						lon = lonlat.substring(0, lonlat.indexOf(","));
						lat = lonlat.substring(lonlat.indexOf(",")+1, lonlat.length());
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					
					weiboLonlat.setLongitude(lon);
					weiboLonlat.setLatitude(lat);
					weiboLonlat.setCreatetime(new Date());
					weiboLonlat.setOpertime(new Date());
					weiboLonlatService.insertSelective(weiboLonlat);
					/*HSSFCell bianji = hssfRow.getCell(2);
					salaryTwo.setBianji(getValue(bianji));*/
				}
			}
			
		
		model.addAttribute("message", "上传成功");
		return "redirect:/lonlat/list";
	}
	
	@RequestMapping("reladata")
	public String info(){
		return "weibo/reladata";
	}
	
	/**
	 * 没有加密
	 * @param hssfCell
	 * @return
	 */
	private String getNoValue(HSSFCell hssfCell){
		String returnString = "";
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			returnString =  String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			DecimalFormat df = new DecimalFormat("######0");
			returnString = df.format(hssfCell.getNumericCellValue());
		} else {
			returnString = String.valueOf(hssfCell.getStringCellValue());
		}
		return returnString.trim();
	}
}
