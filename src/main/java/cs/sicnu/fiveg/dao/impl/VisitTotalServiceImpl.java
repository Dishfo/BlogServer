package cs.sicnu.fiveg.dao.impl;

import cs.sicnu.fiveg.dao.VisitTotalService;
import cs.sicnu.fiveg.mapper.VisitTotalMapper;
import cs.sicnu.fiveg.pojo.VisitTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class VisitTotalServiceImpl implements VisitTotalService {

    @Autowired
    private VisitTotalMapper visitTotalMapper;
    @Override
    public int  queryVisitTotal() {
        return visitTotalMapper.selectById(0);
    }

    @Override
    public int  queryVisitToday() {
        VisitTotal visitTotal=visitTotalMapper.selectByDate(new Date(System.currentTimeMillis()));
        return visitTotal==null?-1:
                (visitTotal.getVisitCount()==null?-1:visitTotal.getVisitCount());
    }

    @Override
    public int updateVisitTotal() {
        return visitTotalMapper.updateById(0);
    }

    @Override
    public int updateVisitToday() {
        return visitTotalMapper.updateByDate(new Date(System.currentTimeMillis()));
    }


}
