package cs.sicnu.fiveg.dao;


import cs.sicnu.fiveg.pojo.MessageArea;

import java.util.List;

/**
 * @author 石旭辉
 *
 * 2017年9月25日
 */
public interface MessageAreaService {
	/**
	 * 查询留言区所有留言
	 * 
	 * @param belongId
	 * @return
	 */
	List<MessageArea> queryAllMessageArea(int belongId);


	/**
	 * 插入新的留言
	 * @param mVo
	 * @return
	 */
	int insertMessageNew(MessageArea mVo);


	int getNewMessageId();
}
