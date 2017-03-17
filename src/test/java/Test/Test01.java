package Test;

import java.net.InetAddress;

/**
 * Created by Administrator on 2016/8/10.
 */
public class Test01 {

    /**
     * 多线程测试
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread() { // 断点0
            @Override
            public void run() {
                System.out.println("1"); // 断点1
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2"); // 断点2
            }
        }.start();
        // 外线程
        System.out.println("3"); // 断点3
        Thread.sleep(2000);
        System.out.println("4"); // 断点4


        InetAddress a;
        try {
            a = InetAddress.getLocalHost();
            System.out.println("主机名称: " + a.getHostName());
        } catch (Exception e) {
            e.printStackTrace();
        }


        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }



}
