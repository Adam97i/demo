package 设计模式.适配器.springMVC.adapter;

public interface HandlerAdapter {
    /**
     * 原本的方法 处理请求
     */
    void handle(Object handler);

    /**
     * 新增的方法，用于判断是否支持
     */
    boolean supports(Object handler);
}
