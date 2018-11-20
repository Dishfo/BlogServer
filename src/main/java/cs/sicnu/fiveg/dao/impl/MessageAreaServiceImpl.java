package cs.sicnu.fiveg.dao.impl;

import cs.sicnu.fiveg.dao.MessageAreaService;
import cs.sicnu.fiveg.mapper.MessageAreaMapper;
import cs.sicnu.fiveg.mapper.UserInfoMapper;
import cs.sicnu.fiveg.pojo.MessageArea;
import cs.sicnu.fiveg.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 留言
 *
 * @author shylock
 * @date 2018-06-27 10:43
 */
@Service
public class MessageAreaServiceImpl implements MessageAreaService {

    @Autowired
    private MessageAreaMapper messageAreaMapper;


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<MessageArea> queryAllMessageArea(int belongId) {
        return messageAreaMapper.selectAll(belongId);
    }

    @Override
    public int insertMessageNew(MessageArea mVo) {
        if(mVo.getMessageUser()==null){
            UserInfo userInfo=new UserInfo();
            userInfo.setUserId(4);
            mVo.setMessageUser(userInfo);
        }else if(mVo.getMessageEmail()==null||mVo.getMessageEmail().equals("")){
            mVo.getMessageUser().setUserId(4);
        }else {
            if(mVo.getMessageUser().getUserId()==null){
                UserInfo userInfo=userInfoMapper.selectByName(mVo.getMessageUser().getUserName());
                mVo.setMessageUser(userInfo);
            }
        }

        return messageAreaMapper.insert(mVo);
    }

    @Override
    public int getNewMessageId() {
        MessageArea messageArea=messageAreaMapper.selectNew();
        return messageArea.getMessageId();
    }
}
