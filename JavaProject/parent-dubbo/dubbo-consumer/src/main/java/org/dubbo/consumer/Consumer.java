package org.dubbo.consumer;

import com.chesheng.decision.api.IDeipPrefixFacade;
import com.fcts.open.api.mq.yuntu.decision.OrderQueryReq;
import com.fcts.open.api.mq.yuntu.result.OrderBaseResp;
import org.dubbo.common.facade.CalculatorService;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Desc Consumer
 * <p>
 * @Author yoong
 * <p>
 * @Date 2017-4-1
 * <p>
 * @Version 1.0
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
        CalculatorService calculator = (CalculatorService) fsContext.getBean("calculatorService");
        double result = calculator.add(100, 200);
        double result1 = calculator.sub(100, 200);
        double result2 = calculator.mul(100, 200);
        double result3 = calculator.div(100, 200);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        CalculatorService advancedCalculator = (CalculatorService) fsContext.getBean("advancedCalculatorService");
        double result21 = advancedCalculator.add(100, 200);
        double result22 = advancedCalculator.sub(100, 200);
        double result23 = advancedCalculator.mul(100, 200);
        double result24 = advancedCalculator.div(100, 200);
        System.out.println(result21);
        System.out.println(result22);
        System.out.println(result23);
        System.out.println(result24);
    }

    public static void deipTest() {
        FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(new String[]{"classpath:consumer.xml"});
        IDeipPrefixFacade deipFacade = (IDeipPrefixFacade) fsContext.getBean("deipFacade");//calculatorService、advancedCalculatorService
        OrderQueryReq request = new OrderQueryReq();
        request.setAppId("cls");
        request.setOrderNo("61733");
        request.setBizType(2);
        OrderBaseResp response = deipFacade.getNewestByOrderNo(request);
        System.out.println(response.getData());
    }
}
