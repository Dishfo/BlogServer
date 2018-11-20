package cs.sicnu.fiveg.context;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class WebApplicationInitializer  implements InitializingBean,ServletContextAware {

   @Autowired
   VisitRecordInitor visitRecordInitor;


    @Override
    public void afterPropertiesSet() throws Exception {
        visitRecordInitor.initVisitTotal();
        visitRecordInitor.initVisitToday();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {

    }
}
