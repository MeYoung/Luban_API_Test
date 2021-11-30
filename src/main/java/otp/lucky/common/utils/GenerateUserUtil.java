package otp.lucky.common.utils;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by liping.li on 2020-01-17
 * <p>
 * 随机生成用户相关数据
 */
public class GenerateUserUtil {


    private static final String place[][] = {
            {"北京", "市辖区", "市辖县"},
            {"天津", "市辖区", "市辖县"},
            {"安徽", "安庆市", "蚌埠市", "亳州市", "巢湖市", "池州市", "滁州市", "阜阳市", "合肥市", "淮北市", "淮南市", "黄山市", "六安市", "马鞍山市", "宿州市", "铜陵市", "芜湖市", "宣城市"},
            {"澳门", "澳门"},
            {"香港", "香港"},
            {"福建", "福州市", "龙岩市", "南平市", "宁德市", "莆田市", "泉州市", "厦门市", "漳州市"},
            {"甘肃", "白银市", "定西市", "甘南藏族自治州", "嘉峪关市", "金昌市", "酒泉市", "兰州市", "临夏回族自治州", "陇南市", "平凉市", "庆阳市", "天水市", "武威市", "张掖市"},
            {"广东", "潮州市", "东莞市", "佛山市", "广州市", "河源市", "惠州市", "江门市", "揭阳市", "茂名市", "梅州市", "清远市", "汕头市", "汕尾市", "韶关市", "深圳市", "阳江市", "云浮市", "湛江市", "肇庆市", "中山市", "珠海市"},
            {"广西", "百色市", "北海市", "崇左市", "防城港市", "贵港市", "桂林市", "河池市", "贺州市", "来宾市", "柳州市", "南宁市", "钦州市", "梧州市", "玉林市"},
            {"贵州", "安顺市", "毕节地区", "贵阳市", "六盘水市", "黔东南苗族侗族自治州", "黔南布依族苗族自治州", "黔西南布依族苗族自治州", "铜仁地区", "遵义市"},
            {"海南", "海口市", "三亚市", "省直辖县级行政区划"},
            {"河北", "保定市", "沧州市", "承德市", "邯郸市", "衡水市", "廊坊市", "秦皇岛市", "石家庄市", "唐山市", "邢台市", "张家口市"},
            {"河南", "安阳市", "鹤壁市", "焦作市", "开封市", "洛阳市", "漯河市", "南阳市", "平顶山市", "濮阳市", "三门峡市", "商丘市", "新乡市", "信阳市", "许昌市", "郑州市", "周口市", "驻马店市"},
            {"黑龙江", "大庆市", "大兴安岭地区", "哈尔滨市", "鹤岗市", "黑河市", "鸡西市", "佳木斯市", "牡丹江市", "七台河市", "齐齐哈尔市", "双鸭山市", "绥化市", "伊春市"},
            {"湖北", "鄂州市", "恩施土家族苗族自治州", "黄冈市", "黄石市", "荆门市", "荆州市", "十堰市", "随州市", "武汉市", "咸宁市", "襄樊市", "孝感市", "宜昌市"},
            {"湖南", "长沙市", "常德市", "郴州市", "衡阳市", "怀化市", "娄底市", "邵阳市", "湘潭市", "湘西土家族苗族自治州", "益阳市", "永州市", "岳阳市", "张家界市", "株洲市"},
            {"吉林", "白城市", "白山市", "长春市", "吉林市", "辽源市", "四平市", "松原市", "通化市", "延边朝鲜族自治州"},
            {"江苏", "常州市", "淮安市", "连云港市", "南京市", "南通市", "苏州市", "宿迁市", "泰州市", "无锡市", "徐州市", "盐城市", "扬州市", "镇江市"},
            {"江西", "抚州市", "赣州市", "吉安市", "景德镇市", "九江市", "南昌市", "萍乡市", "上饶市", "新余市", "宜春市", "鹰潭市"},
            {"辽宁", "鞍山市", "本溪市", "朝阳市", "大连市", "丹东市", "抚顺市", "阜新市", "葫芦岛市", "锦州市", "辽阳市", "盘锦市", "沈阳市", "铁岭市", "营口市"},
            {"内蒙古", "阿拉善盟", "巴彦淖尔市", "包头市", "赤峰市", "鄂尔多斯市", "呼和浩特市", "呼伦贝尔市", "通辽市", "乌海市", "乌兰察布市", "锡林郭勒盟", "兴安盟"},
            {"宁夏", "固原市", "石嘴山市", "吴忠市", "银川市", "中卫市"},
            {"青海", "果洛藏族自治州", "海北藏族自治州", "海东地区", "海南藏族自治州", "海西蒙古族藏族自治州", "黄南藏族自治州", "西宁市", "玉树藏族自治州"},
            {"山东", "滨州市", "德州市", "东营市", "菏泽市", "济南市", "济宁市", "莱芜市", "聊城市", "临沂市", "青岛市", "日照市", "泰安市", "威海市", "潍坊市", "烟台市", "枣庄市", "淄博市"},
            {"山西", "长治市", "大同市", "晋城市", "晋中市", "临汾市", "吕梁市", "朔州市", "太原市", "忻州市", "阳泉市", "运城市"},
            {"陕西", "安康市", "宝鸡市", "汉中市", "商洛市", "铜川市", "渭南市", "西安市", "咸阳市", "延安市", "榆林市"},
            {"四川", "阿坝藏族羌族自治州", "巴中市", "成都市", "达州市", "德阳市", "甘孜藏族自治州", "广安市", "广元市", "乐山市", "凉山彝族自治州", "泸州市", "眉山市", "绵阳市", "内江市", "南充市", "攀枝花市", "遂宁市", "雅安市", "宜宾市", "资阳市", "自贡市"},
            {"西藏", "阿里地区", "昌都地区", "拉萨市", "林芝地区", "那曲地区", "日喀则地区", "山南地区"},
            {"新疆", "阿克苏地区", "阿勒泰地区", "巴音郭楞蒙古自治州", "博尔塔拉蒙古自治州", "昌吉回族自治州", "哈密地区", "和田地区", "喀什地区", "克拉玛依市", "克孜勒苏柯尔克孜自治州", "塔城地区", "吐鲁番地区", "乌鲁木齐市", "伊犁哈萨克自治州", "自治区直辖县级行政区划"},
            {"云南", "保山市", "楚雄彝族自治州", "大理白族自治州", "德宏傣族景颇族自治州", "迪庆藏族自治州", "红河哈尼族彝族自治州", "昆明市", "丽江市", "临沧市", "怒江僳僳族自治州", "普洱市", "曲靖市", "文山壮族苗族自治州", "西双版纳傣族自治州", "玉溪市", "昭通市"},
            {"浙江", "杭州市", "湖州市", "嘉兴市", "金华市", "丽水市", "宁波市", "衢州市", "绍兴市", "台州市", "温州市", "舟山市"},
            {"重庆", "市辖区", "市辖县", "县级市"},
            {"台湾", "台北市", "高雄市", "基隆市", "台中市", "台南市", "新竹市", "嘉义市"},
    };

