package cs.sicnu.fiveg.dao;


import cs.sicnu.fiveg.pojo.UserInfo;

import java.util.List;

/**
 * 用户信息接口
 * 
 * @author 何明胜
 *
 * 2017年9月17日
 */

public interface UserInfoService {
	/*  增     */
	/**
	 * 插入新注册的用户信息
	 * @param UserInfo
	 * @return
	 */
	public int insertUserInfo(UserInfo UserInfo);
	
	/*  改     */
	/**
	 * 根据id更新用户信息
	 * @param uVo
	 * @return
	 */
	public int updateUserInfoById(UserInfo uVo);
	
	/**
	 * 根据用户名改密码
	 * @param uVo
	 * @return
	 */
	public int updateUserPwdByName(UserInfo uVo);
	
	/**
	 * 根据用户名和邮箱修改密码
	 * @param uVo
	 * @return
	 */
	public int updateUserPwdByNameAndEmail(UserInfo uVo);
	
	/**
	 * 根据用户名修改用户邮箱
	 * @param uVo
	 * @return
	 */
	public int updateUserEmailByName(UserInfo uVo);
	
	/*  查     */
	/**
	 * 根据用户名查询密码
	 * @param userName
	 * @return
	 */
	public String queryPasswordByUserName(String userName);
	
	/**
	 * 根据用户名查询用户信息
	 * @param userName
	 * @return
	 */
	public UserInfo queryUserInfoByName(String userName);
	
	/**
	 * 根据条件查询总的有效用户数量
	 * @param uVo
	 * @return
	 */
	public int 	queryUserTotalCount(UserInfo uVo);
	
	/**
	 * 根据页面大小和页码查询一页的用户
	 * @param uVo
	 * @param pageSize
	 * @param pageNo
	 * @return
	 */
	public List<UserInfo> queryUserPerPage(UserInfo uVo, int pageSize, int pageNo);
}