package com.a5a5lab.module.user.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
	
	
	@Autowired
	ReviewDao reviewDao;
	
	//리뷰 리스트 보여주기
	public List<ReviewDto> reviewListByUser(int memSeq){
		return reviewDao.reviewListByUser(memSeq);
	}
	
	// My 페이지 리뷰 업데이트 삭제
	public int uelete(List<Long> deleteIds) {
		return reviewDao.uelete(deleteIds);
	}
	
	// 리뷰 등록하기
	public int insert (ReviewDto reviewDto) {
		return reviewDao.insert(reviewDto);
	}
}
