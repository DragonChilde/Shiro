package com.maven.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.ssm.mapper.CustomerMapper;
import com.maven.ssm.pojo.Customer;
import com.maven.ssm.pojo.QueryVo;
import com.maven.ssm.service.CustomerSerivce;
import com.maven.ssm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerSerivce {
	
	private Page<Customer> page = new Page<>();
	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Page<Customer> getCustomerListByQueryVo(QueryVo vo) {
		
		if(vo.getCustName() != null && !"".equals(vo.getCustName().trim()))
		{
			vo.setCustName(vo.getCustName().trim());
		}
		vo.setRows(10);
		vo.setStart((vo.getPage() -1) * vo.getRows());
		
		List<Customer> list = customerMapper.getCustomerListByQueryVo(vo);
			
		page.setPage(vo.getPage());
		page.setSize(10);
		page.setTotal(this.getCountCustomerByQueryVo(vo));
		page.setRows(list);
		
		return page;
	}

	@Override
	public int getCountCustomerByQueryVo(QueryVo vo) {
		return customerMapper.getCountCustomerByQueryVo(vo);
	}

	@Override
	public Customer getCustomerListByCustId(int custId) {
		return customerMapper.getCustomerListByCustId(custId);
	}

	@Override
	public void updateCustomerByCustId(Customer customer) {
		customerMapper.updateCustomerByCustId(customer);
		
	}

	@Override
	public void deleteCustomerByCustId(int id) {
		customerMapper.deleteCustomerByCustId(id);
		
	}

}
