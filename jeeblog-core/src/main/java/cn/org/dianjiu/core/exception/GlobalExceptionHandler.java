package cn.org.dianjiu.core.exception;




import cn.org.dianjiu.core.constant.CodeEnum;
import cn.org.dianjiu.core.pojo.vo.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = BusinessException.class)
    public ResultBean BusinessExceptionHandler(BusinessException e) {
        ResultBean res = ResultBean.builder().build();
        res.setCode(e.getCode());
        res.setMsg(e.getMessage());
        log.error(String.valueOf(res));
        return res;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(value = Exception.class)
    public ResultBean ExceptionHandler(Exception e) {
        ResultBean res = ResultBean.builder().build();
        res.setCode(CodeEnum.SYS_ERROR.getCode());
        res.setMsg(CodeEnum.SYS_ERROR.getMsg());
        return res;
    }
}

