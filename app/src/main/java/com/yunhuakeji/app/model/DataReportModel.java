package com.yunhuakeji.app.model;

import java.util.List;

public class DataReportModel
{

	/**
	 * content :
	 * {"my_app":[{"name":"我的应用","list":[{"function_face":"http://app.cqut.edu.cn/content/image/qz.png","function_id":20150120,"unchange":1,"type_name":"我的应用","function_name":"社区","type_id":0},{"function_face":"http://app.cqut.edu.cn/content/image/bgdhcx.png","function_id":20150121,"unchange":1,"type_name":"我的应用","function_name":"办公电话(作废）","type_id":0}]}],"other_app":[{"name":"测试1","list":[{"function_face":"http://app.cqut.edu.cn/content/image/wybs.png","function_id":20150119,"unchange":0,"type_name":"测试1","function_name":"我要办事","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/swzl.png","function_id":20150118,"unchange":0,"type_name":"测试1","function_name":"失物招领","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/qz.png","function_id":20150120,"unchange":1,"type_name":"测试1","function_name":"社区","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/kbcx.png","function_id":20150105,"unchange":0,"type_name":"测试1","function_name":"课表查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/jkcx.png","function_id":30000006,"unchange":0,"type_name":"测试1","function_name":"监考查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/cjcx.png","function_id":20150106,"unchange":0,"type_name":"测试1","function_name":"成绩查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/oabg.png","function_id":30000101,"unchange":0,"type_name":"测试1","function_name":"公文处理","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/xysc.png","function_id":20150127,"unchange":0,"type_name":"测试1","function_name":"校园风光","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/bysh.png","function_id":30000003,"unchange":0,"type_name":"测试1","function_name":"毕业审核","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/zslx.png","function_id":20150123,"unchange":0,"type_name":"测试1","function_name":"掌上离校","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/kscx.png","function_id":30000005,"unchange":0,"type_name":"测试1","function_name":"考试查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/xysj.png","function_id":20150112,"unchange":0,"type_name":"测试1","function_name":"校园实景","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/gzjf.png","function_id":20150113,"unchange":0,"type_name":"测试1","function_name":"财务查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/xysc.png","function_id":20160227,"unchange":0,"type_name":"测试1","function_name":"会议现场","type_id":1}]},{"name":"测试2","list":[{"function_face":"http://app.cqut.edu.cn/content/image/zhkt.png","function_id":20150116,"unchange":0,"type_name":"测试2","function_name":"智慧课堂","type_id":2},{"function_face":"http://app.cqut.edu.cn/content/image/wjdc.png","function_id":20150115,"unchange":0,"type_name":"测试2","function_name":"问卷调查","type_id":2},{"function_face":"http://app.cqut.edu.cn/content/image/xwpt.png","function_id":20150114,"unchange":0,"type_name":"测试2","function_name":"学校新闻","type_id":2},{"function_face":"http://app.cqut.edu.cn/content/image/tscx.png","function_id":20150111,"unchange":0,"type_name":"测试2","function_name":"图书借阅","type_id":2},{"function_face":"http://app.cqut.edu.cn/content/image/dbsy.png","function_id":20150104,"unchange":0,"type_name":"测试2","function_name":"待办事宜","type_id":2},{"function_face":"http://app.cqut.edu.cn/content/image/zsyx.png","function_id":20150122,"unchange":0,"type_name":"测试2","function_name":"掌上迎新","type_id":2},{"function_face":"http://app.cqut.edu.cn/content/image/yxtj.png","function_id":30000103,"unchange":0,"type_name":"测试2","function_name":"迎新统计","type_id":2},{"function_face":"http://app.cqut.edu.cn/content/image/xmzs.png","function_id":20150126,"unchange":0,"type_name":"测试2","function_name":"校貌展示","type_id":2}]},{"name":"测试3","list":[{"function_face":"http://app.cqut.edu.cn/content/image/xysc.png","function_id":20150110,"unchange":0,"type_name":"测试3","function_name":"校园拾粹","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/xndt.png","function_id":20150124,"unchange":0,"type_name":"测试3","function_name":"校内地图","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/bgdhcx.png","function_id":20150121,"unchange":1,"type_name":"测试3","function_name":"办公电话(作废）","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/xykcx.png","function_id":20160224,"unchange":0,"type_name":"测试3","function_name":"一卡通","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/bccx.png","function_id":20160222,"unchange":0,"type_name":"测试3","function_name":"学分提醒","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/zslxd.png","function_id":30000102,"unchange":0,"type_name":"测试3","function_name":"掌上离校单","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/xndt.png","function_id":20150128,"unchange":0,"type_name":"测试3","function_name":"在线报修","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/dzyj.png","function_id":30000011,"unchange":0,"type_name":"测试3","function_name":"电子邮件","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/xlrc.png","function_id":20150101,"unchange":0,"type_name":"测试3","function_name":"校历日程","type_id":3},{"function_face":"http://app.cqut.edu.cn/content/image/xygk.png","function_id":20150125,"unchange":0,"type_name":"测试3","function_name":"学校概况","type_id":3}]},{"name":"测试4","list":[{"function_face":"http://app.cqut.edu.cn/content/image/szzy.png","function_id":30000109,"unchange":0,"type_name":"测试4","function_name":"数字资源","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/xjfx.png","function_id":20150108,"unchange":0,"type_name":"测试4","function_name":"数据分析","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/wbjh.png","function_id":30000108,"unchange":0,"type_name":"测试4","function_name":"微博聚合","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/xykcx.png","function_id":40000001,"unchange":0,"type_name":"测试4","function_name":"满意了吧","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/bgdhcx.png","function_id":30000002,"unchange":0,"type_name":"测试4","function_name":"办公电话","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/tzsc.png","function_id":20150117,"unchange":0,"type_name":"测试4","function_name":"跳蚤市场","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/bccx.png","function_id":20150109,"unchange":0,"type_name":"测试4","function_name":"班车查询","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/xfjs.png","function_id":30000001,"unchange":0,"type_name":"测试4","function_name":"学分结算","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/grrz.png","function_id":20150102,"unchange":0,"type_name":"测试4","function_name":"个人日志","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/tzgg.png","function_id":20150103,"unchange":0,"type_name":"测试4","function_name":"学校通知","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/jscx.png","function_id":20150107,"unchange":0,"type_name":"测试4","function_name":"教室查询","type_id":4},{"function_face":"http://app.cqut.edu.cn/content/image/cjcx.png","function_id":20150206,"unchange":0,"type_name":"测试4","function_name":"成绩查询","type_id":4}]}]}
	 * message : 成功 code : 40001
	 */
	private ContentBean content;
	private String message;
	private String code;

