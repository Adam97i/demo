package 设计模式.适配器.springMVC;

import 设计模式.适配器.springMVC.adapter.HandlerAdapter;
import 设计模式.适配器.springMVC.adapter.HttpHandlerAdapter;
import 设计模式.适配器.springMVC.adapter.SimpleHandlerAdapter;
import 设计模式.适配器.springMVC.controller.Controller;
import 设计模式.适配器.springMVC.controller.SimpleController;

import java.util.ArrayList;
import java.util.List;

public class DispatchServlet {

    public static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    public DispatchServlet(){
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
    }

    public void doDispatch(){

        // 根据controller匹配到一个适配器
        SimpleController controller = new SimpleController();
        HandlerAdapter adapter = getHandler(controller);

        //通过适配器执行对应的controller对应方法
        adapter.handle(controller);

    }

    /**
     * 不用适配器模式则需要大量if-else
     */
    public void doDispatchOld(String controller){
        if("simpleController".equals(controller)){
            // doSimplerHandler
        } else if ("HTTPController".equals(controller)) {
            // doHttpHandler
        }
    }

    public HandlerAdapter getHandler(Controller controller){
        for(HandlerAdapter adapter: handlerAdapters){
            if(adapter.supports(controller)){
                return adapter;
            }
        }
        return null;
    }
}