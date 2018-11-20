package cs.sicnu.fiveg.dao;

import cs.sicnu.fiveg.pojo.CodeLibrary;

import java.util.List;

/**
 * @author 石旭辉
 * <p>
 * 2017年9月28日
 */
public interface CodeLibraryService {
    /**
     * 根据条件查询代码库数量
     *
     * @param cVo
     * @return
     */
    int queryCodeTotalCount(CodeLibrary cVo);

    /**
     * 根据条件查询某一页的代码库
     *
     * @param cVo
     * @param pageSize
     * @param pageNo
     * @return
     */
    List<CodeLibrary> queryCodeLibraryPerPage(CodeLibrary cVo, int pageSize, int pageNo);

    /**
     * 根据Id查询单独一处代码
     *
     * @param codeId
     * @return
     */
    CodeLibrary queryPerCodeById(int codeId);

    /**
     * 插入新纪录到代码库，返回id
     *
     * @param cVo
     * @return
     */
    int insertCodeLibrary(CodeLibrary cVo);

    /**
     * 根据id更新代码库代码阅读次数
     *
     * @param codeId
     * @return
     */
    int updateCodeReadById(int codeId);

    /**
     * 根据id修改代码内容
     *
     * @param cVo
     * @return
     */
    int updateCodeById(CodeLibrary cVo);

    /**
     * 根据id逻辑删除代码
     *
     * @param blogId
     * @return
     */
    int logicDeleteCodeById(int blogId);

    /**
     * 根据id查找上一篇有效代码
     *
     * @param codeId
     * @return
     */
    CodeLibrary queryPreviousCode(int codeId);

    /**
     * 根据id查找下一篇有效代码
     *
     * @param codeId
     * @return
     */
    CodeLibrary queryNextCode(int codeId);
}