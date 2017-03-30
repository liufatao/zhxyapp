package com.yunhuakeji.app.constants;

/**
 * api url
 */

public class YunHuaUrl {
    /**
     * 所有地址入口
     * 需要修改服务器地址在这里配置
     */
    //测试接口
    private static final String BASE_SERVER = YunhuaApi.WDDXSERVER_DEBUG;

    //UIA
    private static final String BASE_UIA = YunhuaApi.YHKJUIA;
    //DC
    private static final String BASE_DC = YunhuaApi.YHKJDC;
    //PUSH
    private static final String BASE_PUSH = YunhuaApi.YHKJPUSH;

    /**
     * 应用管理模块
     */
    //提交我的应用数据接口
    public static final String APPLY_URL_SET = BASE_SERVER.concat("/GroupChat/Contacts/setFunctionList");
    //请求我的应用数据接口
    public static final String APPLY_URL_GET = BASE_SERVER.concat("/GroupChat/Contacts/getFunctionList");
    //功能列表
//    public static final String FUNCTION_URL = BASE_UIA.concat("/UIA/function/getlist.action");
    //功能列表老版本
    public static final String FUNCTION_URL_OLD = BASE_UIA.concat("/UIA/function/list.action");
    //应用页
    public static final String APPLY_URL = BASE_UIA.concat("/GroupChat/Contacts/getFunctionList");


    /**
     * 个人信息模块
     */

    //获取用户基本信息
    public static final String USERINFO_URL_GETSTUDENTINFO = BASE_SERVER.concat("/getStudentInfo");
    //修改昵称
    public static final String USERINFO_URL_UPDATASTUDENTPETNAME = BASE_SERVER.concat("/updateStudentPetName");
    //修改联系电话
    public static final String USERINFO_URL_UPDATESTUDENTPHONENUMBER = BASE_SERVER.concat("/updateStudentPhoneNumber");
    //修改QQ
    public static final String USERINFO_URL_UPDATESTUDENTQQ = BASE_SERVER.concat("/updateStudentQQ");
    //修改头像 UIA
    public static final String USERINFO_URL_UPDATEHANDPHOTO = BASE_UIA.concat("user/updateuser.action");
    //二维码储存地址
    public static final String USERINFO_URL_ERWEIMA = BASE_UIA.concat("/?userid=");
    /**
     * 个人中心模块
     */
    //修改密码
    public static final String PERSONAL_URL_UPDATEPWD = BASE_UIA.concat("/UIA/user/updatepassword.action");
    //修改资料
    public static final String PERSONAL_URL_UPDATEUSERINFO = BASE_UIA.concat("/UIA/user/updateuser.action");
    //登陆
    public static final String PERSONAL_URL_LOGON = BASE_UIA.concat("/UIA/login/logon.action");
    //登陆老版本
    public static final String PERSONAL_URL_LOGONOLD = BASE_UIA.concat("/UIA/login/login.action");


    /**
     * 设置模块
     */
    //意见反馈
    public static final String SET_URL_FEEDBACKSUGGESTIONS = BASE_SERVER.concat("/feedbackSuggestions");


    /**
     * 关于模块
     */
    //功能介绍
    public static final String ABOUT_URL_INTRODUCE = BASE_SERVER.concat("/introduce");

    /**
     * 版本更新
     */
    public static final String CHECKUPDATE = BASE_UIA.concat("/UIA/update/updateVersion.action?mobileType=android&versionCode=");

