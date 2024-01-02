package com.ezen.grrreung.domain.item.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UploadFile {
	private String uploadFileName;
	private String storeFileName;

}
