package com.hust.software.scenic.service;

import com.hust.software.scenic.common.CommonResult;

/**
 * @author: 小栗旬
 * @Date: 2019/10/26 12:37
 */
public interface MarkService {
    CommonResult mark(Integer userId, Integer scenicId);

    CommonResult outIsMarked(Integer userId, Integer scenicId);
}
