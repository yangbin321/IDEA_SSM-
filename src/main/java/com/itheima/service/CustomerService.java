package com.itheima.service;

import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;
import com.itheima.utils.Page;

/**
 * @author Yangbin
 * @create 2020-03-08 23:10
 * @Description
 */
public interface CustomerService {

    /**
     * 通过四个条件 查询分页对象
     * @param vo
     * @return
     */
    public Page<Customer> selectPageByQueryVo(QueryVo vo);

    /**
     * 通过ID查询客户
     * @param id
     * @return
     */
    public Customer selectCustomerById(Integer id);

    /**
     * 修改客户通过ID
     * @param customer
     */
    public void updateCustomerById(Customer customer);

    /**
     * 通过ID 删除客户
     * @param id
     */
    public void deleteCustomerById(Integer id);


}
