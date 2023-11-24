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
	public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
		List<UploadFile> storeFileResult = new ArrayList<UploadFile>();
		for (MultipartFile multipartFile : multipartFiles) {
			if (!multipartFile.isEmpty()) {
				// 업로드 파일 저장
				UploadFile uploadFile = storeFile(multipartFile);
				storeFileResult.add(uploadFile);
			}
		}
		return storeFileResult;
	}
	
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

	private String getFullPath(String filename) {
		return location + filename;
	}

	private String createStoreFileName(String originalFilename) {
		int pos = originalFilename.lastIndexOf(".");
		String fileName = originalFilename.substring(0, pos);
		String ext = originalFilename.substring(pos + 1);
		String uuid = UUID.randomUUID().toString();
		return fileName + "-" + uuid + "." + ext;
	}
}
