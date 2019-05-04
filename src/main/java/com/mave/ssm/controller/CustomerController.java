package com.mave.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.maven.ssm.pojo.BaseDict;
import com.maven.ssm.pojo.Customer;
import com.maven.ssm.pojo.QueryVo;
import com.maven.ssm.service.BaseDictService;
import com.maven.ssm.service.CustomerSerivce;
import com.maven.ssm.service.impl.BaseDictServiceImpl;
import com.maven.ssm.utils.Page;

@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerSerivce customerService;
	
	private List<BaseDict> fromType = null;
	private List<BaseDict> industryType = null;
	private List<BaseDict> levelType = null;
	
	@Value("${RESOURCE.CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	
	@Value("${RESOURCE.CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTY_TYPE;
	
	@Value("${RESOURCE.CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LELVE_TYPE;
	
	@RequestMapping(value="/customer/list")
	public String list(QueryVo vo,Model model)
	{

		fromType = baseDictService.getBaseDictByTypeCode(CUSTOMER_FROM_TYPE);
		industryType = baseDictService.getBaseDictByTypeCode(CUSTOMER_INDUSTY_TYPE);
		levelType = baseDictService.getBaseDictByTypeCode(CUSTOMER_LELVE_TYPE);
		
		Page<Customer> customerList = customerService.getCustomerListByQueryVo(vo);
		model.addAttribute("page", customerList);
		
		
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType",levelType);
		
		
		return "customer";
	}
	
	@RequestMapping(value="/customer/edit")
	@ResponseBody
	public Customer edit(int id)
	{

		Customer customer = customerService.getCustomerListByCustId(id);
		return customer;
	}
	
	@RequestMapping(value="/customer/update")
	@ResponseBody
	public String update(Customer customer)
	{
		customerService.updateCustomerByCustId(customer);
		return "OK";
	}
	
	@RequestMapping(value="/customer/delete")
	@ResponseBody
	public String delete(int id)
	{
		customerService.deleteCustomerByCustId(id);
		return "OK";
	}
	
}
