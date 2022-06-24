/**
 * 
 */
package com.triple.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.triple.dto.PlaceDto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;

import java.util.UUID;

import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest
public class PlaceServiceTest {

	@Autowired
	PlaceService placeService;

	@Test
	@DisplayName("장소 ID로 장소 정보 상세 조회")
	void testGetPlaceInfo() {
		// given
		String existedPlaceid = "2e4baf1c-5acb-4efb-a1af-eddada31b00f"; // DB상 존재하는 id
		String notExistedPlaceid = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		// when
		PlaceDto existedPlace = placeService.getPlaceInfo(existedPlaceid);
		PlaceDto notExistedPlace = placeService.getPlaceInfo(notExistedPlaceid);

		// then
		assertThat(existedPlace, is(notNullValue()));
		assertThat(notExistedPlace, is(nullValue()));
	}

	@Test
	@DisplayName("장소 정보 생성")
	void testCreatePlaceData() {
		// given
		String existedPlaceid = "2e4baf1c-5acb-4efb-a1af-eddada31b00f"; // DB상 존재하는 id
		String notExistedPlaceid = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		PlaceDto existedPlaceDto = new PlaceDto(existedPlaceid, "3ede0ef2-92b7-4817-a5f3-0c575361f745");
		PlaceDto notExistedPlaceDto = new PlaceDto(notExistedPlaceid, "3ede0ef2-92b7-4817-a5f3-0c575361f745");

		// when
		boolean notExistedPlace = placeService.createPlaceData(notExistedPlaceDto);

		// then
		assertThatThrownBy(() -> placeService.createPlaceData(existedPlaceDto));
		assertThat(notExistedPlace).isTrue();
	}
	
}
