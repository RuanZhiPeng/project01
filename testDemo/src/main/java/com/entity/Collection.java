package com.entity;

/**
 * 藏品信息，Javabean
 * @author Ruan
 *封装藏品的属性
 */
public class Collection {
		private int id;
		private String 主键;
	    private String 质地类别2;
	    private String 质地类别1;
	    private String 藏品描述;
	    private String 总登号;
	    private String 鉴定意见;
	    private String 质地;
	    private String 总登记号;
	    private String 藏品分类;
	    private String 中文名;
	    private String 是否删除;
	    private String 分登号;
	    private String 原名;
	    private String 藏品类别;
	    private String 藏品级别;
	    private String 历次鉴定意见;
	    private int 部门ID;
	    private String 质量范围;
	    private String 藏品类型;
	    private String 完残程度;
	    private String 库存状态;
	    private int 实际数量;
	    private String 登记人;
	    private String 年代;
	    private String 藏品来源;
	    
	    
	 
		@Override
		public String toString() {
			return "Collection [id=" + id + ", 主键=" + 主键 + ", 质地类别2=" + 质地类别2 + ", 质地类别1=" + 质地类别1 + ", 藏品描述=" + 藏品描述
					+ ", 总登号=" + 总登号 + ", 鉴定意见=" + 鉴定意见 + ", 质地=" + 质地 + ", 总登记号=" + 总登记号 + ", 藏品分类=" + 藏品分类 + ", 中文名="
					+ 中文名 + ", 是否删除=" + 是否删除 + ", 分登号=" + 分登号 + ", 原名=" + 原名 + ", 藏品类别=" + 藏品类别 + ", 藏品级别=" + 藏品级别
					+ ", 历次鉴定意见=" + 历次鉴定意见 + ", 部门ID=" + 部门ID + ", 质量范围=" + 质量范围 + ", 藏品类型=" + 藏品类型 + ", 完残程度=" + 完残程度
					+ ", 库存状态=" + 库存状态 + ", 实际数量=" + 实际数量 + ", 登记人=" + 登记人 + ", 年代=" + 年代 + ", 藏品来源=" + 藏品来源 + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String get主键() {
			return 主键;
		}
		public void set主键(String 主键) {
			this.主键 = 主键;
		}
		public void set质地类别2(String 质地类别2) {
	         this.质地类别2 = 质地类别2;
	     }
	     public String get质地类别2() {
	         return 质地类别2;
	     }

	    public void set质地类别1(String 质地类别1) {
	         this.质地类别1 = 质地类别1;
	     }
	     public String get质地类别1() {
	         return 质地类别1;
	     }

	    public void set藏品描述(String 藏品描述) {
	         this.藏品描述 = 藏品描述;
	     }
	     public String get藏品描述() {
	         return 藏品描述;
	     }

	    public void set总登号(String 总登号) {
	         this.总登号 = 总登号;
	     }
	     public String get总登号() {
	         return 总登号;
	     }

	    public void set鉴定意见(String 鉴定意见) {
	         this.鉴定意见 = 鉴定意见;
	     }
	     public String get鉴定意见() {
	         return 鉴定意见;
	     }

	    public void set质地(String 质地) {
	         this.质地 = 质地;
	     }
	     public String get质地() {
	         return 质地;
	     }

	    public void set总登记号(String 总登记号) {
	         this.总登记号 = 总登记号;
	     }
	     public String get总登记号() {
	         return 总登记号;
	     }

	    public void set藏品分类(String 藏品分类) {
	         this.藏品分类 = 藏品分类;
	     }
	     public String get藏品分类() {
	         return 藏品分类;
	     }

	    public void set中文名(String 中文名) {
	         this.中文名 = 中文名;
	     }
	     public String get中文名() {
	         return 中文名;
	     }

	    public void set是否删除(String 是否删除) {
	         this.是否删除 = 是否删除;
	     }
	     public String get是否删除() {
	         return 是否删除;
	     }

	    public void set分登号(String 分登号) {
	         this.分登号 = 分登号;
	     }
	     public String get分登号() {
	         return 分登号;
	     }

	    public void set原名(String 原名) {
	         this.原名 = 原名;
	     }
	     public String get原名() {
	         return 原名;
	     }

	    public void set藏品类别(String 藏品类别) {
	         this.藏品类别 = 藏品类别;
	     }
	     public String get藏品类别() {
	         return 藏品类别;
	     }

	    public void set藏品级别(String 藏品级别) {
	         this.藏品级别 = 藏品级别;
	     }
	     public String get藏品级别() {
	         return 藏品级别;
	     }

	    public void set历次鉴定意见(String 历次鉴定意见) {
	         this.历次鉴定意见 = 历次鉴定意见;
	     }
	     public String get历次鉴定意见() {
	         return 历次鉴定意见;
	     }

	    public void set部门ID(int 部门ID) {
	         this.部门ID = 部门ID;
	     }
	     public int get部门ID() {
	         return 部门ID;
	     }

	    public void set质量范围(String 质量范围) {
	         this.质量范围 = 质量范围;
	     }
	     public String get质量范围() {
	         return 质量范围;
	     }

	    public void set藏品类型(String 藏品类型) {
	         this.藏品类型 = 藏品类型;
	     }
	     public String get藏品类型() {
	         return 藏品类型;
	     }

	    public void set完残程度(String 完残程度) {
	         this.完残程度 = 完残程度;
	     }
	     public String get完残程度() {
	         return 完残程度;
	     }

	    public void set库存状态(String 库存状态) {
	         this.库存状态 = 库存状态;
	     }
	     public String get库存状态() {
	         return 库存状态;
	     }

	    public void set实际数量(int 实际数量) {
	         this.实际数量 = 实际数量;
	     }
	     public int get实际数量() {
	         return 实际数量;
	     }

	    public void set登记人(String 登记人) {
	         this.登记人 = 登记人;
	     }
	     public String get登记人() {
	         return 登记人;
	     }

	    public void set年代(String 年代) {
	         this.年代 = 年代;
	     }
	     public String get年代() {
	         return 年代;
	     }

	    public void set藏品来源(String 藏品来源) {
	         this.藏品来源 = 藏品来源;
	     }
	     public String get藏品来源() {
	         return 藏品来源;
	     }

	}
	


