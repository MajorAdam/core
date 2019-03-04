package com.major.springsource;

import com.major.springsource.printer.MessagePrinter;
import com.major.springsource.service.MessageService;
import com.major.springsource.service.MessageServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
@ComponentScan
public class Application {
    @Bean
    MessageService mockMessageService(){
        return new MessageService() {
            @Override
            public String getMessage() {
                return "48";
            }
        };
        }
    @Bean
    String getString(){
        return "234";
    }

//    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
//        MessagePrinter messagePrinter = applicationContext.getBean(MessagePrinter.class);
//        messagePrinter.printMessage();
//    }
    public static void main(String[] args) throws Exception{
//        Scanner scanner = new Scanner(Paths.get("C:\\Users\\vales\\Desktop\\info.log"),"UTF-8");
//        PrintWriter printWriter = new PrintWriter("C:\\Users\\vales\\Desktop\\info.log2222","UTF-8");
//        while (scanner.hasNextLine()){
//            printWriter.println(scanner.nextLine());
//        }
//        String dir = System.getProperty("user.dir");
//        System.out.println(dir);
//        int x= 8,sign;
//        int[] a = new int[]{12,3,4};
//        System.out.println(Arrays.toString(a));
//        int[] ab= {1,2,3};
//        int[] b = Arrays.copyOf(a,3);
//        System.out.println(Arrays.toString(b));
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(draw(50,4)));
//        twoDraw();
//        System.out.println(LocalDate.now());
//        LocalDate now = LocalDate.now();
//        LocalDate oneYearsLater = now.plusDays(1);
//        System.out.println(oneYearsLater.getYear()+oneYearsLater.getMonthValue()+oneYearsLater.getDayOfYear());
        printMonth();
    }

    public static int[] draw(int total,int n) {
        int[] totalArray = new int[total];
        for (int i = 0; i < total; i++) {
            totalArray[i] = i +1;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int current = ThreadLocalRandom.current().nextInt(0,total);
            result[i] = totalArray[current];
            totalArray[current] = totalArray[total-1];
            total--;
        }
        return result;
    }
    public static void twoDraw(){
       final int max = 10;
       int[][] odds = new int[max+1][];
        for (int i = 0; i <= max ; i++) {
            odds[i] = new int[i+1];
        }
        for (int i = 0; i < odds.length; i++) {
            for (int j = 0; j < odds[i].length; j++) {
                int lotteryOdds=1;
                for (int k = 1; k <=j; k++) {
                    lotteryOdds = lotteryOdds*(i-k+1)/k;
                }
                odds[i][j]=lotteryOdds;
            }

        }
        for (int[] row:odds){
            for (int odd:row)
                System.out.printf("%4d",odd);
            System.out.println();
        }
    }
    public static void printMonth(){
        LocalDate now = LocalDate.now();
        int month =now.getMonthValue();
        int today = now.getDayOfMonth();
        now = now.minusDays(today-1);
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int value = dayOfWeek.getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        while (now.getMonthValue()==month){
            if (now.getDayOfWeek().getValue()==1) System.out.println();
            System.out.printf("%3d",now.getDayOfMonth());
            if (now.getDayOfMonth()==today)
                System.out.print("*");
            else
                System.out.print(" ");
            now = now.plusDays(1);
        }
    }
}
