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
	
	public void updateLike(Long userId, Long hospitalId){
		// 좋아요가 토글식으로 됨.
		List<Like> likes = likeDao.getLikesByUserIdAndHospitalId(userId, hospitalId);
		if(likes.size() == 0) {
			likeDao.insertLike(new Like(userId, hospitalId));
		} else {
			likeDao.deleteLike(userId, hospitalId);
		}
	}

}