package 设计模式.适配器.springMVC.adapter;

import 设计模式.适配器.springMVC.controller.HttpController;

public class HttpHandlerAdapter implements HandlerAdapter {
    @Override
    public void handle(Object handler) {
        ((HttpController) handler).doHttpHandler();
    }

    @Override
    public boolean supports(Object handler) {
        return handler instanceof HttpController;
    }
}