	public ContentBean getContent()
	{
		return content;
	}

	public void setContent(ContentBean content)
	{
		this.content = content;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public static class ContentBean
	{
		private List<MyAppBean> my_app;
		private List<OtherAppBean> other_app;

		public List<MyAppBean> getMy_app()
		{
			return my_app;
		}

		public void setMy_app(List<MyAppBean> my_app)
		{
			this.my_app = my_app;
		}

		public List<OtherAppBean> getOther_app()
		{
			return other_app;
		}

		public void setOther_app(List<OtherAppBean> other_app)
		{
			this.other_app = other_app;
		}

		public static class MyAppBean
		{
			/**
			 * name : 我的应用 list :
			 * [{"function_face":"http://app.cqut.edu.cn/content/image/qz.png","function_id":20150120,"unchange":1,"type_name":"我的应用","function_name":"社区","type_id":0},{"function_face":"http://app.cqut.edu.cn/content/image/bgdhcx.png","function_id":20150121,"unchange":1,"type_name":"我的应用","function_name":"办公电话(作废）","type_id":0}]
			 */

			private String name;
			private List<ListBean> list;

			public String getName()
			{
				return name;
			}

			public void setName(String name)
			{
				this.name = name;
			}

			public List<ListBean> getList()
			{
				return list;
			}

			public void setList(List<ListBean> list)
			{
				this.list = list;
			}

			public static class ListBean
			{
				/**
				 * function_face : http://app.cqut.edu.cn/content/image/qz.png
				 * function_id : 20150120 unchange : 1 type_name : 我的应用
				 * function_name : 社区 type_id : 0
				 */

				private String function_face;
				private int function_id;
				private int unchange;
				private String type_name;
				private String function_name;
				private int type_id;

				public String getFunction_face()
				{
					return function_face;
				}

				public void setFunction_face(String function_face)
				{
					this.function_face = function_face;
				}

				public int getFunction_id()
				{
					return function_id;
				}

				public void setFunction_id(int function_id)
				{
					this.function_id = function_id;
				}

				public int getUnchange()
				{
					return unchange;
				}

				public void setUnchange(int unchange)
				{
					this.unchange = unchange;
				}

				public String getType_name()
				{
					return type_name;
				}

				public void setType_name(String type_name)
				{
					this.type_name = type_name;
				}

				public String getFunction_name()
				{
					return function_name;
				}

				public void setFunction_name(String function_name)
				{
					this.function_name = function_name;
				}

				public int getType_id()
				{
					return type_id;
				}

				public void setType_id(int type_id)
				{
					this.type_id = type_id;
				}
			}
		}

		public static class OtherAppBean
		{
			/**
			 * name : 测试1 list :
			 * [{"function_face":"http://app.cqut.edu.cn/content/image/wybs.png","function_id":20150119,"unchange":0,"type_name":"测试1","function_name":"我要办事","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/swzl.png","function_id":20150118,"unchange":0,"type_name":"测试1","function_name":"失物招领","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/qz.png","function_id":20150120,"unchange":1,"type_name":"测试1","function_name":"社区","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/kbcx.png","function_id":20150105,"unchange":0,"type_name":"测试1","function_name":"课表查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/jkcx.png","function_id":30000006,"unchange":0,"type_name":"测试1","function_name":"监考查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/cjcx.png","function_id":20150106,"unchange":0,"type_name":"测试1","function_name":"成绩查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/oabg.png","function_id":30000101,"unchange":0,"type_name":"测试1","function_name":"公文处理","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/xysc.png","function_id":20150127,"unchange":0,"type_name":"测试1","function_name":"校园风光","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/bysh.png","function_id":30000003,"unchange":0,"type_name":"测试1","function_name":"毕业审核","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/zslx.png","function_id":20150123,"unchange":0,"type_name":"测试1","function_name":"掌上离校","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/kscx.png","function_id":30000005,"unchange":0,"type_name":"测试1","function_name":"考试查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/xysj.png","function_id":20150112,"unchange":0,"type_name":"测试1","function_name":"校园实景","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/gzjf.png","function_id":20150113,"unchange":0,"type_name":"测试1","function_name":"财务查询","type_id":1},{"function_face":"http://app.cqut.edu.cn/content/image/xysc.png","function_id":20160227,"unchange":0,"type_name":"测试1","function_name":"会议现场","type_id":1}]
			 */

			private String name;
			private List<ListBeanX> list;

			public String getName()
			{
				return name;
			}

			public void setName(String name)
			{
				this.name = name;
			}

			public List<ListBeanX> getList()
			{
				return list;
			}

			public void setList(List<ListBeanX> list)
			{
				this.list = list;
			}

			public static class ListBeanX
			{
				/**
				 * function_face : http://app.cqut.edu.cn/content/image/wybs.png
				 * function_id : 20150119 unchange : 0 type_name : 测试1
				 * function_name : 我要办事 type_id : 1
				 */

				private String function_face;
				private int function_id;
				private int unchange;
				private String type_name;
				private String function_name;
				private int type_id;

				public String getFunction_face()
				{
					return function_face;
				}

				public void setFunction_face(String function_face)
				{
					this.function_face = function_face;
				}

				public int getFunction_id()
				{
					return function_id;
				}

				public void setFunction_id(int function_id)
				{
					this.function_id = function_id;
				}

				public int getUnchange()
				{
					return unchange;
				}

				public void setUnchange(int unchange)
				{
					this.unchange = unchange;
				}

				public String getType_name()
				{
					return type_name;
				}

				public void setType_name(String type_name)
				{
					this.type_name = type_name;
				}

				public String getFunction_name()
				{
					return function_name;
				}

				public void setFunction_name(String function_name)
				{
					this.function_name = function_name;
				}

				public int getType_id()
				{
					return type_id;
				}

				public void setType_id(int type_id)
				{
					this.type_id = type_id;
				}
			}
		}
	}
}
