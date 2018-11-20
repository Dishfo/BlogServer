package cs.sicnu.fiveg.dao.impl;

import cs.sicnu.fiveg.dao.ReleaseFeatureService;
import cs.sicnu.fiveg.mapper.ReleaseFeatureMapper;
import cs.sicnu.fiveg.pojo.ReleaseFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 版本信息
 *
 * @author shylock
 * @date 2018-06-27 10:46
 */
@Service
public class ReleaseFeatureServiceImpl implements ReleaseFeatureService {

    @Autowired
    private ReleaseFeatureMapper releaseFeatureMapper;


    @Override
    public int insertReleaseFeature(ReleaseFeature releaseFeatureVo) {
        return releaseFeatureMapper.insert(releaseFeatureVo);
    }

    @Override
    public ReleaseFeature queryLatestReleaseFeature() {
        return releaseFeatureMapper.selectLatest();
    }

    @Override
    public ReleaseFeature queryReleaseById(int releaseId) {
        return releaseFeatureMapper.selectById(releaseId);
    }

    @Override
    public int updateReleaseContentById(ReleaseFeature rVo) {
        return releaseFeatureMapper.update(rVo);
    }
}
