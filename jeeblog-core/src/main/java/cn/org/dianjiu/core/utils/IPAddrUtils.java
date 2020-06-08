package cn.org.dianjiu.core.utils;

import com.alibaba.fastjson.JSONObject;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * Created by Dianjiu on 2020/2/15
 * 获取请求IP地址、浏览器相关信息
*/
public class IPAddrUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(IPAddrUtils.class);

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

    /**
     * 获取发起请求的IP地址
     */
    public static String getIp(HttpServletRequest request) {
        String ip = null;
        ip = request.getHeader("x-forwarded-for");
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ip = inet.getHostAddress();
            }
        }
        if ((ip != null) && (ip.length() > 15)) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }
        return ip;
    }

    /**
     * 获取发起请求的浏览器名称
     */
    public static String getBrowserName(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        Browser browser = userAgent.getBrowser();
        return browser.getName();
    }

    /**
     * 获取发起请求的浏览器版本号
     */
    public static String getBrowserVersion(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //获取浏览器版本号
        Version version = browser.getVersion(header);
        return version.getVersion();
    }

    /**
     * 获取发起请求的操作系统名称
     */
    public static String getOsName(HttpServletRequest request) {
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        return operatingSystem.getName();
    }

    public static void main(String[] args) {

        String context = call("http://ip.taobao.com/service/getIpInfo.php?ip=192.168.64.1");
        JSONObject fromObject = JSONObject.parseObject(context);
        JSONObject jsonObject = fromObject.getJSONObject("data");
        System.out.println(fromObject);
        System.err.println(jsonObject.get("city"));
    }
}
