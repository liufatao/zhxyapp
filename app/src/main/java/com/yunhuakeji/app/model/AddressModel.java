package com.yunhuakeji.app.model;


import com.yunhuakeji.app.util.PinyinUtil;

public class AddressModel implements Comparable<AddressModel>{

	private String name;
	private String pinyin;
	
	
	public AddressModel(String name) {
		super();
		this.name = name;
		this.pinyin = PinyinUtil.getPinyin(name);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPinyin() {
		return pinyin;
	}
	
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	@Override
	public int compareTo(AddressModel another) {
		return pinyin.compareTo(another.pinyin);
	}

}
