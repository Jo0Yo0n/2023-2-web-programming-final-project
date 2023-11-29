package like.service;

import java.util.List;

import like.dao.LikeDao;
import like.entity.Like;

public class LikeService {
	private final LikeDao likeDao = new LikeDao();

	public List<Like> getLikesByHospitalId(Long hosId){
		return likeDao.getLikesByHospitalId(hosId);
	}

	public List<Like> getLikesByUserId(Long userId){
		return likeDao.getLikesByUserId(userId);
	}
}