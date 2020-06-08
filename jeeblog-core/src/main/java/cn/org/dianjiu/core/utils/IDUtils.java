package cn.org.dianjiu.core.utils;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class IDUtils {
    /**
     * 图片名生成
     */
    public static String genImageName() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime(); //纳秒
        //加上三位随机数
        Random random = new Random();
        int end3 = random.nextInt(999);
        //如果不足三位前面补0
        String str = millis + String.format("%03d", end3);

        return str;
    }

    /**
     * 商品id生成
     */
    public static long genItemId() {
        //取当前时间的长整形值包含毫秒
        long millis = System.currentTimeMillis();
        //long millis = System.nanoTime();
        //加上两位随机数
        Random random = new Random();
        int end2 = random.nextInt(99);
        //如果不足两位前面补0
        String str = millis + String.format("%02d", end2);
        long id = new Long(str);
        return id;
    }

    /**
     * 主要功能:生成uuid
     * 注意事项:无
     *
     * @return uuid 32 位
     */
    public static String createIdbyUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 以毫微秒做基础计数, 返回唯一有序增长ID
     * <pre>System.nanoTime()</pre>
     * <pre>
     * 线程数量: 100
     * 执行次数: 1000
     * 平均耗时: 222 ms
     * 数组长度: 100000
     * Map Size: 100000
     * </pre>
     * @return ID长度32位
     */
    public static String getPrimaryKey(){
        return MathUtils.makeUpNewData(Thread.currentThread().hashCode()+"", 3)+ MathUtils.randomDigitNumber(7);           //随机7位数
    }

    /**
     * 生产一个随机的指定位数的字符串数字
     * @param length
     * @return
     */
    public static String randomNumber(int length){
        String number = MathUtils.randomDigitNumber(length);
        return number;
    }

    /**
     * 生产一个随机的指定位数的字符串数字
     * @return
     */
    public static List<Long> getSnowNums(int nums){
        return SnowFlakeUtils.getSnowIds(nums);
    }

    public static void main(String[] args) {
        /*for(int i=0;i< 100;i++) {
            System.out.println(getSnowNums(10));
        }*/
        List<Long> snowNums = getSnowNums(10);
        for (Long snowNum : snowNums) {
            System.out.println(snowNum);
        }
    }
}
