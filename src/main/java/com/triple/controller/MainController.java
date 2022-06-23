package com.triple.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triple.constants.AttachedActivityType;

import com.triple.dto.AttachedPhotoDto;
import com.triple.dto.PlaceDto;
import com.triple.dto.PointDto;
import com.triple.dto.ReviewDto;
import com.triple.dto.ReviewEventRequestDto;
import com.triple.dto.UserDto;

import com.triple.service.AttachedPhotoService;
import com.triple.service.PlaceService;
import com.triple.service.PointService;
import com.triple.service.ReviewService;
import com.triple.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Api("MainController")
@RestController
@RequestMapping("/")
@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Slf4j
@RequiredArgsConstructor
public class MainController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private final PointService pointService;

	private final AttachedPhotoService attachedPhotoService;

	private final PlaceService placeService;

	private final ReviewService reviewService;

	private final UserService userService;

	// Get/ allpoint로 요청이 들어왔다는 가정
	@ApiOperation(value = "모든 사용자 총 포인트 조회", notes = "모든 user의 총 point 점수를 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ")
	@GetMapping("alluserpoint")
	public ResponseEntity<?> getAllUserPoint() {
		
		try {
			log.info("request : get all user point score");
			List<PointDto> allUserPoint = pointService.getAllUserPoint();
			return new ResponseEntity<List<PointDto>>(allUserPoint, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage());
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}

	// Get/ allpointrecord로 요청이 들어왔다는 가정
	@ApiOperation(value = "모든 포인트 내역 조회", notes = "모든 point 내역 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ")
	@GetMapping("alluserpointrecord")
	public ResponseEntity<?> getAllUserPointRecords() {
		try {
			List<PointDto> allUserPointRecords = pointService.getAllPointRecords();
			return new ResponseEntity<List<PointDto>>(allUserPointRecords, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(e.getMessage());
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "event 발생", notes = "event 발생 시 event type 및 action에 따라 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("events")
	public ResponseEntity<String> requestEvent(@RequestBody @Valid ReviewEventRequestDto eventRequestDto) {
		String type = eventRequestDto.getType();
		String action = eventRequestDto.getAction();

		if (type.equals("REVIEW")) {
			log.debug(type + "-" + action + " event");
			if (action.equals("ADD")) {
				return pointService.uploadReview(eventRequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
						: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
			} else if (action.equals("MOD")) {
				return pointService.modifyReview(eventRequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
						: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
			} else if (action.equals("DELETE")) {
				return pointService.deleteReview(eventRequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
						: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
			} else {
				// 정의되지 않은 요청
				log.debug("request undefined action");
				return new ResponseEntity<String>(FAIL, HttpStatus.OK);
			}
		} else {
			log.debug("request undefined type");
			return new ResponseEntity<String>(FAIL, HttpStatus.OK);
		}
	}

	// Get/ point/{userid}로 요청이 들어왔다는 가정
	@ApiOperation(value = "사용자 총 포인트 조회", notes = "userId에 해당하는 총 point 점수를 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ", response = String.class)
	@GetMapping("point/{userid}")
	public ResponseEntity<String> getUserPoint(@PathVariable String userid) {
		try {
			int userTotalPoint = pointService.getUserPoint(userid).getPointScore();
			return new ResponseEntity<String>(Integer.toString(userTotalPoint), HttpStatus.OK);
		} catch (Exception e) {
			log.debug(userid + e.getMessage());
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}

	// Get/ pointrecord/{userid}로 요청이 들어왔다는 가정
	@ApiOperation(value = "사용자 총 포인트 내역 조회", notes = "userId에 해당하는 총 point 내역 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ")
	@GetMapping("pointrecord/{userid}")
	public ResponseEntity<?> getUserPointRecords(@PathVariable @NotNull String userid) {
		try {
			List<PointDto> userPointRecords = pointService.getUserPointRecords(userid);
			return new ResponseEntity<List<PointDto>>(userPointRecords, HttpStatus.OK);
		} catch (Exception e) {
			log.debug(userid + e.getMessage());
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "첨부사진 데이터 생성", notes = "AttachedPhoto 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("photo")
	public ResponseEntity<String> createPhotoData(@RequestBody @Valid AttachedPhotoDto RequestDto) {

		log.debug("photo data create request");
		return attachedPhotoService.createPhotoData(RequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
				: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "장소 데이터 생성", notes = "place 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("place")
	public ResponseEntity<String> createPlaceData(@RequestBody @Valid PlaceDto RequestDto) {

		log.debug("place data create request");
		return placeService.createPlaceData(RequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
				: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "리뷰 데이터 생성", notes = "review 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("review")
	public ResponseEntity<String> createReviewData(@RequestBody @Valid ReviewDto RequestDto) {

		log.debug("review data create request");
		return reviewService.createReviewData(RequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
				: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "유저 데이터 생성", notes = "user 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("user")
	public ResponseEntity<String> createUserData(@RequestBody @Valid UserDto RequestDto) {

		log.debug("user data create request");
		return userService.createUserData(RequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
				: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "data 생성", notes = "event 발생 시 해당 데이터 내용으로 테이블 별 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("data")
	public ResponseEntity<String> createData(@RequestBody @Valid ReviewEventRequestDto eventRequestDto) {
		
		log.debug("data create request");
		
		String reviewId = eventRequestDto.getReviewId();
		String activityId = eventRequestDto.getReviewId();
		String content = eventRequestDto.getContent();
		List<String> attachedPhotoIds = eventRequestDto.getAttachedPhotoIds();
		String userId =  eventRequestDto.getUserId();
		String placeId = eventRequestDto.getPlaceId();
		
		AttachedPhotoDto attachedPhotoDto = null;
		PlaceDto placeDto = new PlaceDto(placeId, userId);
		ReviewDto reviewDto = new ReviewDto(reviewId, placeId, userId, content);
		UserDto userDto = new UserDto(userId, "Ben", "1111", 0);
		
		if(!placeService.createPlaceData(placeDto))return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		if(!reviewService.createReviewData(reviewDto))return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		if(!userService.createUserData(userDto))return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		
		for (String PhotoId : attachedPhotoIds) {
			attachedPhotoDto = new AttachedPhotoDto(PhotoId, AttachedActivityType.REVIEW.getValue(), activityId, userId);
			if(!attachedPhotoService.createPhotoData(attachedPhotoDto))return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

}