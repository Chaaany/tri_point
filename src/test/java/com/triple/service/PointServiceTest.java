package com.triple.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.triple.constants.AttachedActivityType;
import com.triple.dto.AttachedPhotoDto;
import com.triple.dto.PlaceDto;
import com.triple.dto.PointDto;
import com.triple.dto.ReviewDto;
import com.triple.dto.ReviewEventRequestDto;
import com.triple.dto.UserDto;
import com.triple.mapper.AttachedPhotoMapper;
import com.triple.mapper.PlaceMapper;
import com.triple.mapper.ReviewMapper;
import com.triple.mapper.UserMapper;

@SpringBootTest
public class PointServiceTest {
	
	@Autowired
	PointService pointService;
	
	@Autowired
	PlaceMapper placeMapper;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	ReviewMapper reviewMapper;
	
	@Autowired
	AttachedPhotoMapper attachedPhotoMapper;

	
	@Test
	@DisplayName("전체 사용자의 포인트 내역 조회")
	void testGetAllUserPoint() {
		//when, then
		assertThat(pointService.getAllUserPoint(), is(notNullValue()));
	}

	@Test
	@DisplayName("전체 사용자의 포인트 내역 조회")
	void testGetAllPointRecords() {
		//when, then
		assertThat(pointService.getAllPointRecords(), is(notNullValue()));
	}

	@Test
	@DisplayName("특정 사용자ID로 포인트 조회")
	void testGetUserPoint() {
		// given
		String existedUserId = "3ede0ef2-92b7-4817-a5f3-0c575361f745"; // DB상 존재하는 id
		String notExistedUserId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		// when, then
		assertThat(pointService.getUserPoint(existedUserId), is(notNullValue()));
		assertThat(pointService.getUserPoint(notExistedUserId), is(nullValue()));
	}
	

	@Test
	@DisplayName("특정 사용자 ID로 포인트 내역 조회")
	void testGetUserPointRecords() {
		// given
		String existedUserId = "3ede0ef2-92b7-4817-a5f3-0c575361f745"; // DB상 존재하는 id
		String notExistedUserId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		// when, 
		System.out.print(pointService);
		List<PointDto> existedUserRecords = pointService.getUserPointRecords(existedUserId);
		List<PointDto> NotExistedUserRecords = pointService.getUserPointRecords(notExistedUserId);
		
		// then
		assertThat(existedUserRecords.size()).isNotEqualTo(0);
		assertThat(NotExistedUserRecords.size()).isEqualTo(0);
	}

	@Test
	@DisplayName("리뷰 작성 이벤트 발생 시 포인트 적립 적용")
	void testUploadReview() {
		// given
		String reviewId = UUID.randomUUID().toString();
		String content = "좋아요!!!" + "" + (int) (Math.random() * 10000);
		int attachedPhotoIdsCnt = (int) Math.random() * 5 + 1;
		List<String> attachedPhotoIds = new ArrayList<>();
		for (int i = 0; i < attachedPhotoIdsCnt; i++) {
			attachedPhotoIds.add(UUID.randomUUID().toString());
		}
		String userId = UUID.randomUUID().toString();
		String placeId = UUID.randomUUID().toString();
		
		ReviewEventRequestDto eventRequestDto = new ReviewEventRequestDto("REVIEW", "ADD", reviewId, content, attachedPhotoIds, userId, placeId);  

		// when
		placeMapper.createPlaceData(new PlaceDto(eventRequestDto.getPlaceId(), eventRequestDto.getUserId()));

		reviewMapper.createReviewData(new ReviewDto(eventRequestDto.getReviewId(), eventRequestDto.getPlaceId(),	eventRequestDto.getUserId(), eventRequestDto.getContent()));

		userMapper.createUserData(new UserDto(eventRequestDto.getUserId(), "triple" + (int) (Math.random() * 10000), "" + (int) (Math.random() * 10000), (int) (Math.random() * 2)));
		
		for (String photoId : eventRequestDto.getAttachedPhotoIds()) {
			attachedPhotoMapper.createPhotoData(new AttachedPhotoDto(photoId, AttachedActivityType.REVIEW.getValue(), eventRequestDto.getReviewId(), eventRequestDto.getUserId()));
		}
		
		String uploadCheck = pointService.uploadReview(eventRequestDto);
		
		// then
		assertThat(uploadCheck).isEqualTo("success");
		assertThat(pointService.getUserPointRecords(userId), is(notNullValue()));
		assertThat(pointService.getUserPoint(userId), is(notNullValue()));
		assertThat(pointService.getUserPointRecords(userId).size()).isNotEqualTo(0); // content 1자 이상
		
	}

