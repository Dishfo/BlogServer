package cs.sicnu.fiveg.mapper;

import cs.sicnu.fiveg.pojo.CodeLibrary;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CodeLibraryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_library
     *
     * @mbg.generated
     */
    int insert(CodeLibrary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code_library
     *
     * @mbg.generated
     */
    List<CodeLibrary> selectAll();

    int selectBlogCount(CodeLibrary library);

    int updateById(CodeLibrary library);



    CodeLibrary selectPrevCode(@Param("id") int codeId);

    CodeLibrary selectNextCode(@Param("id") int codeId);

    List<CodeLibrary> selectByPage(@Param("codelib") CodeLibrary cVo,
                                   @Param("size") int pageSize,
                                   @Param("pageof") int pageOf);

    List<CodeLibrary> selectByInfo(CodeLibrary codeLibrary);

    int updateReadById(@Param("id") int  codeId);
}