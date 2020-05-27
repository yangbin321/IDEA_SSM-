package com.itheima.dao;

import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;

import java.util.List;

/**
 * @author Yangbin
 * @create 2020-03-08 22:16
 * @Description 客户Customer的dao接口
 */
public interface CustomerDao {

    /**
     * 总条数
     * @param vo
     * @return
     */
    public Integer customerCountByQueryVo(QueryVo vo);

    /**
     * 结果集
     * @param vo
     * @return
     */
    public List<Customer> selectCustomerListByQueryVo(QueryVo vo);

    /**
     * 通过id查询客户
     * @param id
     * @return
     */
    public Customer selectCustomerById(Integer id);

    /**
     * 通过ID修改客户
     * @param customer
     */
    public void updateCustomerById(Customer customer);

    /**
     * 通过ID删除客户
     * @param id
     */
    public void deleteCustomerById(Integer id);


}
