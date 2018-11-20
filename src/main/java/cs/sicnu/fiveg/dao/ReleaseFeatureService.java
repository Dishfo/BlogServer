package cs.sicnu.fiveg.dao;


import cs.sicnu.fiveg.pojo.ReleaseFeature;

/**
 * 新版本特性接口
 *
 * @author 石旭辉
 * <p>
 * 2017年10月17日
 */
public interface ReleaseFeatureService {
    /**
     * 插入新的版本特性
     *
     * @param releaseFeatureVo
     * @return
     */
    int insertReleaseFeature(ReleaseFeature releaseFeatureVo);

    /**
     * 查询最新的版本特性
     *
     * @return
     */
    ReleaseFeature queryLatestReleaseFeature();

    /**
     * 根据id查询版本
     *
     * @param releaseId
     * @return
     */
    ReleaseFeature queryReleaseById(int releaseId);

    /**
     * 根据id修改版本信息
     *
     * @param rVo
     * @return
     */
    int updateReleaseContentById(ReleaseFeature rVo);
}