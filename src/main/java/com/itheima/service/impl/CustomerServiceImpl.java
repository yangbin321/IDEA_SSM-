package com.itheima.service.impl;

import com.itheima.dao.CustomerDao;
import com.itheima.domain.Customer;
import com.itheima.domain.QueryVo;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yangbin
 * @create 2020-03-08 23:10
 * @Description   客户管理
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 通过四个条件 查询分页对象
     * @param vo
     * @return
     */
    @Override
    public Page<Customer> selectPageByQueryVo(QueryVo vo) {

        Page<Customer> page = new Page<Customer>();
        //设置每页数的大小
        page.setSize(5);
        //设置系统的页数的大小
        vo.setSize(5);
        if (vo != null){
            //判断当前页
            if (null != vo.getPage()){
                page.setPage(vo.getPage());
                vo.setStartRow((vo.getPage() - 1)*vo.getSize());
            }
            if (null != vo.getCustName() &&!"".equals(vo.getCustName().trim())){
                vo.setCustName(vo.getCustName().trim());
            }
            if (null != vo.getCustSource() &&!"".equals(vo.getCustSource().trim())){
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (null != vo.getCustIndustry() &&!"".equals(vo.getCustIndustry().trim())){
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (null != vo.getCustLevel() &&!"".equals(vo.getCustLevel().trim())){
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //总条数
            page.setTotal(customerDao.customerCountByQueryVo(vo));
            page.setRows(customerDao.selectCustomerListByQueryVo(vo));
        }
        return page;
    }

    /**
     * 通过ID查询客户
     * @param id
     * @return
     */
    @Override
    public Customer selectCustomerById(Integer id) {
        return customerDao.selectCustomerById(id);
    }

    /**
     * 修改客户通过ID
     * @param customer
     */
    @Override
    public void updateCustomerById(Customer customer) {
        customerDao.updateCustomerById(customer);
    }

    /**
     * 通过ID 删除客户
     * @param id
     */
    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }
}
