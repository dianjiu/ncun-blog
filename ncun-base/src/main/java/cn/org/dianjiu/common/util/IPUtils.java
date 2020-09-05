package cn.org.dianjiu.common.util;

import com.alibaba.fastjson.JSONObject;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Dianjiu on 2020/2/15.
 */
public class IPUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(IPUtils.class);

    //获取ip地址
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        System.out.println("x-forwarded-for ip: " + ip);
        if (ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个ip值，第一个ip才是真实ip
            if (ip.indexOf(",") != -1) {
                ip = ip.split(",")[0];
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
            System.out.println("Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
            System.out.println("WL-Proxy-Client-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
            System.out.println("HTTP_CLIENT_IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            System.out.println("HTTP_X_FORWARDED_FOR ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
            System.out.println("X-Real-IP ip: " + ip);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            System.out.println("getRemoteAddr ip: " + ip);
        }
        System.out.println("获取客户端ip: " + ip);
        return ip;
    }

    /**
     * 解析Ip地址工具类，传入IP地址，返回省、市、城市、运行商，以\t分割
     */
    public static String getIPInfo(String ip) {
        String result = "";
        // 关联下载的id2region.db 离线库
        String dbFile = "D:\\MyTools\\ip2region\\ip2region.db";
        try {
            DbSearcher search = new DbSearcher(new DbConfig(), dbFile);
            // 传入ip进行解析
            DataBlock dataBlock = search.btreeSearch(ip);
            // 获取解析后的数据  格式：国家|大区|省|市|运营商
            String region = dataBlock.getRegion();
            String replace = region.replace("|", ",");
            String[] splits = replace.split(",");
            if (splits.length == 5) {
                String country = splits[0];
                String province = splits[2];
                String city = splits[3];
                String operator = splits[4];
                // 拼接数据
                result = country + "\t" + province + "\t" + city + "\t" + operator;
            }
            return result;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 描述：获取IP地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");

        if (ip == null || ip.length() == 0 || "nuknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "nuknown".equalsIgnoreCase(ip)) {

            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "nuknown".equalsIgnoreCase(ip)) {

            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 描述：获取IP+[IP所属地址]
     * @param request
     * @return
     */
    public static String getIpBelongAddress(HttpServletRequest request) {

        String ip = getIpAddress(request);
        String belongIp = getIPbelongAddress(ip);

        return ip + belongIp;
    }

    /**
     * 描述：获取IP所属地址
     * @param ip
     * @return
     */
    public static String getIPbelongAddress(String ip){

        String ipAddress = "[]";
        try{
            //淘宝提供的服务地址
            String context = call("http://ip.taobao.com/service/getIpInfo.php?ip="+ip);
            JSONObject fromObject = JSONObject.parseObject(context);
            String code = fromObject.getString("code");
            if("0".equals(code)){
                JSONObject jsonObject = fromObject.getJSONObject("data");
                ipAddress = "["+jsonObject.get("country")+"/" +jsonObject.get("city")+"]";
            }
        }catch(Exception e){
            LOGGER.error("获取IP所属地址出错",e);
            e.printStackTrace();
        }
        return ipAddress;
    }

    /**
     * 描述：获取Ip所属地址
     * @param urlStr
     * @return
     */
    public static String call(String urlStr) {

        try {

            URL url = new URL(urlStr);
            HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

            httpCon.setConnectTimeout(3000);
            httpCon.setDoInput(true);
            httpCon.setRequestMethod("GET");

            int code = httpCon.getResponseCode();

            if (code == 200) {
                return streamConvertToSting(httpCon.getInputStream());
            }
        } catch (Exception e) {
            LOGGER.error("获取IP所属地址出错", e);
            e.printStackTrace();
        }
        return null;
    }

    /**
     *   描述：将InputStream转换成String
     *
     * @author huaping hu
     * @date 2016年6月1日下午5:51:53
     * @param is
     * @return
     */
    public static String streamConvertToSting(InputStream is) {

        String tempStr = "";
        try {

            if (is == null) {
                return null;
            }
            ByteArrayOutputStream arrayOut = new ByteArrayOutputStream();
            byte[] by = new byte[1024];
            int len = 0;
            while ((len = is.read(by)) != -1) {
                arrayOut.write(by, 0, len);
            }
            tempStr = new String(arrayOut.toByteArray());

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tempStr;
    }

    public static void main(String[] args) {

        String context = call("http://ip.taobao.com/service/getIpInfo.php?ip=120.192.182.1");

        JSONObject fromObject = JSONObject.parseObject(context);
        JSONObject jsonObject = fromObject.getJSONObject("data");
        System.out.println(fromObject);
        System.err.println(jsonObject.get("city"));
    }
}
