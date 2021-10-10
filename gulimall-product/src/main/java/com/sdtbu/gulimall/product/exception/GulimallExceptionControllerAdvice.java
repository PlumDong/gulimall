package com.sdtbu.gulimall.product.exception;


import com.sdtbu.common.exception.BizCodeEnum;
import com.sdtbu.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * 集中处理所有异常
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.sdtbu.gulimall.product")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handlerVaildException(MethodArgumentNotValidException e){
        log.error("数据校验异常{}，异常类型{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> map = new HashMap<>();
        bindingResult.getFieldErrors().forEach((item)->{
                map.put(item.getField(),item.getDefaultMessage());
        });
        return R.error(BizCodeEnum.VAILD_EXCEPTION.getCode(),BizCodeEnum.VAILD_EXCEPTION.getMessage(),map);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handlerException(Throwable e){
        log.error("数据校验异常{}，异常类型{}",e.getMessage(),e.getClass());

        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode() ,BizCodeEnum.UNKNOW_EXCEPTION.getMessage());
    }


}
