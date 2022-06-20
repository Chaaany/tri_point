package com.triple.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triple.dto.AttachedPhotoDto;
import com.triple.dto.PlaceDto;
import com.triple.dto.PointDto;
import com.triple.dto.ReviewDto;
import com.triple.dto.UserDto;
import com.triple.service.AttachedPhotoService;
import com.triple.service.PlaceService;
import com.triple.service.PointService;
import com.triple.service.ReviewService;
import com.triple.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("MainController")
@RestController
@RequestMapping("/")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private PointService pointService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UserService userService;

	@Autowired
	private PlaceService placeService;

	@Autowired
	private AttachedPhotoService attachedPhotoService;

	@ApiOperation(value = "Review event 발생", notes = "리뷰 event 발생 시 event type에 따라 review 및 포인트 적립/차감 DB작업 수행, DB입력 성공여부에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("events")
	public ResponseEntity<String> reviewEvent(@RequestBody ConcurrentHashMap<String, Object> event) {
		logger.debug("review event 발생 - 호출");
		String type = (String) event.get("type");
		String action = (String) event.get("action");
		String reviewId = (String) event.get("reviewId");
		String content = (String) event.get("content");
		List<String> attachedPhotoIds = (List<String>) event.get("attachedPhotoIds");
		String userId = (String) event.get("userId");
		String placeId = (String) event.get("placeId");
		int totalpoint = 0;
		if (type.equals("REVIEW")) {
			PlaceDto placedto = null;
			UserDto userdto = null;
			ReviewDto reviewdto = null;

			if (action.equals("ADD")) {
				try {
					// 해당 장소id 존재 여부 확인
					placedto = placeService.placeInfo(placeId);
					if (placedto != null) {
					} else {
						throw new NullPointerException("place");
					}

					// 해당 유저id 존재 여부 확인
					userdto = userService.userInfo(userId);
					if (userdto != null) {
					} else {
						throw new NullPointerException("user");
					}

					// 해당 리뷰id 존재 여부 확인
					reviewdto = reviewService.reviewInfo(reviewId);

					if (reviewdto == null) {
						// 중복된 리뷰id 존재하지 않을 시 review 등록
						reviewdto = new ReviewDto(reviewId, placeId, userId, content, attachedPhotoIds.size());
						reviewService.uploadReview(reviewdto);
					} else {
						throw new Exception("existedReview");
					}
					
					// 해당 장소에 리뷰 첫 리뷰 일 경우 갱신 보너스 점수 제공 activityType 1
					if (placedto.getReviewCount() == 0) {
						placedto.setReviewCount(placedto.getReviewCount()+1);
						placeService.updatePlace(placedto);
						int bonus = 1;
						totalpoint += bonus;
						PointDto pointdto = new PointDto(userId, 1, bonus, 1);
						pointService.plusPoint(pointdto);
					}else {
						placedto.setReviewCount(placedto.getReviewCount()+1);
					}

					// 리뷰 글자 수가 1자 이상 일 경우 point + 1점 
					// 리뷰에 글자 수 1자 이상 activityType 2
					if (content.length() != 0) {
						totalpoint += 1;
						PointDto pointdto = new PointDto(userId, 2, 1, 1);
						pointService.plusPoint(pointdto);
					}
					

					// 첨부 사진 수가 1개 이상 일 경우 point + 1점 
					// 리뷰에 첨부 사진 수 1자 이상 activityType 3
					if (attachedPhotoIds.size() != 0) {
						totalpoint += 1;
						PointDto pointdto = new PointDto(userId, 3, 1, 1);
						pointService.plusPoint(pointdto);
						for (String photoid : attachedPhotoIds) {
							AttachedPhotoDto photodto = new AttachedPhotoDto(photoid, 1, userId);
							attachedPhotoService.uploadPhoto(photodto);
						}
					}
					userdto.setTotalPoint(userdto.getTotalPoint()+totalpoint);;
					userService.updateUser(userdto);
					
				} catch (NullPointerException e) {
					if (e.getMessage().equals("place")) {
						logger.debug("placeid : " + placeId + "는 존재하지 않는 장소");
						return new ResponseEntity<String>("no place error", HttpStatus.BAD_REQUEST);
					} else if (e.getMessage().equals("user")) {
						logger.debug("userid : " + userId + "는 존재하지 않는 유저");
						return new ResponseEntity<String>("no user error", HttpStatus.BAD_REQUEST);
					}else if(e.getMessage().equals("existedReview")) {
						logger.debug("reviewid : " + reviewId + "는 존재하는 리뷰 id");
						return new ResponseEntity<String>("existed reviewid", HttpStatus.BAD_REQUEST);
					}
				} catch (Exception e) {
					e.printStackTrace();
					return new ResponseEntity<String>("error", HttpStatus.BAD_REQUEST);
				}
			}/* else if (action.equals("MOD")) {
				// 해당 리뷰

			} else if (action.equals("DELETE")) {

			}*/
		}
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

	@ApiOperation(value = "사용자 전체 포인트 조회", notes = "userId에 해당하는 총 point 점수를 반환한다. DB작업 수행시 ", response = String.class)
	@GetMapping("point/{userid}")
	public ResponseEntity<String> getTotalPoint(@PathVariable String userid) {
		logger.debug("userid : " + userid + " 포인트 조회");
		int totalPoint = 0;
		// 사용자가 존재하는 사용자인지 체크
		UserDto userdto = null;
		try {
			userdto = userService.userInfo(userid);
		} catch (Exception e) {
			// 사용자 조회 오류 시 에러 처리
			logger.debug("userid : " + userid + " 사용자 조회 에러 발생");
			return new ResponseEntity<String>("read user error", HttpStatus.BAD_REQUEST);
		}

		// 사용가 존재 여부에 따라 포인트 조회
		if (userdto != null) {
			try {
				totalPoint = userdto.getTotalPoint();
				// 포인트가 음수일 경우 에러 발생
				if (totalPoint < 0) {
					logger.debug("userid : " + userid + " 포인트 조회 시 음수값 반환");
					throw new Exception();
				}
			} catch (Exception e) {
				// 포인트 조회 오류 시 에러 처리
				logger.debug("userid : " + userid + " 포인트 조회 시 에러 발생");
				return new ResponseEntity<String>("point error", HttpStatus.BAD_REQUEST);
			}
			// 포인트 조회 완료 시 반환
			return new ResponseEntity<String>(Integer.toString(totalPoint), HttpStatus.OK);
		} else {
			logger.debug("userid : " + userid + "는 존재하지 않은 사용자");
			return new ResponseEntity<String>("not registerd user", HttpStatus.BAD_REQUEST);
		}
	}
}