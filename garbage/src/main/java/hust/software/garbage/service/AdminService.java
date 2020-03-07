package hust.software.garbage.service;

import hust.software.garbage.common.CommonResult;

/**
 * @author: 小栗旬
 * @Date: 2020/3/6 22:03
 */
public abstract class AdminService {
    public abstract CommonResult login(String name, String password);
}
