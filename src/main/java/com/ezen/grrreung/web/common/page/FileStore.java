package com.ezen.grrreung.web.common.page;

import com.ezen.grrreung.domain.item.dto.UploadFile;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 파일 업로드 처리 및 관리
 */
@Component
@Slf4j
public class FileStore {

	@Value("${file.dir}")
	private String location;

	@PostConstruct
	public void createUploadDirectory() {
		File file = new File(location);
		if (!file.exists()) {
			file.mkdir();
		}
	}


	/** 파일 저장 */
	public List<UploadFile> storeFilesThumb(List<MultipartFile> multipartFiles) throws IOException {
		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		for (MultipartFile multipartFile : multipartFiles) {
			if (!multipartFile.isEmpty()) {
				// 업로드 파일 저장 - 썸네일
				UploadFile uploadFile = storeFile(multipartFile);
				storeFileResult.add(uploadFile);
			}
		}
		return storeFileResult;
	}

	/** 파일 저장 */
	public List<UploadFile> storeFilesDescrip(List<MultipartFile> multipartFiles) throws IOException {
		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		for (MultipartFile multipartFile : multipartFiles) {
			if (!multipartFile.isEmpty()) {
				// 업로드 파일 저장 - 상세 정보
				UploadFile uploadFile = storeDescriptionFile(multipartFile);
				storeFileResult.add(uploadFile);
			}
		}
		return storeFileResult;
	}






	// 썸네일 저장할때
	public UploadFile storeFile(MultipartFile multipartFile) throws IOException {
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}
		String originalFilename = multipartFile.getOriginalFilename();
		String storeFileName = createStoreFileName(originalFilename);

		log.info("업로드 파일명 : {}", originalFilename);
		log.info("저장 파일명 : {}", storeFileName);
		multipartFile.transferTo(new File(getFullPath(storeFileName)));
		return new UploadFile(originalFilename, storeFileName);
	}

	// 상세 이미지 저장할때 => 파일이름에 description 포함시켜서 저장함
	public UploadFile storeDescriptionFile(MultipartFile multipartFile) throws IOException {
		if (multipartFile == null || multipartFile.isEmpty()) {
			return null;
		}
		String originalFilename = multipartFile.getOriginalFilename();
		String descriptionFileName = createDescriptionFileName(originalFilename);

		log.info("업로드 파일명 : {}", originalFilename);
		log.info("저장 파일명 : {}", descriptionFileName);
		multipartFile.transferTo(new File(getFullPath(descriptionFileName)));
		return new UploadFile(originalFilename, descriptionFileName);
	}




	private String getFullPath(String filename) {
		return location + filename;
	}

	
	// 업로드시 저장되는 파일명 랜덤생성
	private String createStoreFileName(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		String fileName = originalFilename.substring(0, pos);
		String ext = originalFilename.substring(pos + 1);
		String uuid = UUID.randomUUID().toString();
		return fileName + "-" + uuid + "." + ext;
	}

	// 아이템 상세정보 이미지 파일 저장되는 파일명 랜덤생성
	private String createDescriptionFileName(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		String fileName = originalFilename.substring(0, pos);
		String ext = originalFilename.substring(pos + 1);
		String uuid = UUID.randomUUID().toString();
		return fileName + "-" + uuid + "-" + "description" + "." + ext;
	}
}
