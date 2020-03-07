package hust.software.garbage.controller;

import hust.software.garbage.common.CommonResult;
import hust.software.garbage.service.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 小栗旬
 * @Date: 2020/3/6 22:01
 */
@RestController("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("login")
    @ApiOperation("后台登陆")
    public CommonResult login(@RequestParam("name")@ApiParam("账号") String name,
                              @RequestParam("password")@ApiParam("密码") String password){
        return adminService.login(name,password);
    }
}
