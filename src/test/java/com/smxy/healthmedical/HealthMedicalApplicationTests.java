package com.smxy.healthmedical;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Principal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthMedicalApplicationTests {
    private final int balance;
    private static int deposit = (int) (Math.random()*100);
    private static final HealthMedicalApplicationTests c = new HealthMedicalApplicationTests();
    public HealthMedicalApplicationTests(){
        System.out.println("deposit:" + deposit);
        balance = deposit - 10;
    }
    @Test
    public static void main(String[] args) {
        System.out.println( "静态变量：" + HealthMedicalApplicationTests.deposit);
        System.out.println("账户余额：" + c.balance);
    }
}
