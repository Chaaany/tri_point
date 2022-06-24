package com.triple.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.triple.constants.AttachedActivityType;
import com.triple.dto.AttachedPhotoDto;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.IsNull.notNullValue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class AttachedServiceTest {

	@Autowired
	AttachedPhotoService attachedService;

	@Test
	@DisplayName("첨부 사진 ID로 첨부 사진 정보 상세 조회")
	public void testGetPhotoInfo() {
		// given
		String existedPhotoId = "e4d1a64e-a531-46de-88d0-ff0ed70c0bb8"; // DB상 존재하는 id
		String notExistedPhotoId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		// when
		AttachedPhotoDto existedPhoto = attachedService.getPhotoInfo(existedPhotoId);
		AttachedPhotoDto notExistedPhoto = attachedService.getPhotoInfo(notExistedPhotoId);

		// then
		assertThat(existedPhoto, is(notNullValue()));
		assertThat(notExistedPhoto, is(nullValue()));
	}

	@Test
	@DisplayName("특정 활동 ID로 첨부 사진 정보 상세 조회")
	public void testGetSpecificAcitivityPhotoInfo() {
		// given
		String existedActivityId = "240a0658-dc5f-4878-9381-ebb7b2667772"; // DB상 존재하는 id
		String notExistedActivityId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		// when
		List<AttachedPhotoDto> existedPhoto = attachedService.getSpecificAcitivityPhotoInfo(existedActivityId);
		List<AttachedPhotoDto> notExistedPhoto = attachedService.getSpecificAcitivityPhotoInfo(notExistedActivityId);

		// then
		assertThat(existedPhoto.size()).isNotEqualTo(0);
		assertThat(notExistedPhoto.size()).isEqualTo(0);
	}

	@Test
	@DisplayName("첨부 사진 정보 생성")
	public void testCreatePhotoData() {
		// given
		String existedPhotoId = "03b12820-7a1c-4f7c-92cc-5bc5c398388c"; // DB상 존재하는 id
		String notExistedPhotoId = UUID.randomUUID().toString(); // DB상 존재하지 않는 id

		AttachedPhotoDto existedAttachedPhotoDto = new AttachedPhotoDto(existedPhotoId,
				AttachedActivityType.REVIEW.getValue(), UUID.randomUUID().toString(),
				"3ede0ef2-92b7-4817-a5f3-0c575361f745");
		AttachedPhotoDto notExistedAttachedPhotoDto = new AttachedPhotoDto(notExistedPhotoId,
				AttachedActivityType.REVIEW.getValue(), UUID.randomUUID().toString(),
				"3ede0ef2-92b7-4817-a5f3-0c575361f745");

		// when
		boolean notExistedPhoto = attachedService.createPhotoData(notExistedAttachedPhotoDto);

		// then
		assertThatThrownBy(() -> attachedService.createPhotoData(existedAttachedPhotoDto));
		assertThat(notExistedPhoto).isTrue();
	}
	
}
