package com.myteam.mall.mvc.config;

import com.google.gson.Gson;
import com.myteam.mall.constant.MallConstant;
import com.myteam.mall.exception.*;
import com.myteam.mall.util.MallUtil;
import com.myteam.mall.util.ResultEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author ljs
 */
@ControllerAdvice
public class MallExceptionResolver {

    @ExceptionHandler(value = DecreaseNumOverOnlineNumException.class)
    public ModelAndView resolveDecreaseNumOverInventoryNumException(DecreaseNumOverOnlineNumException exception,HttpServletRequest request,HttpServletResponse response)throws IOException{
        String viewName = "online-product-page";
        return commonResolve(viewName,exception,request,response);
    }

    @ExceptionHandler(value = DecreaseNumOverInventoryNumException.class)
    public ModelAndView resolveDecreaseNumOverInventoryNumException(DecreaseNumOverInventoryNumException exception,HttpServletRequest request,HttpServletResponse response)throws IOException{
        String viewName = "inventory-product-page";
        return commonResolve(viewName,exception,request,response);
    }

    @ExceptionHandler(value = ShopAcctAlreadyInUseException.class)
    public ModelAndView resolveShopAcctAlreadyInUseException(ShopAcctAlreadyInUseException exception,HttpServletRequest request,HttpServletResponse response)throws IOException{
        String viewName = "shop-list";
        return commonResolve(viewName,exception,request,response);
    }

    @ExceptionHandler(value = LoginAcctAlreadyInUseForUpdateException.class)
    public ModelAndView resolveLoginAcctAlreadyInUseException(LoginAcctAlreadyInUseForUpdateException exception,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String viewName = "system-error";
        return commonResolve(viewName,exception,request,response);
    }

    @ExceptionHandler(value = LoginAcctAlreadyInUseException.class)
    public ModelAndView resolveLoginAcctAlreadyInUseException(LoginAcctAlreadyInUseException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String viewName = "admin-add";
        return commonResolve(viewName,exception,request,response);
    }

    /**
     * ???????????????
     */
    @ExceptionHandler(value = AccessForbiddenException.class)
    public ModelAndView resolveAccessForbiddenException(AccessForbiddenException exception,HttpServletRequest request,HttpServletResponse response) throws IOException {
        String viewName = "admin-login";
        return commonResolve(viewName,exception,request,response);
    }

    /**
     * ????????????
     */
    @ExceptionHandler(value = LoginFailedException.class)
    public ModelAndView resolveLoginFailedException(LoginFailedException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String viewName =  "admin-login";
        return commonResolve(viewName,exception,request,response);
    }


    /**???????????????*/
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView resolveNullPointerException(NullPointerException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String viewName =  "system-error";
        return commonResolve(viewName,exception,request,response);
    }


    /** ??????????????????*/
    private ModelAndView commonResolve(String viewName, Exception exception, HttpServletRequest request, HttpServletResponse response ) throws IOException {
        // 1. ????????????????????????
        boolean judgeResult = MallUtil.judgeRequestType(request);
        // 2. ?????????Ajax??????
        if (judgeResult) {
            // 3. ?????? ResultEntity ??????
            ResultEntity<Object> resultEntity = ResultEntity.failed(exception.getMessage());
            // 4. ??????Gson??????
            Gson gson = new Gson();
            // 5. ???ResultEntity???????????????JSON?????????
            String json = gson.toJson(resultEntity);
            // 6. ???JSON???????????????????????????????????????
            response.getWriter().write(json);
            // 7. ????????????????????????response??????????????????????????????????????????ModelAndView??????
            return null;
        }
        // 8. ????????????Ajax??????????????????ModelAndView??????
        ModelAndView modelAndView = new ModelAndView();
        // 9. ???Exception??????????????????
        modelAndView.addObject(MallConstant.ATTR_NAME_EXCEPTION, exception);
        // 10. ???????????????????????????
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
