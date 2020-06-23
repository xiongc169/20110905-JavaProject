package org.practice.designPattern.behavior.ch16iterator;

import org.practice.designPattern.behavior.ch16iterator.runoob.Iterator;
import org.practice.designPattern.behavior.ch16iterator.runoob.NameRepository;

/**
 * @Desc 迭代器模式
 * http://www.runoob.com/design-pattern/iterator-pattern.html
 * <p>
 * @Author yoong
 * <p>
 * @Date 2012年7月4日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            iterator_runoob();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void iterator_runoob() {
        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
