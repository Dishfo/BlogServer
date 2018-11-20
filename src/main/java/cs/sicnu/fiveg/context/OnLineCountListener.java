package cs.sicnu.fiveg.context;

import cs.sicnu.fiveg.dao.VisitTotalService;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnLineCountListener implements HttpSessionListener {


    VisitTotalService visitTotalService;

    private static int onLineCount=0;
    private static final Object LOCK=new Object();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        visitTotalService=(VisitTotalService) ContextLoaderListener.
                getCurrentWebApplicationContext().
                getBean("visitTotalServiceImpl");
        synchronized (LOCK){
            onLineCount++;
        }

        visitTotalService.updateVisitTotal();
        visitTotalService.updateVisitToday();

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        synchronized (LOCK){
            onLineCount--;
        }
    }


    public static int getOnLineCount() {
        synchronized (LOCK){
            return onLineCount;
        }
    }

}
