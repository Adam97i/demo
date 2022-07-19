package 设计模式.适配器.springMVC.adapter;

import 设计模式.适配器.springMVC.adapter.HandlerAdapter;
import 设计模式.适配器.springMVC.controller.SimpleController;

public class SimpleHandlerAdapter implements HandlerAdapter {
    /**
     * 调用Controller原来的方法
     */
    @Override
    public void handle(Object handler) {
        ((SimpleController) handler).doSimplerHandler();
    }

    /**
     * 新增的方法
     */
    @Override
    public boolean supports(Object handler) {
        return handler instanceof SimpleController;
    }
}
