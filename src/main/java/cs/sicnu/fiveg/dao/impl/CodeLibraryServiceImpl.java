package cs.sicnu.fiveg.dao.impl;

import cs.sicnu.fiveg.dao.CodeLibraryService;
import cs.sicnu.fiveg.mapper.CodeLibraryMapper;
import cs.sicnu.fiveg.pojo.CodeLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther Ming []
 * @Date 2018/6/27  10:32
 */
@Service
public class CodeLibraryServiceImpl implements CodeLibraryService {

    @Autowired
    private CodeLibraryMapper codeLibraryMapper;

    @Override
    public int queryCodeTotalCount(CodeLibrary cVo) {
        return codeLibraryMapper.selectBlogCount(cVo);
    }

    @Override
    public List<CodeLibrary> queryCodeLibraryPerPage(CodeLibrary cVo, int pageSize, int pageNo) {
        return codeLibraryMapper.selectByPage(cVo,pageSize,(pageNo-1)*pageSize);
    }

    @Override
    public CodeLibrary queryPerCodeById(int codeId) {
       CodeLibrary codeLibrary = new CodeLibrary();
       codeLibrary.setCodeId(codeId);
       List<CodeLibrary> libraries=codeLibraryMapper.selectByInfo(codeLibrary);
       return  libraries==null||libraries.size()==0?null:libraries.get(0);

    }

    @Override
    public int insertCodeLibrary(CodeLibrary cVo) {
        return codeLibraryMapper.insert(cVo);
    }

    @Override
    public int updateCodeReadById(int codeId) {
      return   this.codeLibraryMapper.updateReadById(codeId);
    }

    @Override
    public int updateCodeById(CodeLibrary cVo) {
        return codeLibraryMapper.updateById(cVo);
    }

    //TODO 记得重新实现
    @Override
    public int logicDeleteCodeById(int codeId) {
        CodeLibrary codeLibrary=new CodeLibrary();
        codeLibrary.setCodeId(codeId);
        codeLibrary.setCodeDelete(1);
        return codeLibraryMapper.updateById(codeLibrary);
    }

    @Override
    public CodeLibrary queryPreviousCode(int codeId) {
        return codeLibraryMapper.selectPrevCode(codeId);
    }

    @Override
    public CodeLibrary queryNextCode(int codeId) {
        return  codeLibraryMapper.selectNextCode(codeId);
    }
}
