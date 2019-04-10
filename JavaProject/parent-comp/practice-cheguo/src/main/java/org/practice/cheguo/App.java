package org.practice.cheguo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.practice.cheguo.model.Human;
import org.practice.cheguo.utils.CommonUtils;

/**
 * @author yoong
 */
public class App {
    public static void main(String[] args) {

        try {
            streamSort();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 脱敏
     */
    public static void tuomin() {
        String phone = "18668161992";
        String idCard = "342501199111122014";
        String bankCardNo1 = "6226621702371731";
        String bankCardNo = "6228481990677155518";

        String resultPhone = CommonUtils.encode(phone, 1);
        String resultId = CommonUtils.encode(idCard, 2);
        String resultBankCard = CommonUtils.encode(bankCardNo1, 3);

        System.out.println(resultPhone);
        System.out.println(resultId);
        System.out.println(resultBankCard);
    }

    /**
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

}
