package cn.itcast.ssm.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.itcast.mybatis.pojo.Items;
import cn.itcast.mybatis.pojo.QueryVo;

@Controller
public class HaHaController {
	//method={RequestMethod.GET}表示限制请求的方法必须为get
	//可以限制请求多个方法类型，method={RequestMethod.GET,RequestMethod.POST}即能get请求又能post请求
	@RequestMapping(method=RequestMethod.GET, value="/haha")
	public String Haha(Model model) {
		Items items2 = new Items();
		items2.setName("哈哈");
		items2.setPrice(5.0f);
		items2.setPrice(5.32f);
		model.addAttribute("items", items2);
		
		return "haha";
	}
	
	@RequestMapping("/haha2")
	public String queryItems2(String[] item_id) throws Exception {
		System.out.println(item_id);
		for (String string : item_id) {
			System.out.println(string);
		}
		return "haha";
	}
	
	@RequestMapping("/haha3")
	public String queryItems3(Model model, QueryVo queryVo) throws Exception {
		
		System.out.println(queryVo.getItemsList());
		List<Items> list = queryVo.getItemsList();
		for (Items items : list) {
			System.out.println(items.getId() +"--" + items.getName() +"=--"+items.getPrice());
		}
		
		model.addAttribute("list", list);
		return "haha2";
	}
	//map
	@RequestMapping("/haha4")
	public String queryItems4(Model model, QueryVo queryVo) throws Exception {
		
		System.out.println(queryVo.getItemsInfo());
		Map<String, Object> map = queryVo.getItemsInfo();
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.println(string);
		}
		model.addAttribute("maps", map);
		return "haha2";
	}
	
}
