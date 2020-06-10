package org.practice.primary.community.domain;

import java.util.List;

import lombok.Data;
import org.practice.primary.community.enums.DictionaryType;

/**
 * @Desc Dictionary
 * <p>
 * @Author yoong
 * <p>
 * @Date 2015/5/25 16:49
 * <p>
 * @Version 1.0
 */
@Data
public class Dictionary implements Cloneable {
    protected String id;
    protected String dictionaryNo;
    protected String name;
    protected Integer dictionaryOrder;
    protected String pyjp;
    protected String des;
    protected String dictionaryValue;
    protected DictionaryType dictionaryType;
    protected Dictionary parent;
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

    public int hashCode() {
        return dictionaryNo.hashCode() * name.hashCode();
    }
}
