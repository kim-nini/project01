package com.ezen.grrreung.web.item.controller;

import com.ezen.grrreung.domain.item.dto.UploadFile;
import com.ezen.grrreung.domain.item.dto.UploadForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
public class FileUploadDownloadController {
	// 파일 업로드 경로
	//private String location = "C:/ezen-lecture/upload/";

	// application.properties 파일에 설정된 값 읽기
	@Value("${file.dir}")
	private String location;

	private final FileStore fileStore;
	
	@GetMapping("/upload")
	public String uploadForm() {
		return "/grrreung/sub/addItem";
	}

	@PostMapping("/upload")
	public String uploadFiles(@ModelAttribute UploadForm uploadForm, RedirectAttributes redirectAttributes)
			throws IOException {
		log.info("업로드 파일: {}", uploadForm.getUploadfiles());

		// 업로드 파일들 저장
		List<UploadFile> uploadFiles = fileStore.storeFiles(uploadForm.getUploadfiles());
		log.info("저장된 파일명 : {}", uploadFiles);
		
		// DB 테이블에 업로드 파일과 저장된 파일명 저장 후

		// 업로드 파일 저장 후
		// 데이터베이스 테이블에 업로드 파일명과 실제 저장파일명을 저장(테이블의 컬럼이 2개 필요)
		redirectAttributes.addFlashAttribute("uploader", uploadForm.getUploader());
		redirectAttributes.addFlashAttribute("description", uploadForm.getDescription());
		redirectAttributes.addFlashAttribute("uploadFiles", uploadFiles);
		return "redirect:upload-result";
	}

	@GetMapping("/upload-result")
	public String uploadResult() {
		return "upload-result";
	}

	@GetMapping("/files")
	public String download(Model model) {
		// 테이블에서 정보 조회하는 것임...
		File directory = new File(location);
		File[] files = directory.listFiles();
		List<String> fileList = new ArrayList<>();
        assert files != null;
        for (File file : files) {
			String fileName = file.getName();
			long fileSize = file.length();
			fileList.add(fileName + "("+fileSize+")");
		}
		model.addAttribute("files", fileList);
		return "files";
	}

//	@GetMapping("/download/{fileName}")
//	public ResponseEntity<Resource> download(@PathVariable String fileName) throws IOException {
//		Path path = Paths.get(location + "/" + fileName);
//		String contentType = Files.probeContentType(path);
//
//		// 이미지 파일 외에는 모두 다운로드 처리
//		HttpHeaders headers = new HttpHeaders();
//		headers.add(HttpHeaders.CONTENT_TYPE, contentType);
//		Resource resource = new FileSystemResource(path);
//		if(!contentType.startsWith("image")){
//			// 응답 헤더에 파일정보 설정
//			headers.setContentDisposition(
//					ContentDisposition
//							.builder("attachment")
//							.filename(fileName, StandardCharsets.UTF_8).build());
//			resource = new FileSystemResource(path);
//		}
//		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
//	}


}
