package 设计模式.适配器.springMVC.controller;

import 设计模式.适配器.springMVC.controller.Controller;

public class SimpleController implements Controller {
    public void doSimplerHandler() {
        System.out.println("simple...");
    }
}
