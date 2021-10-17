package com.sdtbu.gulimall.ware.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;

@Data
public class PurchaseDoneVo {

    @NotNull
    private Long id;

    private List<PurchaseItemDoneVo> items;


}
