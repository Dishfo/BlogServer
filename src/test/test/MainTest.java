package test;

import cs.sicnu.fiveg.context.VisitRecordInitor;
import cs.sicnu.fiveg.dao.BlogDetailsService;
import cs.sicnu.fiveg.dao.ReleaseFeatureService;
import cs.sicnu.fiveg.dao.VisitTotalService;
import cs.sicnu.fiveg.mapper.CodeLibraryMapper;
import cs.sicnu.fiveg.pojo.BlogDetails;
import cs.sicnu.fiveg.pojo.CodeLibrary;
import cs.sicnu.fiveg.util.MailHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-service.xml",
        "classpath:spring/spring-mybatis.xml"})
public class MainTest {

    @Autowired
    CodeLibraryMapper mapper;

    @Test
    public void test(){
        CodeLibrary pre=mapper.selectPrevCode(5);
        CodeLibrary next=mapper.selectNextCode(5);
    }
}
