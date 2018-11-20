package cs.sicnu.fiveg.dao.impl;

import cs.sicnu.fiveg.dao.UserInfoService;
import cs.sicnu.fiveg.mapper.UserInfoMapper;
import cs.sicnu.fiveg.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public int insertUserInfo(UserInfo UserInfo) {

        return userInfoMapper.insert(UserInfo);
    }

    @Override
    public int updateUserInfoById(UserInfo uVo) {

        return userInfoMapper.updateUserByID(uVo);
    }

    @Override
    public int updateUserPwdByName(UserInfo uVo) {
        return userInfoMapper.updatePwdByName(uVo);
    }

    @Override
    public int updateUserPwdByNameAndEmail(UserInfo uVo) {

        return userInfoMapper.updateUserPwdByNameAndEmail(uVo);
    }

    @Override
    public int updateUserEmailByName(UserInfo uVo) {

        return userInfoMapper.updateUserEmailByName(uVo);
    }

    @Override
    public String queryPasswordByUserName(String userName) {
        return userInfoMapper.selectPwdByName(userName);
    }

    @Override
    public UserInfo queryUserInfoByName(String userName) {

        return userInfoMapper.selectByName(userName);
    }

    @Override
    public int queryUserTotalCount(UserInfo uVo) {
        return userInfoMapper.selectByInfoCount(uVo);
    }

    @Override
    public List<UserInfo> queryUserPerPage(UserInfo uVo, int pageSize, int pageNo) {
        return userInfoMapper.selectByInfoPaged(pageSize,pageNo);
    }
}
