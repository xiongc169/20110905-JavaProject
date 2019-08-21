package org.dubbo.consumer;

import com.chesheng.decision.api.IDeipPrefixFacade;
import com.chesheng.decision.request.OrderQueryRequest;
import com.chesheng.decision.response.OrderQueryResponse;
import org.dubbo.common.service.CalculatorService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 */
public class Consumer {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
            localTest();
            deipTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void localTest() {
        FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(new String[]{"classpath:consumer.xml"});
        CalculatorService calculator = (CalculatorService) fsContext.getBean("advancedCalculatorService");//calculatorService、advancedCalculatorService
        double result = calculator.add(100, 200);
        double result1 = calculator.sub(100, 200);
        double result2 = calculator.mul(100, 200);
        double result3 = calculator.div(100, 200);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    public static void deipTest() {
        FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(new String[]{"classpath:consumer.xml"});
        IDeipPrefixFacade deipFacade = (IDeipPrefixFacade) fsContext.getBean("deipFacade");//calculatorService、advancedCalculatorService
        OrderQueryRequest request = new OrderQueryRequest();
        request.setAppId("cls");
        request.setOrderNo("706328");
        request.setBizType(1);
        OrderQueryResponse response = deipFacade.getNewestByOrderNo(request);
        System.out.println(response.getData());
    }
}
