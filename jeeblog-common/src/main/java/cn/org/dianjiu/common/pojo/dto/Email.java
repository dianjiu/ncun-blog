package cn.org.dianjiu.common.pojo.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Email implements Serializable {

    private static final long serialVersionUID = -5671090481327650015L;

    private String from;//发件人
    private String[] to;//收件人
    private String[] cc;//抄送人
    private String[] Bcc;//密送人
    private String subject;//主题
    private String content;//内容
    private String rscPath;//图片路径
    private String rscId;//CID
    private String[] filePaths;//附件地址

}
