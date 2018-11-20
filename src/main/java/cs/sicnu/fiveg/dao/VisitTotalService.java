package cs.sicnu.fiveg.dao;


import cs.sicnu.fiveg.pojo.VisitTotal;

import java.util.Date;


/**
 * @author 石旭辉
 *
 * 2017年9月30日
 */

public interface VisitTotalService {
	/**
	 * 查询所有访问量
	 * @return
	 */
	int queryVisitTotal();
	
	/**
	 * 查询当日访问量
	 * @return
	 */
	int  queryVisitToday();
	
	/**
	 * 更新当日访问量和总访问量
	 * 
	 * @param
	 * @return
	 */

	int updateVisitTotal();

	int updateVisitToday();


}
