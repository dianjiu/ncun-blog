package cn.org.dianjiu.common.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.http.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by Dianjiu on 2020/2/15.
 */
public class FtpUtils {

    private static final Logger log = LoggerFactory.getLogger(FtpUtils.class);

    private FTPClient ftpClient;
    private String strencoding = "UTF-8";
    private String ip; // 服务器IP地址
    private String userName; // 用户名
    private String userPwd; // 密码
    private String port; // 端口号
    private String path; // 读取文件的存放目录
    private String fileName; // 文件名
    private String encodeFormat;

    /**
     * init ftp servere
     */
    public FtpUtils(Map<String,String> paramMap) {
        this.ip = paramMap.get("IP");
        this.port = paramMap.get("PORT");
        this.userName = paramMap.get("USER_NAME");
        this.userPwd = paramMap.get("PWD");
        this.path = paramMap.get("PATH");
        this.fileName = paramMap.get("fileName");
        this.encodeFormat = paramMap.get("ENCODE_FORMAT");
        this.reSet();
    }

    public void reSet() {
        connectServer(ip, port, userName, userPwd, path);
    }

    /**
     * @description connect to ftp
     * @param ip
     * @param port
     * @param userName
     * @param userPwd
     * @param path
     */
    public void connectServer(String ip, String port, String userName, String userPwd, String path) {
        ftpClient = new FTPClient();
        ftpClient.setControlEncoding("GBK");
        FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_NT);
        conf.setServerLanguageCode("zh");
        try {
            // 连接
            log.info("\n--->>>:ftp尝试连接");
            ftpClient.connect(ip, Integer.parseInt(port));
            // 登录
            ftpClient.login(userName, userPwd);
            log.info("\n--->>>:ftp连接成功！");
            if (path != null && path.length() > 0) {
                // 跳转到指定目录
                //ftpClient.changeWorkingDirectory(path);
                log.info("=============本机服务IP："+ftpClient.getLocalAddress());
                log.info("=============本机服务工作路径："+ftpClient.printWorkingDirectory());
            }
        } catch (SocketException e) {
            log.info("\n--->>>:ftp连接异常！");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws IOException
     *             function:关闭连接
     */
    public void closeServer() {
        if (ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
                log.info("\n--->>>:ftp关闭成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @author dianjiu
     * @param fileName
     * @description:从服务器上读取指定的文件名，读取内容并以List<String>形式返回：第一行对应list[0]，第二行对应list[1]，……
     * @throws ParseException
     */
    public List<String> readFile() throws Exception {
        InputStream ins = null;
        List<String> list = new ArrayList<String>();
        try {
            log.info("读取文件："+ fileName +"开始...");
            // 从服务器上读取指定的文件
            if(!StringUtils.isEmpty(encodeFormat)){
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                log.info("==============转码中==================" + encodeFormat);
                ins = ftpClient.retrieveFileStream(new String(fileName.getBytes(encodeFormat),"iso-8859-1"));
            }else{
                log.info("==============非转码==================" );
                ins = ftpClient.retrieveFileStream(fileName);
            }
            log.info("文件内容："+ ins +"开始...");
            if (ins == null) {
                log.info("读取文件：" + fileName + "失败！");
                return null;
            }
            log.info("读取文件："+ fileName +"结束...");
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins, strencoding));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            reader.close();
            if (ins != null) {
                ins.close();
            }
            // 主动调用一次getReply(),解决这个返回null问题
            ftpClient.completePendingCommand();
            //ftpClient.getReply();
//       closeServer();
            log.info("读取文件："+ fileName +"结束...");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("=====================FTP读取异常"+e.getMessage());
        }
        return list;
    }

    /**
     * 上传文件至ftp指定目录
     * @param txtFile
     * @throws IOException
     */
    public void uploadtxtFile(File txtFile) throws IOException {
        String fileName = txtFile.getName();
        String prefix = fileName.substring(0, 23);
        String suffix = ".txt";
        InputStream input = new FileInputStream(txtFile);
        ftpClient.storeFile(prefix + suffix, input);
        log.info("上传对账结果文件成功！");
    }

    /**
     * 重命名指定文件
     * @throws IOException
     */
    public void renameFile(String newFileName, String oldFileName) throws IOException {
        ftpClient.changeWorkingDirectory(path);
        ftpClient.rename(newFileName, oldFileName);
        log.info("重命名对账初始文件成功！");
        closeServer();
    }

}
