package org.practice.java8.para;


import com.yoong.facade.model.cls.Human;
import com.yoong.facade.model.cls.QueryData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


/**
 * @author yoong
 * <br/>
 * @version 1.0
 * <br/>
 * @description Java 8中,Function,Consumer,Predicate,Supplier举例
 * PS：函数式接口(FunctionInterface)，只允许定义一个抽象方法，所以支持lambda表达式。
 * https://my.oschina.net/0sbVMw/blog/535010
 * <br/>
 * @date 2018年5月4日
 */
public class FunctionUtils {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        // Function.apply()
        List<Human> humans = new ArrayList<Human>();
        List<QueryData> queryData = humans2QueryDatas(human2QueryDate()).apply(humans);

        Function<Human, QueryData> human2Data = (item) -> {
            QueryData data = new QueryData();
            return data;
        };
        human2Data.apply(new Human());

        // Supplier.get()
        Supplier<Human> supplier = () -> {
            return new Human();
        };
        supplier.get();

        // Consumer.accept()
        Consumer<Human> consumer = (item) -> {
            System.out.println(item.getName());
        };
        consumer.accept(new Human());

        // Predicate.test()
        Predicate<Human> predicate = (item) -> {
            return item.getAge() > 20;
        };
        predicate.test(new Human());
        boolean isAdult = predicate().test(new Human());
    }

    public static Function<List<Human>, List<QueryData>> humans2QueryDatas(Function<Human, QueryData> human2QueryDate) {
        return (lists) -> {
            List<QueryData> queryDatas = new ArrayList<QueryData>();
            queryDatas = lists.stream().map(human2QueryDate).collect(Collectors.toList());
            return queryDatas;
        };
    }

    public static Function<Human, QueryData> human2QueryDate() {
        return (item) -> {
            QueryData data = new QueryData();
            data.setRegisterNo(item.getAge() + "");
            data.setRegisterStatus(item.getName());
            return data;
        };
    }

    public static Predicate<Human> predicate() {
        return (item) -> {
            return item.getAge() > 20;
        };
    }

}
