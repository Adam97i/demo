package 设计模式.适配器.springMVC.controller;

import 设计模式.适配器.springMVC.controller.Controller;

public class HttpController implements Controller {
    public void doHttpHandler() {
        System.out.println("http...");
    }
}
