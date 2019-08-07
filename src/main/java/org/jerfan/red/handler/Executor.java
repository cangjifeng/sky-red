package org.jerfan.red.handler;


public class Executor {

    public static void main(String[] args) {
        System.out.println("begin");
        for(int i =1000;i>=0;i--){
            final int num=i;
            Thread thread = new Thread("thread-"+i){
                @Override
                public void run() {
                    PrintHandler handler = new PrintHandler();
                    handler.printGreetWord("thread-"+num);
                }
            };
            thread.start();
        }
        System.out.println("end");

    }


}
