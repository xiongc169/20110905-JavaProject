package org.dubbo.consumer;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.chesheng.decision.api.IDeipPrefixFacade;
import com.fcts.open.api.mq.yuntu.decision.OrderQueryReq;
import com.fcts.open.api.mq.yuntu.result.OrderBaseResp;
import com.ftcs.share.result.Result;
import com.ftcs.venus.dubbo.EstageCommonService;
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
            genericInvoke();

            //deipTest();
            //estageTest();
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

    /**
     * 泛化调用
     * https://dubbo.apache.org/zh/docs/v2.7/user/examples/generic-reference/
     * 上下文信息
     * https://dubbo.apache.org/zh/docs/v2.7/user/examples/context/
     * 隐式参数
     * https://dubbo.apache.org/zh/docs/v2.7/user/examples/attachment/
     */
    public static void genericInvoke() {
        FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(new String[]{"classpath:consumer.xml"});
        GenericService genericService = (GenericService) fsContext.getBean("calculatorService");
        Object result = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"World"});
        System.out.println(result);

        RpcContext rpcContext = RpcContext.getContext();
        String index = rpcContext.getAttachment("index");
        System.out.println(index);
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

    public static void estageTest() {
        FileSystemXmlApplicationContext fsContext = new FileSystemXmlApplicationContext(new String[]{"classpath:consumer.xml"});
        EstageCommonService estageCommon = (EstageCommonService) fsContext.getBean("estageCommon");//calculatorService、advancedCalculatorService
        Result response = estageCommon.applyLoan(986l, 5l);
        System.out.println(response.isSuccess());
    }
}
