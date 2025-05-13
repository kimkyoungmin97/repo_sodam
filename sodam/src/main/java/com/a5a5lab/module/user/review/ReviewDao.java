package com.a5a5lab.module.user.review;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface ReviewDao {
	
	//리뷰 리스트 보여주기
	public List<ReviewDto> reviewListByUser(int memSeq);
	
	
	//리뷰 My 페이지 업데이트 삭제
	public int uelete(List<Long> deleteIds);
	
}
