package hust.software.garbage.service.impl;

import hust.software.garbage.common.CommonResult;
import hust.software.garbage.dto.SingleGarbage;
import hust.software.garbage.mgb.mapper.GarbageMapper;
import hust.software.garbage.mgb.mapper.GarbageTypeMapper;
import hust.software.garbage.mgb.model.Garbage;
import hust.software.garbage.mgb.model.GarbageExample;
import hust.software.garbage.mgb.model.GarbageType;
import hust.software.garbage.service.GarbageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 小栗旬
 * @Date: 2020/1/2 9:42
 */
@Service
public class GarbageServiceImpl implements GarbageService {
    @Autowired
    private GarbageMapper garbageMapper;
    @Autowired
    private GarbageTypeMapper garbageTypeMapper;

    @Override
    public CommonResult listGarbagesByName(String name) {
        List<SingleGarbage> garbages = garbageMapper.listGarbageByName(name);
        if (garbages.isEmpty()) {
            return CommonResult.success("查找不到");
        }
        return CommonResult.success(garbages);
    }

    @Override
    public CommonResult listGarbagesByType(Integer typeId) {

        GarbageType garbageType = garbageTypeMapper.selectByPrimaryKey(typeId);
        if (garbageType == null) {
            return CommonResult.failed("错误的垃圾类别");
        }
        GarbageExample example = new GarbageExample();
        GarbageExample.Criteria criteria = example.createCriteria();
        criteria.andTypeIdEqualTo(typeId);

        List<Garbage> garbages = garbageMapper.selectByExample(example);
        return CommonResult.success(garbages);
    }

    @Override
    public CommonResult listGarbagesByTypeWithPage(Integer typeId,Integer page, Integer size) {
        Integer start = (page - 1) * size;
        GarbageType garbageType = garbageTypeMapper.selectByPrimaryKey(typeId);
        if (garbageType == null) {
            return CommonResult.failed("错误的垃圾类别");
        }
        return CommonResult.success(garbageMapper.listGarbagesByTypeWithPage(typeId,start, size));
    }

    @Override
    public CommonResult listRandomGarbages() {
        return CommonResult.success(garbageMapper.listRandomGarbage());
    }




}