    /**
     * 学生服务模块
     */
    //成绩查询
    public static final String CHENJICHAXUN = BASE_DC.concat("/DC/score/getlist.action");
    //课表查询
    public static final String KEBIAOSHIJIAN = BASE_DC.concat("/DC/Course/list.action");
    //发起点名
    public static final String FAQIDIANMING = BASE_DC.concat("/DC/zhkt/fqdm.action");
    //学生点名
    public static final String XUESHENDIANMING = BASE_DC.concat("/DC/zhkt/xsdm.action");
    //课堂学生列表
    public static final String KETANGXUESHENLIEBIAO = BASE_DC.concat("/DC/zhkt/ktxs.action");
    //已点学生列表
    public static final String YIDIANXUESHEN = BASE_DC.concat("/DC/zhkt/yyydmxs.action");
    //提交点名
    public static final String TIJIAODIANMING = BASE_DC.concat("/DC/zhkt/tjdmjg.action");
    //校园地图
    public static final String XIAOYUANDITU = BASE_DC.concat("/DC/map/getlist.action");
    //点名次数
    public static final String DIANMINGCISHU = BASE_DC.concat("/DC/zhkt/getDmcs.action");
    //点名班级
    public static final String DIANMINGBANJI = BASE_DC.concat("/DC/zhkt/dmbj.action");
    //教师小字条学生百名单
    public static final String XUESHENBAIMINGDAN = BASE_DC.concat("/DC/zhkt/getJsztxsmd.action");
    //教师对话框内容
    public static final String JIAOSHIDUIHUANEIRONG = BASE_DC.concat("/DC/zhkt/getJsdhknr.action");
    //学生对话框内容
    public static final String XUESHENDUIHUANEIRONG = BASE_DC.concat("/DC/zhkt/getXsdhknr.action");
    //教师列表
    public static final String JIAOSHILIEBIAO = BASE_DC.concat("/DC/zhkt/getKtjsbh.action");
    //学生评教
    public static final String XUESHENPINGJIAO = BASE_DC.concat("/DC/zhkt/saveXspj.action");
    //获取学生评教
    public static final String HUOQUXUESHENPINGJIAO = BASE_DC.concat("/DC/zhkt/getXspjnr.action");
    //获取教师评教
    public static final String HUOQUJIAOSHIPINGJIAO = BASE_DC.concat("/DC/zhkt/getXspjnr.action");
    //发纸条
    public static final String FAZHITIAO = BASE_DC.concat("/DC/zhkt/saveZtnr.action");
    //所以学生点名结果
    public static final String ALLXUESHENDIANMINGJIEGUO = BASE_DC.concat("/DC/zhkt/getAllxsdmjg.action");
    //保存课堂信息
    public static final String BAOCUNKETANGXINGXI = BASE_DC.concat("/DC/zhkt/saveKtxx.action");
    //节假日
    public static final String JIEJIARI = BASE_DC.concat("/DC/calendar/jjr.action");
    //所以时间
    public static final String ALLTIME = BASE_DC.concat("/DC/calendar/termlist.action");


    /**
     * 消息模块
     */
    //通讯录
    public static final String TONGXUNLU = BASE_DC.concat("/DC/txl/getlist.action");
    //时间
    public static final String SHIJIAN = BASE_DC.concat("/DC/calendar/list.action");
    //当前时间
    public static final String DANGQIANSHIJIAN = BASE_DC.concat("/DC/calendar/nowterm.action");
    //圈子好友列表
    public static final String QUANZIHAOYOULIEBIAO = BASE_DC.concat("/DC/sq/hqhylb.action");
    //默认圈子列表
    public static final String MORENQUANZI = BASE_DC.concat("/DC/sq/hqmrfz.action");
    //添加好友
    public static final String TIANJIAHAOYOU = BASE_DC.concat("/DC/sq/tjhy.action");
    //是否添加好友
    public static final String SHIFOUTIANJIA = BASE_DC.concat("/DC/sq/yzhy.action");
    //搜索好友
    public static final String SHOUSUOHAOYOU = BASE_DC.concat("/DC/sq/msrcx.action");
    //聊天接口
    public static final String LIAOTIAN = BASE_PUSH.concat("/chat/sendChat");
    //聊天反馈接口
    public static final String LIAOTIANFANKUI = BASE_PUSH.concat("/chat/sendChat");
    //离线聊天接口
    public static final String LIXIANLIAOTIAN = BASE_PUSH.concat("/chat/offineSend");
    //推送反馈接口
    public static final String TUISONGFANKUI = BASE_PUSH.concat("/push/receive");
    //推送离线接口
    public static final String TUISONGLIXIAN = BASE_PUSH.concat("/push/offine");
    //添加好友反馈接口
    public static final String TIANJIAHAOYOUFANKU = BASE_PUSH.concat("/chat/receiveAdd");
    //确认添加好友离线接口
    public static final String QUERENTIANJIAHAOYOULIXIAN = BASE_PUSH.concat("/chat/offineAdd");
    //所以离线接口
    public static final String LIXIAN = BASE_PUSH.concat("/offine/all");