	@Test
	@DisplayName("리뷰 수정 이벤트 발생 시 포인트 데이터 변동사항 적용 - 글자 수 1자 이상, 첨부 사진 1개 이상, 첫 리뷰 -> 글자 수 0자, 첨부 사진 0개, 첫 리뷰 ")
	void testModifyReview() {
		// given
		String reviewId = UUID.randomUUID().toString();
		String content = "좋아요!!!" + "" + (int) (Math.random() * 10000);
		List<String> attachedPhotoIds = new ArrayList<>();
		attachedPhotoIds.add(UUID.randomUUID().toString());
		String userId = UUID.randomUUID().toString();
		String placeId = UUID.randomUUID().toString();
		
		ReviewEventRequestDto eventRequestDto = new ReviewEventRequestDto("", "", reviewId, content, attachedPhotoIds, userId, placeId);  

		// when
		placeMapper.createPlaceData(new PlaceDto(eventRequestDto.getPlaceId(), eventRequestDto.getUserId()));

		reviewMapper.createReviewData(new ReviewDto(eventRequestDto.getReviewId(), eventRequestDto.getPlaceId(),eventRequestDto.getUserId(), eventRequestDto.getContent()));

		userMapper.createUserData(new UserDto(eventRequestDto.getUserId(), "triple" + (int) (Math.random() * 10000), "" + (int) (Math.random() * 10000), (int) (Math.random() * 2)));
		
		for (String photoId : eventRequestDto.getAttachedPhotoIds()) {
			attachedPhotoMapper.createPhotoData(new AttachedPhotoDto(photoId, AttachedActivityType.REVIEW.getValue(), eventRequestDto.getReviewId(), eventRequestDto.getUserId()));
		}
		
		pointService.uploadReview(eventRequestDto);
		
		int beforeModifyPointScore = pointService.getUserPoint(userId).getPointScore();
		
		reviewMapper.modifyReview(new ReviewDto(eventRequestDto.getReviewId(), eventRequestDto.getPlaceId(),eventRequestDto.getUserId(), ""));
		attachedPhotoMapper.deletePhoto(attachedPhotoIds.get(0));
		
		eventRequestDto.setContent("");
		eventRequestDto.setAttachedPhotoIds(null);
		String modifyCheck = pointService.modifyReview(eventRequestDto);
		
		// then
		int afterModifyPointScore = pointService.getUserPoint(userId).getPointScore();
		assertThat(modifyCheck).isEqualTo("success");
		assertThat(beforeModifyPointScore).isEqualTo(3); // content 1자 이상
		assertThat(afterModifyPointScore).isEqualTo(1); // content 1자 이상
		
	}

	@Test
	@DisplayName("리뷰 삭제 이벤트 발생 시 포인트 데이터 변동사항 적용 - 첫 리뷰 포인트, 내용 1자 이상, 사진 1개 첨부 -> 삭제")
	void testDeleteReview() {
		// given
		String reviewId = UUID.randomUUID().toString();
		String content = "좋아요!!!" + "" + (int) (Math.random() * 10000);
		List<String> attachedPhotoIds = new ArrayList<>();
		attachedPhotoIds.add(UUID.randomUUID().toString());
		String userId = UUID.randomUUID().toString();
		String placeId = UUID.randomUUID().toString();
		
		ReviewEventRequestDto eventRequestDto = new ReviewEventRequestDto("", "", reviewId, content, attachedPhotoIds, userId, placeId);  

		// when
		placeMapper.createPlaceData(new PlaceDto(eventRequestDto.getPlaceId(), eventRequestDto.getUserId()));

		reviewMapper.createReviewData(new ReviewDto(eventRequestDto.getReviewId(), eventRequestDto.getPlaceId(),eventRequestDto.getUserId(), eventRequestDto.getContent()));

		userMapper.createUserData(new UserDto(eventRequestDto.getUserId(), "triple" + (int) (Math.random() * 10000), "" + (int) (Math.random() * 10000), (int) (Math.random() * 2)));
		
		for (String photoId : eventRequestDto.getAttachedPhotoIds()) {
			attachedPhotoMapper.createPhotoData(new AttachedPhotoDto(photoId, AttachedActivityType.REVIEW.getValue(), eventRequestDto.getReviewId(), eventRequestDto.getUserId()));
		}
		
		pointService.uploadReview(eventRequestDto);
		
		int beforeModifyPointScore = pointService.getUserPoint(userId).getPointScore();
		
		reviewMapper.deleteReview(reviewId);
		attachedPhotoMapper.deletePhoto(attachedPhotoIds.get(0));
		
		eventRequestDto.setContent("");
		eventRequestDto.setAttachedPhotoIds(null);
		String deleteCheck = pointService.deleteReview(eventRequestDto);
		
		// then
		int afterModifyPointScore = pointService.getUserPoint(userId).getPointScore();
		assertThat(deleteCheck).isEqualTo("success");
		assertThat(beforeModifyPointScore).isEqualTo(3); // content 1자 이상
		assertThat(afterModifyPointScore).isEqualTo(0); // content 1자 이상
	}

}
