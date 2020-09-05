package cn.org.dianjiu.common.pojo.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by limengwei on 2019-11-25
 **/
@Getter
@Setter
public class PageVO<T> implements Serializable {
    private int pageNum;
    private int pageSize;
    private long total;
    private int pages;
    private T data;
}