    private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn".split(",");
//    private static String[] sexs = {"男", "女"};


    private static String[] engageJob = {"互联网服务行业", "餐饮行业", "教育行业", "金融业", "电子商务", "新能源", "新媒体运营", "服务业"};

    private static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }
//    获得随机数的方法

    private static int getRandom(int length) {
        Random random = new Random();
        return random.nextInt(length);
    }


    /**
     * 返回Email
     *
     * @param lMin 最小长度
     * @param lMax 最大长度
     * @return 返回 email
     */
    private static String getEmail(int lMin, int lMax) {
        int length = getNum(lMin, lMax);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            String base = "abcdefghijklmnopqrstuvwxyz0123456789";
            int number = (int) (Math.random() * base.length());
            sb.append(base.charAt(number));
        }
        sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
        return sb.toString();
    }

    /**
     * 返回手机号码
     */
    private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");

    private static String getTel() {
        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String third = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + third;
    }

    private static String getChineseName() {
        String firstName = "赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
        int index = getNum(0, firstName.length() - 1);
        String first = firstName.substring(index, index + 1);
        int sex = getNum(0, 1);
        String boy = "伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";
        String str = boy;
        int length = boy.length();

//      返回中文姓名
        if (sex == 0) {
            String girl = "秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
            str = girl;
            length = girl.length();
        }
        index = getNum(0, length - 1);
        String second = str.substring(index, index + 1);
        int hasThird = getNum(0, 1);
        String third = "";
        if (hasThird == 1) {
            index = getNum(0, length - 1);
            third = str.substring(index, index + 1);
        }
        return first + second + third;
    }


    /**
     * 生成随机时间
     *
     * @param beginDate 开始时间
     * @param endDate   结束时间
     * @return 随机时间
     */
    private static Date randomDate(String beginDate, String endDate) {

        try {

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            //构造开始日期
            Date start = format.parse(beginDate);
            //构造结束日期
            Date end = format.parse(endDate);

            //getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。

            if (start.getTime() >= end.getTime()) {

                return null;

            }

            long date = random(start.getTime(), end.getTime());

            return new Date(date);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    private static long random(long begin, long end) {

        long rtn = begin + (long) (Math.random() * (end - begin));

        //如果返回的是开始时间和结束时间，则递归调用本函数查找随机值

        if (rtn == begin || rtn == end) {

            return random(begin, end);

        }

        return rtn;

    }

    public List<String> getProvince() {
        List<String> provinceList = new ArrayList<>();
        for (String[] pList : place) {
            provinceList.add(pList[0]);
        }
        return provinceList;
    }


}
