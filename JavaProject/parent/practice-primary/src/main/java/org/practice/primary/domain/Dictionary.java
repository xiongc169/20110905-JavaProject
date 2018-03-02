package org.practice.primary.domain;

import java.util.List;

public class Dictionary implements Cloneable {
	/**
	 * Id
	 */
	protected String id;

	/**
	 * 编号
	 */
	protected String dictionaryNo;

	/**
	 * 名称
	 */
	protected String name;

	/**
	 * 排序号
	 */
	protected Integer dictionaryOrder;

	/**
	 * 拼音简拼
	 */
	protected String pyjp;

	/**
	 * 描述
	 */
	protected String des;

	/**
	 * 值
	 */
	protected String dictionaryValue;

	/**
	 * 类型
	 */
	protected DictionaryType dictionaryType;

	/**
	 * 父亲
	 */
	protected Dictionary parent;

	/**
	 * 孩子
	 */
	protected List<Dictionary> childs;

	public Dictionary() {
	}

	public Dictionary(String dictno, String name) {
		this.dictionaryNo = dictno;
		this.name = name;
	}

	public Object clone() {
		Object o = null;
		try {
			o = (Dictionary) super.clone();// Object 中的clone()识别出你要复制的是哪一个对象。
		} catch (CloneNotSupportedException e) {
			System.out.println(e.toString());
		}
		return o;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Dictionary) {
			Dictionary dic = (Dictionary) obj;
			if (dic.dictionaryNo == this.dictionaryNo && dic.name == this.name)
				return true;
		}
		return false;
	}

//	public int hashCode() {
//		return dictionaryNo.hashCode() * name.hashCode();
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDictionaryNo() {
		return dictionaryNo;
	}

	public void setDictionaryNo(String dictionaryNo) {
		this.dictionaryNo = dictionaryNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDictionaryOrder() {
		return dictionaryOrder;
	}

	public void setDictionaryOrder(Integer dictionaryOrder) {
		this.dictionaryOrder = dictionaryOrder;
	}

	public String getPyjp() {
		return pyjp;
	}

	public void setPyjp(String pyjp) {
		this.pyjp = pyjp;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getDictionaryValue() {
		return dictionaryValue;
	}

	public void setDictionaryValue(String dictionaryValue) {
		this.dictionaryValue = dictionaryValue;
	}

	public DictionaryType getDictionaryType() {
		return dictionaryType;
	}

	public void setDictionaryType(DictionaryType dictionaryType) {
		this.dictionaryType = dictionaryType;
	}

	public Dictionary getParent() {
		return parent;
	}

	public void setParent(Dictionary parent) {
		this.parent = parent;
	}

	public List<Dictionary> getChilds() {
		return childs;
	}

	public void setChilds(List<Dictionary> childs) {
		this.childs = childs;
	}
}