    /**
     * 测试json数据
     */
    public static final String json = "{\"content\":{\"my_app\":[{\"name\":\"我的应用\",\"list\":[{\"function_face\":\"http://app.cqut.edu.cn/content/image/qz.png\",\"function_id\":20150120,\"unchange\":1,\"type_name\":\"我的应用\",\"function_name\":\"社区\",\"type_id\":0},{\"function_face\":\"http://app.cqut.edu.cn/content/image/bgdhcx.png\",\"function_id\":20150121,\"unchange\":1,\"type_name\":\"我的应用\",\"function_name\":\"办公电话(作废）\",\"type_id\":0}]}],\"other_app\":[{\"name\":\"测试1\",\"list\":[{\"function_face\":\"http://app.cqut.edu.cn/content/image/wybs.png\",\"function_id\":20150119,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"我要办事\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/swzl.png\",\"function_id\":20150118,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"失物招领\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/qz.png\",\"function_id\":20150120,\"unchange\":1,\"type_name\":\"测试1\",\"function_name\":\"社区\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/kbcx.png\",\"function_id\":20150105,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"课表查询\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/jkcx.png\",\"function_id\":30000006,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"监考查询\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/cjcx.png\",\"function_id\":20150106,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"成绩查询\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/oabg.png\",\"function_id\":30000101,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"公文处理\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xysc.png\",\"function_id\":20150127,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"校园风光\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/bysh.png\",\"function_id\":30000003,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"毕业审核\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/zslx.png\",\"function_id\":20150123,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"掌上离校\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/kscx.png\",\"function_id\":30000005,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"考试查询\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xysj.png\",\"function_id\":20150112,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"校园实景\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/gzjf.png\",\"function_id\":20150113,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"财务查询\",\"type_id\":1},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xysc.png\",\"function_id\":20160227,\"unchange\":0,\"type_name\":\"测试1\",\"function_name\":\"会议现场\",\"type_id\":1}]},{\"name\":\"测试2\",\"list\":[{\"function_face\":\"http://app.cqut.edu.cn/content/image/zhkt.png\",\"function_id\":20150116,\"unchange\":0,\"type_name\":\"测试2\",\"function_name\":\"智慧课堂\",\"type_id\":2},{\"function_face\":\"http://app.cqut.edu.cn/content/image/wjdc.png\",\"function_id\":20150115,\"unchange\":0,\"type_name\":\"测试2\",\"function_name\":\"问卷调查\",\"type_id\":2},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xwpt.png\",\"function_id\":20150114,\"unchange\":0,\"type_name\":\"测试2\",\"function_name\":\"学校新闻\",\"type_id\":2},{\"function_face\":\"http://app.cqut.edu.cn/content/image/tscx.png\",\"function_id\":20150111,\"unchange\":0,\"type_name\":\"测试2\",\"function_name\":\"图书借阅\",\"type_id\":2},{\"function_face\":\"http://app.cqut.edu.cn/content/image/dbsy.png\",\"function_id\":20150104,\"unchange\":0,\"type_name\":\"测试2\",\"function_name\":\"待办事宜\",\"type_id\":2},{\"function_face\":\"http://app.cqut.edu.cn/content/image/zsyx.png\",\"function_id\":20150122,\"unchange\":0,\"type_name\":\"测试2\",\"function_name\":\"掌上迎新\",\"type_id\":2},{\"function_face\":\"http://app.cqut.edu.cn/content/image/yxtj.png\",\"function_id\":30000103,\"unchange\":0,\"type_name\":\"测试2\",\"function_name\":\"迎新统计\",\"type_id\":2},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xmzs.png\",\"function_id\":20150126,\"unchange\":0,\"type_name\":\"测试2\",\"function_name\":\"校貌展示\",\"type_id\":2}]},{\"name\":\"测试3\",\"list\":[{\"function_face\":\"http://app.cqut.edu.cn/content/image/xysc.png\",\"function_id\":20150110,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"校园拾粹\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xndt.png\",\"function_id\":20150124,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"校内地图\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/bgdhcx.png\",\"function_id\":20150121,\"unchange\":1,\"type_name\":\"测试3\",\"function_name\":\"办公电话(作废）\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xykcx.png\",\"function_id\":20160224,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"一卡通\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/bccx.png\",\"function_id\":20160222,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"学分提醒\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/zslxd.png\",\"function_id\":30000102,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"掌上离校单\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xndt.png\",\"function_id\":20150128,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"在线报修\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/dzyj.png\",\"function_id\":30000011,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"电子邮件\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xlrc.png\",\"function_id\":20150101,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"校历日程\",\"type_id\":3},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xygk.png\",\"function_id\":20150125,\"unchange\":0,\"type_name\":\"测试3\",\"function_name\":\"学校概况\",\"type_id\":3}]},{\"name\":\"测试4\",\"list\":[{\"function_face\":\"http://app.cqut.edu.cn/content/image/szzy.png\",\"function_id\":30000109,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"数字资源\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xjfx.png\",\"function_id\":20150108,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"数据分析\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/wbjh.png\",\"function_id\":30000108,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"微博聚合\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xykcx.png\",\"function_id\":40000001,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"满意了吧\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/bgdhcx.png\",\"function_id\":30000002,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"办公电话\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/tzsc.png\",\"function_id\":20150117,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"跳蚤市场\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/bccx.png\",\"function_id\":20150109,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"班车查询\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/xfjs.png\",\"function_id\":30000001,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"学分结算\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/grrz.png\",\"function_id\":20150102,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"个人日志\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/tzgg.png\",\"function_id\":20150103,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"学校通知\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/jscx.png\",\"function_id\":20150107,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"教室查询\",\"type_id\":4},{\"function_face\":\"http://app.cqut.edu.cn/content/image/cjcx.png\",\"function_id\":20150206,\"unchange\":0,\"type_name\":\"测试4\",\"function_name\":\"成绩查询\",\"type_id\":4}]}],\"function_version\":0},\"message\":\"成功\",\"code\":\"40001\"}";
}
