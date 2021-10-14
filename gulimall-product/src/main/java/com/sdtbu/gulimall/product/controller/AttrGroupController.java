package com.sdtbu.gulimall.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.sdtbu.gulimall.product.entity.AttrEntity;
import com.sdtbu.gulimall.product.service.AttrAttrgroupRelationService;
import com.sdtbu.gulimall.product.service.AttrService;
import com.sdtbu.gulimall.product.service.CategoryService;
import com.sdtbu.gulimall.product.vo.AttrGroupRelationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sdtbu.gulimall.product.entity.AttrGroupEntity;
import com.sdtbu.gulimall.product.service.AttrGroupService;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.common.utils.R;



/**
 * 属性分组
 *
 * @author mazhendong
 * @email 1695165447@qq.com
 * @date 2020-12-09 10:21:06
 */
@RestController
@RequestMapping("product/attrgroup")
public class AttrGroupController {
    @Autowired
    private AttrGroupService attrGroupService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AttrService attrService;

    @Autowired
    private AttrAttrgroupRelationService relationService;


    /**
     * 查询分组关联的所有属性
     * @param attrgroupId   分组id
     * @return
     */
    //attrgroup/1/attr/relation
    @GetMapping("/{attrgroupId}/attr/relation")
    public R attrRelation(@PathVariable("attrgroupId") Long attrgroupId){
        List<AttrEntity> attrEntities = attrService.getRelationAttr(attrgroupId);
        return R.ok().put("data",attrEntities);
    }
    /**
     * 查询分组没有关联的所有属性
     * @param attrgroupId   分组id
     * @return
     */
    //attrgroup/1/attr/relation
    @GetMapping("/{attrgroupId}/noattr/relation")
    public R attrNoRelation(@PathVariable("attrgroupId") Long attrgroupId,
                            @RequestParam Map<String, Object> params){
        PageUtils page = attrService.getNoRelationAttr(params,attrgroupId);

        return R.ok().put("page",page);
    }


    @PostMapping("/attr/relation/delete")
    public R deleteRalation(@RequestBody AttrGroupRelationVo[] vos){

        attrService.deleteRelation(vos);

        return R.ok();
    }

    /**
     * 新增关联关系
     * @param vos
     * @return
     */
    @PostMapping("/attr/relation")
    public R addRalation(@RequestBody List<AttrGroupRelationVo> vos){
        relationService.saveBatch(vos);
        return R.ok();
    }


    /**
     * 列表
     */
    @RequestMapping("/list/{catelogId}")
    //@RequiresPermissions("product:attrgroup:list")
    public R list(@RequestParam Map<String, Object> params, @PathVariable("catelogId") Long catelogId){
        //PageUtils page = attrGroupService.queryPage(params);

        PageUtils page = attrGroupService.queryPage(params, catelogId);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrGroupId}")
    //@RequiresPermissions("product:attrgroup:info")
    public R info(@PathVariable("attrGroupId") Long attrGroupId){
		AttrGroupEntity attrGroup = attrGroupService.getById(attrGroupId);
        Long[] catelogPath = categoryService.findCatelogPath(attrGroup.getCatelogId());

        attrGroup.setCatelogPath(catelogPath);
        return R.ok().put("attrGroup", attrGroup);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequiresPermissions("product:attrgroup:save")
    public R save(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.save(attrGroup);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("product:attrgroup:update")
    public R update(@RequestBody AttrGroupEntity attrGroup){
		attrGroupService.updateById(attrGroup);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("product:attrgroup:delete")
    public R delete(@RequestBody Long[] attrGroupIds){
		attrGroupService.removeByIds(Arrays.asList(attrGroupIds));

        return R.ok();
    }

}
