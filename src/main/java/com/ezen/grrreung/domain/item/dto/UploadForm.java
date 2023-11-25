package com.ezen.grrreung.domain.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class UploadForm {
	private String uploader;
	private String description;
	private List<MultipartFile> uploadfiles1;
	private List<MultipartFile> uploadfiles2;
}
