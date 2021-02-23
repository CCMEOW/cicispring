package cici.springfunctions.services;

import cici.springfunctions.exceptions.ApplicationException;
import cici.springfunctions.exceptions.BusinessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 */
@Service
public class OrderService {
    @Retryable(value = BusinessException.class, maxAttempts = 3, backoff = @Backoff(delay = 200L, multiplier = 2))
    public void test(Integer num) {
        System.out.println("test");
        throw new BusinessException("oops!");
    }

    @Recover
    public void recover(ApplicationException ex, Integer num) {
        System.out.println("recover: " + ex.getMessage() + " num: " + num);
    }
}
