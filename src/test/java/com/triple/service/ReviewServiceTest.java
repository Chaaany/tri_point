package com.triple.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.UUID;

import com.triple.dto.ReviewDto;

@SpringBootTest
public class ReviewServiceTest {

	@Autowired
	ReviewService reviewService;
	
	@Test
	@DisplayName("리뷰 ID로 리뷰 정보 상세 조회")
	void testGetReviewInfo() {
		// given
		String existedreviewId = "240a0658-dc5f-4878-9381-ebb7b2667772"; // DB상 존재하는 id
		String notExistedreviewId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		// when
		ReviewDto existedReview = reviewService.getReviewInfo(existedreviewId);
		ReviewDto notExistedReview = reviewService.getReviewInfo(notExistedreviewId);

		// then
		assertThat(existedReview, is(notNullValue()));
		assertThat(notExistedReview, is(nullValue()));
	}

	@Test
	@DisplayName("특정 사용자ID, 특정 장소ID로 리뷰 정보 조회")
	void testGetplaceReviewOfSpecificUser() {
		// given
		String existedUserId = "3ede0ef2-92b7-4817-a5f3-0c575361f745"; // DB상 존재하는 id
		String notExistedUserId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id
		String existedPlaceId = "2e4baf1c-5acb-4efb-a1af-eddada31b00f"; // DB상 존재하는 id
		String notExistedPlaceId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id
		
		// when
		List<ReviewDto> existedReview = reviewService.getplaceReviewOfSpecificUser(existedPlaceId, existedUserId);
		List<ReviewDto> notExistedReview1 = reviewService.getplaceReviewOfSpecificUser(existedPlaceId, notExistedUserId);
		List<ReviewDto> notExistedReview2 = reviewService.getplaceReviewOfSpecificUser(notExistedPlaceId, existedUserId);
		List<ReviewDto> notExistedReview3 = reviewService.getplaceReviewOfSpecificUser(notExistedPlaceId, notExistedPlaceId);

		// then
		assertThat(existedReview.size()).isNotEqualTo(0);
		assertThat(notExistedReview1.size()).isEqualTo(0);
		assertThat(notExistedReview2.size()).isEqualTo(0);
		assertThat(notExistedReview3.size()).isEqualTo(0);
	}

	@Test
	@DisplayName("특정 장소ID로 첫 리뷰 정보 조회 ")
	void testGetPlaceFirstReview() {
		// given
		String existedPlaceId = "2e4baf1c-5acb-4efb-a1af-eddada31b00f"; // DB상 존재하는 id
		String notExistedPlaceId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id
		
		// when
		ReviewDto existedReview = reviewService.getPlaceFirstReview(existedPlaceId);
		ReviewDto notExistedReview = reviewService.getPlaceFirstReview(notExistedPlaceId);

		// then
		assertThat(existedReview, is(notNullValue()));
		assertThat(notExistedReview, is(nullValue()));
	}

	@Test
	@DisplayName("리뷰 정보 생성 ")
	void testCreateReviewData() {
		// given
		String existedReviewId = "240a0658-dc5f-4878-9381-ebb7b2667772"; // DB상 존재하는 id
		String notExistedReviewId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id
		
		ReviewDto existedReviewDto = new ReviewDto(existedReviewId, "2e4baf1c-5acb-4efb-a1af-eddada31b00f", "3ede0ef2-92b7-4817-a5f3-0c575361f745", "" + (int)(Math.random()*10000000)); 
		ReviewDto notExistedReviewDto = new ReviewDto(notExistedReviewId, "2e4baf1c-5acb-4efb-a1af-eddada31b00f", "3ede0ef2-92b7-4817-a5f3-0c575361f745", "" + (int)(Math.random()*10000000)); 

		// when
		boolean notExistedPhoto = reviewService.createReviewData(notExistedReviewDto);

		// then
		assertThatThrownBy(() -> reviewService.createReviewData(existedReviewDto));
		assertThat(notExistedPhoto).isTrue();
	}

}
