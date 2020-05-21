package org.practice.cheguo;

import com.yoong.facade.cls.model.Human;
import org.practice.cheguo.api.request.CreateTemplateReq;

import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc App
 * <p>
 * @Author yoong
 * <p>
 * @Date 2018年1月15日
 * <p>
 * @Version 1.0
 */
public class App {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            streamSort();
            validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * JAVA8-用lamda表达式和增强版Comparator进行排序
     * https://blog.csdn.net/gao1440156051/article/details/71126194
     */
    public static void streamSort() {
        Date now = new Date();
        List<Human> humans = new ArrayList<>();
        humans.add(new Human("Sarah", 10, new Date()));
        humans.add(new Human("Jack", 12, new Date()));
        humans.add(new Human("Tomy", 11, new Date()));
        humans.add(new Human("Tomy", 11, new Date()));

//		Collections.sort(humans, Comparator.comparing(Human::getCreateDate));
//		humans = humans.stream().sorted(Comparator.comparing(Human::getCreateDate)).collect(Collectors.toList());
//		humans = humans.stream().sorted(Comparator.comparing(Human::getCreateDate).reversed()).collect(Collectors.toList());
//		Human theOne = humans.stream().sorted(Comparator.comparing(Human::getCreateDate).reversed()).findFirst().get();
//		Human theOne2 = humans.stream().sorted(Comparator.comparing(Human::getCreateDate).reversed()).findFirst().orElse(null);
        int size = humans.size();

        List<Human> distinctHumans = humans.stream().distinct().collect(Collectors.toList());
        int size2 = distinctHumans.size();
        distinctHumans.forEach(item -> {
            System.out.println(item.getName() + " - " + item.getAge() + " - " + item.getCreateDate());
        });
        System.out.println(size2);
    }

    public static void validate() {
        try {
            //Validator validator=new SpringValidatorAdapter;
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            CreateTemplateReq req = new CreateTemplateReq();
            req.setContractName("contractName");
            validator.validate(req, CreateTemplateReq.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
