package hust.software.garbage.service;

import hust.software.garbage.common.CommonResult;

/**
 * @author: 小栗旬
 * @Date: 2020/1/2 9:42
 */
public interface GarbageService {
    CommonResult listGarbagesByName(String name);

    CommonResult listGarbagesByType(Integer typeId);

    CommonResult listGarbagesByTypeWithPage(Integer typeId,Integer page, Integer size);

    CommonResult listRandomGarbages();

    CommonResult addGarbage(String name, Integer typeId);

    CommonResult deleteGarbage(Integer id);

    CommonResult modifyGarbage(Integer id, String name, Integer typeId);
}
