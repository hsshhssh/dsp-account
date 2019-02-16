package com.feilu.game.box.example.utils.common;

import com.alibaba.fastjson.JSONObject;
import com.feilu.game.box.example.enums.ResponseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by hssh on 2017/6/4.
 */
@ControllerAdvice
public class ExceptionUtils
{
    private static Logger logger = LoggerFactory.getLogger(ExceptionUtils.class);

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public void handlerInvalidArgs(HttpServletResponse resp, MethodArgumentNotValidException e) throws IOException {
        logger.warn("方法参数检验失败 msg:{}", e.getMessage());

        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        ResponseBean responseBean = new ResponseBean(ResponseEnum.ERROR_PARAM);
        writer.write(JSONObject.toJSONString(responseBean));
    }

}
