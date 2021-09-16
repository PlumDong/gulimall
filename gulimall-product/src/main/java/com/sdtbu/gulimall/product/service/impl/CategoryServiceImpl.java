package com.sdtbu.gulimall.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdtbu.common.utils.PageUtils;
import com.sdtbu.common.utils.Query;

import com.sdtbu.gulimall.product.dao.CategoryDao;
import com.sdtbu.gulimall.product.entity.CategoryEntity;
import com.sdtbu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    /**
     * 1.查出所有分类
     * 2. 组装成父子树形结构
     */
    @Override
    public List<CategoryEntity> listWithTre() {
        //1.查出所有分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        //2. 组装成父子树形结构
        List<CategoryEntity> collect = entities.stream().filter((categoryEntity ->
            categoryEntity.getParentCid() == 0
        )).map(menu ->{
            menu.setChildren(getChildren(menu,entities));
            return menu;
        }).sorted((menu1, menu2) -> {
            return menu1.getSort() - menu2.getSort();
        }).collect(Collectors.toList());

        return collect;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO: 检查当前删除的菜单是否被被的地方引用
        baseMapper.deleteBatchIds(asList);
    }

    /**
     * 递归查找所有菜单的子菜单
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all){
        List<CategoryEntity> collect = all.stream().filter(categoryEntity ->{
                return categoryEntity.getParentCid() == root.getCatId();
        }).map(categoryEntity -> {
            categoryEntity.setChildren(getChildren(categoryEntity, all));
            return categoryEntity;
        }).sorted((menu1, menu2) -> {
            return (menu1.getSort()== null?0:menu1.getSort()) - (menu2.getSort()== null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return collect;
    }

}