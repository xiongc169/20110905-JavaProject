package org.practice.primary.utility;

import java.util.ArrayList;
import java.util.List;

import org.practice.primary.domain.Dictionary;


/**
 * Java中的深拷贝(深复制)和浅拷贝(浅复制)
 * 
 * @author Administrator
 * @since 2015-09-30 08:57:31
 */
public class DeepClone {
	/**
	 * http://www.jb51.net/article/62909.htm
	 * http://rogerfederer.iteye.com/blog/1748752
	 */
	public static void deepclone() {
		List<Dictionary> dictlist = new ArrayList<Dictionary>();
		Dictionary dict = new Dictionary("no001", "name001");
		Dictionary dict2 = new Dictionary("no002", "name002");
		dictlist.add(dict);
		dictlist.add(dict2);
		// System.out.println(dict.getDictionaryNo() + dict.getName());
		// Dictionary dict3 = (Dictionary) dict.clone();
		// dict3.setDictionaryNo("no003");
		// dict3.setName("name003");
		// System.out.println(dict.getDictionaryNo() + dict.getName());
		// System.out.println(dict3.getDictionaryNo() + dict3.getName());
		List<Dictionary> dictlist2 = new ArrayList<Dictionary>();
		for (Dictionary item : dictlist) {
			Dictionary newitem = (Dictionary) item.clone();
			dictlist2.add(newitem);
		}

		dictlist2.get(0).setDictionaryNo("list2-no001");
		System.out.println(dict.getDictionaryNo() + dict.getName());
		List<Dictionary> dictlist3 = dictlist;
		dictlist3.get(0).setDictionaryNo("list3-no001");
		System.out.println(dict.getDictionaryNo() + dict.getName());
	}
}
