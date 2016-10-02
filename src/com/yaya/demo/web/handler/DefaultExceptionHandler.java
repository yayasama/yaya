package com.yaya.demo.web.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 默认异常处理
 *
 * @author ChW 2016-04-25 11:42:41
 */
@ControllerAdvice
public class DefaultExceptionHandler {


    @ExceptionHandler({IllegalStateException.class})
    public void IllegalStateExceptionHandler(){

    }


}
