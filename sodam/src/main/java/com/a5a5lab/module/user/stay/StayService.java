package com.a5a5lab.module.user.stay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a5a5lab.module.common.fileuploaded.FileUploadedDao;
import com.a5a5lab.module.common.fileuploaded.FileUploadedService;
import com.amazonaws.services.s3.AmazonS3Client;

@Service
public class StayService extends FileUploadedService {
	
	@Autowired
	StayDao stayDao;
	@Autowired
	FileUploadedDao fileUploadedDao;
	
//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	//사용자 숙박 정보 리스트 보여주기
	public List<StayDto> stayList(StayVo vo){
		return stayDao.stayList(vo);
	}
	
	//사용자 숙박 정보 리스트 보여주기
	public List<StayDto> stayList1(){
		return stayDao.stayList1();
	}
	
	//페이지 네이션
	public int selectOneCount(StayVo vo) {
		return stayDao.selectOneCount(vo);
	}
	//리뷰 페이지네이션
	public int reviewCount(StayVo vo) {
		return stayDao.reviewCount(vo);
	}
	//사용자 숙박 정보 리스트 상세
	public StayDto stayOne(StayDto stayDto) {
		
		return stayDao.stayOne(stayDto);
	}
	
	//사용자 스테이등록 했을때 리스트 상세
	public List<StayDto> stayRegistrationList(int memSeq){
		return stayDao.stayRegistrationList(memSeq);
	}
	//숙소등록
	public int insert(StayDto stayDto) throws Exception {
		stayDao.insert(stayDto);
		uploadFilesToS3(
				stayDto.getUploadImg1()
    			, stayDto
    			, "stayUploaded"
    			, 1
    			, stayDto.getRepresentativeIndex()
    			, 4
    			, stayDto.getStaySeq()
    			, fileUploadedDao
    			, amazonS3Client);
		return 1;
	}
	//숙소수정
	public int update(StayDto stayDto) throws Exception{
		stayDao.update(stayDto);
		uploadFilesToS3(
				stayDto.getUploadImg1()
    			, stayDto
    			, "stayUploaded"
    			, 1
    			, stayDto.getRepresentativeIndex()
    			, 4
    			, stayDto.getStaySeq()
    			, fileUploadedDao
    			, amazonS3Client);
		return 1;
	}
	
	
	//숙소 리뷰 리스트 가져오기
	public List<StayDto>reviewList(StayVo vo){
		return stayDao.reviewList(vo);
	}
	//숙소 이미지 리스트 가져오기
	public List<String> imgList(StayDto stayDto){
		return stayDao.imgList(stayDto);
	}
	
	
}
