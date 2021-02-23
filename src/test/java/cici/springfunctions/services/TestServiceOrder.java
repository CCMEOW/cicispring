package cici.springfunctions.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * @Description TODO
 */
@ContextConfiguration("classpath:applicationContext.xml")
public class TestServiceOrder extends AbstractTestNGSpringContextTests {

    @Autowired
    private OrderService orderService;

    @org.testng.annotations.Test
    public void testTest1() {
        orderService.test(5);
    }
}