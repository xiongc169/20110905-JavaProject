package org.practice.activemq.book01.ch04;

/**
 * @Desc StockPortfolioApp
 * <p>
 * @Author yoong
 * <p>
 * @Date 2019/1/31 14:19
 * <p>
 * @Version 1.0
 */
public class StockPortfolioApp {

    /**
     * 入口函数
     */
    public static void main(String[] args) {
        try {
//            if (args.length == 0) {
//                System.err.println("Please define a connection URI!");
//                return;
//            }
//            Publisher publisher = new Publisher(args[0]);
//            String[] topics = new String[args.length - 1];
//            System.arraycopy(args, 1, topics, 0, args.length - 1);
//            while (total < 1000) {
//                for (int i = 0; i < count; i++) {
//                    publisher.sendMessage(topics);
//                }
//                total += count;
//                System.out.println(
//                        "Published '" + count + "' of '"
//                                + total + "' price messages"
//                );
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException x) {
//                }
//            }
//            publisher.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
