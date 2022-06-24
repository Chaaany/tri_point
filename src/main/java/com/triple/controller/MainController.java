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
import static com.triple.constants.ErrorCode.INVALID_PARAMETER;
import com.triple.dto.AttachedPhotoDto;
import com.triple.dto.PlaceDto;
import com.triple.dto.PointDto;
import com.triple.dto.ReviewDto;
import com.triple.dto.ReviewEventRequestDto;
import com.triple.dto.UserDto;

import com.triple.exception.CustomException;

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
	public ResponseEntity<List<PointDto>> getAllUserPoint() {
		log.info("request - getAllUserPoint");
		
		return new ResponseEntity<List<PointDto>>(pointService.getAllUserPoint(), HttpStatus.OK);
	}

	// Get/ allpointrecord로 요청이 들어왔다는 가정
	@ApiOperation(value = "모든 포인트 내역 조회", notes = "모든 point 내역 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ")
	@GetMapping("alluserpointrecord")
	public ResponseEntity<List<PointDto>> getAllUserPointRecords() {
		log.info("request - getAllUserPointRecords");
		
		return new ResponseEntity<List<PointDto>>(pointService.getAllPointRecords(), HttpStatus.OK);
	}

	@ApiOperation(value = "event 발생", notes = "event 발생 시 event type 및 action에 따라 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("events")
	public ResponseEntity<String> eventHandle(@RequestBody @Valid ReviewEventRequestDto eventRequestDto) {
		String type = eventRequestDto.getType();
		String action = eventRequestDto.getAction();

		if (type.equals("REVIEW")) {
			log.info("request - eventHandle - type : " + type +", action : " + action);
			if (action.equals("ADD")) return new ResponseEntity<String>(pointService.uploadReview(eventRequestDto), HttpStatus.OK);
			
			else if (action.equals("MOD")) return new ResponseEntity<String>(pointService.modifyReview(eventRequestDto), HttpStatus.OK);
			
			else if (action.equals("DELETE")) return new ResponseEntity<String>(pointService.deleteReview(eventRequestDto), HttpStatus.OK);
			
			else throw new CustomException(INVALID_PARAMETER);
		} else {
			throw new CustomException(INVALID_PARAMETER);
		}
	}

	// Get/ point/{userid}로 요청이 들어왔다는 가정
	@ApiOperation(value = "사용자 총 포인트 조회", notes = "userId에 해당하는 총 point 점수를 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ", response = String.class)
	@GetMapping("point/{userid}")
	public ResponseEntity<String> getUserPoint(@PathVariable String userid) {
		log.info("request - getUserPoint - userId : " + userid);	
		
		return new ResponseEntity<String>(Integer.toString(pointService.getUserPoint(userid).getPointScore()), HttpStatus.OK);
	}

	// Get/ pointrecord/{userid}로 요청이 들어왔다는 가정
	@ApiOperation(value = "사용자 총 포인트 내역 조회", notes = "userId에 해당하는 총 point 내역 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ")
	@GetMapping("pointrecord/{userid}")
	public ResponseEntity<List<PointDto>> getUserPointRecords(@PathVariable @NotNull String userid) {
		log.info("request - getUserPointRecords - userId : " + userid);	
			
		return new ResponseEntity<List<PointDto>>(pointService.getUserPointRecords(userid), HttpStatus.OK);
	}
	
	// For Manual DB DATA insert

	@ApiOperation(value = "첨부사진 데이터 생성", notes = "AttachedPhoto 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("photo")
	public ResponseEntity<String> createPhotoData(@RequestBody AttachedPhotoDto RequestDto) {
		log.info("request - createPhotoData - photoId : " + RequestDto.getAttachedPhotoId());	

		return attachedPhotoService.createPhotoData(RequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
				: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "장소 데이터 생성", notes = "place 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("place")
	public ResponseEntity<String> createPlaceData(@RequestBody PlaceDto RequestDto) {
		log.info("request - createPlaceData - placeId : " + RequestDto.getPlaceId());	

		return placeService.createPlaceData(RequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
				: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "리뷰 데이터 생성", notes = "review 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("review")
	public ResponseEntity<String> createReviewData(@RequestBody ReviewDto RequestDto) {
		log.info("request - createReviewData - reviewId : " + RequestDto.getReviewId());	

		return reviewService.createReviewData(RequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
				: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "유저 데이터 생성", notes = "user 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("user")
	public ResponseEntity<String> createUserData(@RequestBody UserDto RequestDto) {
		log.info("request - createUserData - userId : " + RequestDto.getUserId());	

		return userService.createUserData(RequestDto) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
				: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "data 생성", notes = "event 발생 시 해당 데이터 내용으로 테이블 별 데이터 생성 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("data")
	public ResponseEntity<String> createData(@RequestBody ReviewEventRequestDto eventRequestDto) {
		log.info("request - createData - userId : " + eventRequestDto.getUserId() +", reviewId : " + eventRequestDto.getReviewId() +", placeId : " + eventRequestDto.getPlaceId());	
		
		if (!placeService.createPlaceData(new PlaceDto(eventRequestDto.getPlaceId(), eventRequestDto.getUserId())))
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);

		if (!reviewService.createReviewData(new ReviewDto(eventRequestDto.getReviewId(), eventRequestDto.getPlaceId(),
				eventRequestDto.getUserId(), eventRequestDto.getContent())))
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);

		if (!userService.createUserData(new UserDto(eventRequestDto.getUserId(), "triple" + (int) Math.random() * 10000,
				"" + (int) Math.random() * 10000, (int) Math.random() * 2)))
			return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);

		for (String photoId : eventRequestDto.getAttachedPhotoIds()) {
			if (!attachedPhotoService.createPhotoData(new AttachedPhotoDto(photoId, AttachedActivityType.REVIEW.getValue(),
							eventRequestDto.getReviewId(), eventRequestDto.getUserId())))
				return new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}

}