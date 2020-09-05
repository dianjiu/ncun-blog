package cn.org.dianjiu.common.pojo.vo;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 8676131899637805509L;

    // 返回编码
    private String code;
    // 返回信息
    private String msg;
    // 签名
    @Builder.Default
    private String sign = "";
    // 返回数据封装
    @Builder.Default
    private T data = (T) "";

    public ResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
