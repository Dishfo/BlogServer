package cs.sicnu.fiveg.context;

import cs.sicnu.fiveg.mapper.VisitTotalMapper;
import cs.sicnu.fiveg.pojo.VisitTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public final class VisitRecordInitor  {
    @Autowired
    VisitTotalMapper visitTotalMapper;

    public void initVisitTotal(){
        VisitTotal visitTotal=visitTotalMapper.select(0);
        if(visitTotal==null){
            visitTotal=new VisitTotal();
            visitTotal.setVisitId(0);
            visitTotal.setVisitCount(0);
            visitTotalMapper.insert(visitTotal);
        }
    }

    public void initVisitToday(){
        Date today=new Date(System.currentTimeMillis());
        VisitTotal visitTotal=visitTotalMapper.selectByDate(today);
        if(visitTotal==null){
            visitTotal=new VisitTotal();
            visitTotal.setVisitCount(0);
            visitTotal.setVisitDate(today);
            visitTotalMapper.insert(visitTotal);
        }
    }


}
