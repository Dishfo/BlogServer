package cs.sicnu.fiveg.mapper;

import cs.sicnu.fiveg.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated
     */
    int insert(UserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated
     */
    List<UserInfo> selectAll();


    /**
     * 根据用户名查询密码
     * @return
     * @param userName
     */
    String selectPwdByName(String userName);


    UserInfo selectByName(@Param("username") String userName);

    int selectByInfoCount(UserInfo userInfo);

    List<UserInfo> selectByInfoPaged(@Param("startp") int startp,
                                     @Param("size") int size);

    int updateUserEmailByName(UserInfo uVo);

    int updatePwdByName(UserInfo uVo);

    int updateUserByID(UserInfo uVo);

    int updateUserPwdByNameAndEmail(UserInfo uVo);
}