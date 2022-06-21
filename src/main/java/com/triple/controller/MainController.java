package com.triple.controller;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triple.dto.PointDto;
import com.triple.service.PointService;

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

	@ApiOperation(value = "event 발생", notes = "event 발생 시 event type 및 action에 따라 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 또는 HttpStatus.BAD_REQUEST(400)을 반환한다'", response = String.class)
	@PostMapping("events")
	public ResponseEntity<String> requestEvent(@RequestBody ConcurrentHashMap<String, Object> event) {
		String type = (String) event.get("type");
		String action = (String) event.get("action");

		if (type.equals("REVIEW")) {
			logger.debug(type + "-" + action + " event");
			if (action.equals("ADD")) {
				return pointService.uploadReview(event) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
						: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
			} else if (action.equals("MOD")) {
				return pointService.modifyReview(event) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
						: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
			} else if (action.equals("DELETE")) {
				return pointService.deleteReview(event) ? new ResponseEntity<String>(SUCCESS, HttpStatus.OK)
						: new ResponseEntity<String>(FAIL, HttpStatus.BAD_REQUEST);
			} else {
				// 정의되지 않은 요청
				logger.debug("request undefined action");
				return new ResponseEntity<String>(FAIL, HttpStatus.OK);
			}
		} else {
			logger.debug("request undefined type");
			return new ResponseEntity<String>(FAIL, HttpStatus.OK);
		}
	}

	// Get/ point/{userid}로 요청이 들어왔다는 가정
	@ApiOperation(value = "사용자 총 포인트 조회", notes = "userId에 해당하는 총 point 점수를 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ", response = String.class)
	@GetMapping("point/{userid}")
	public ResponseEntity<String> getUserPoint(@PathVariable String userid) {
		logger.debug("get user point userid : " + userid);
		
		int userTotalPoint = pointService.getUserPoint(userid).getPointScore();
		
		return userTotalPoint >= 0 ? new ResponseEntity<String>(Integer.toString(userTotalPoint), HttpStatus.OK): new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

	// Get/ pointrecord/{userid}로 요청이 들어왔다는 가정
	@ApiOperation(value = "사용자 총 포인트 내역 조회", notes = "userId에 해당하는 총 point 내역 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ")
	@GetMapping("pointrecord/{userid}")
	public ResponseEntity<?> getUserPointRecords(@PathVariable String userid) {
		logger.debug("get user point userid : " + userid);
		
		List<PointDto> userPointRecords = pointService.getUserPointRecords(userid);
		
		return userPointRecords == null ? new ResponseEntity<List<PointDto>>(userPointRecords, HttpStatus.OK): new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	// Get/ allpoint로 요청이 들어왔다는 가정
	@ApiOperation(value = "모든 사용자 총 포인트 조회", notes = "모든 user의 총 point 점수를 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ")
	@GetMapping("allpoint")
	public ResponseEntity<String> getAllUserPoint(@PathVariable String userid) {
		logger.debug("get user point userid : " + userid);
		
		int userTotalPoint = pointService.getUserPoint(userid).getPointScore();
		
		return userTotalPoint >= 0 ? new ResponseEntity<String>(Integer.toString(userTotalPoint), HttpStatus.OK): new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	// Get/ allpointrecord로 요청이 들어왔다는 가정
	@ApiOperation(value = "모든 포인트 내역 조회", notes = "모든 point 내역 반환한다. 로직 처리 후 처리 결과에 따라 HttpStatus.OK(200) 및 사용자 총 포인트 점수 또는 HttpStatus.BAD_REQUEST(400)을 반환한다 ")
	@GetMapping("allpointrecord")
	public ResponseEntity<?> getAllUserPointRecords(@PathVariable String userid) {
		logger.debug("get user point userid : " + userid);
		
		List<PointDto> userPointRecords = pointService.getAllPointRecords();
		
		return userPointRecords == null ? new ResponseEntity<List<PointDto>>(userPointRecords, HttpStatus.OK): new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
}