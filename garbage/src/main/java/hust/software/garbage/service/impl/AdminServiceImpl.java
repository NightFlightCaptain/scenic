package hust.software.garbage.service.impl;

import hust.software.garbage.common.CommonResult;
import hust.software.garbage.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @author: 小栗旬
 * @Date: 2020/3/6 22:03
 */
@Service
public class AdminServiceImpl extends AdminService{

    @Override
    public CommonResult login(String name,String password){
        if ("admin".equals(name) && "12345".equals(password)) {
            return CommonResult.success("登陆成功");
        }else {
            return CommonResult.success("登陆失败");
        }
    }
}
