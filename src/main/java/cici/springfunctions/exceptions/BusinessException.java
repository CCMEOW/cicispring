package cici.springfunctions.exceptions;

/**
 * @author pengjiaqi
 * @date 2021/2/23
 * @description TODO
 */
public class BusinessException extends RuntimeException{
    String msg;

    public String getMsg() {
        return msg;
    }

    public BusinessException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
