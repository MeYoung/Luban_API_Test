package otp.lucky.common.utils;

import lombok.extern.slf4j.Slf4j;
import otp.lucky.params.FinalText;

import java.io.UnsupportedEncodingException;
import java.util.Random;


/**
 * @Author shijin.huang
 * @Date 2021/10/20
 * <p>
 * 中文名称随机生成
 */
@Slf4j
public class ChineseNameUtil {

    private static ChineseNameUtil chineseNameUtil = new ChineseNameUtil();

    private ChineseNameUtil() {
    }

    public static ChineseNameUtil getInstance() {
        return chineseNameUtil;
    }

    private static final String[] FIRST_NAMES = {"李", "王", "张",
            "刘", "陈", "杨", "黄", "赵", "周", "吴", "徐", "孙", "朱", "马", "胡", "郭", "林",
            "何", "高", "梁", "郑", "罗", "宋", "谢", "唐", "韩", "曹", "许", "邓", "萧", "冯",
            "曾", "程", "蔡", "彭", "潘", "袁", "於", "董", "余", "苏", "叶", "吕", "魏", "蒋",
            "田", "杜", "丁", "沈", "姜", "范", "江", "傅", "钟", "卢", "汪", "戴", "崔", "任",
            "陆", "廖", "姚", "方", "金", "邱", "夏", "谭", "韦", "贾", "邹", "石", "熊", "孟",
            "秦", "阎", "薛", "侯", "雷", "白", "龙", "段", "郝", "孔", "邵", "史", "毛", "常",
            "万", "顾", "赖", "武", "康", "贺", "严", "尹", "钱", "施", "牛", "洪", "龚", "东方",
            "夏侯", "诸葛", "尉迟", "皇甫", "宇文", "鲜于", "西门", "司马", "独孤", "公孙", "慕容", "轩辕",
            "左丘", "欧阳", "皇甫", "上官", "闾丘", "令狐"};

    /**
     * 随机生成 中文名
     *
     * @return 中文名
     */
    public String getChineseNameRandom() {
        int i = Math.toIntExact(RandomUtil.getNumRandom(0, FIRST_NAMES.length - 1));
        String firstName = FIRST_NAMES[i];
        StringBuilder stringBuilder = new StringBuilder();
        if (i % FinalText.NUM_2 == FinalText.NUM_0) {
            return stringBuilder.append(firstName).append(getRandomChar()).toString();
        }
        return stringBuilder.append(firstName).append(getRandomChar()).append(getRandomChar()).toString();
    }


    /**
     * 随机生成一个 汉子
     *
     * @return
     */
    public String getRandomChar() {
        String str = null;
        int highPos, lowPos;
        long seed = RandomUtil.getNumRandom(FinalText.NUM_16);
        Random random = new Random(seed);
        highPos = FinalText.NUM_176 + Math.abs(random.nextInt(FinalText.NUM_39));
        lowPos = FinalText.NUM_161 + Math.abs(random.nextInt(FinalText.NUM_93));
        byte[] b = new byte[FinalText.NUM_2];
        b[0] = (new Integer(highPos)).byteValue();
        b[1] = (new Integer(lowPos)).byteValue();
        try {
            str = new String(b, "GBK");
        } catch (UnsupportedEncodingException e) {
            log.error("生成汉子失败！！！，{}",e.toString());
        }
        return str;
    }

}
