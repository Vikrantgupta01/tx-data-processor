package com.example.controller;

import java.util.List;

import com.example.entity.TxData;
import com.example.helper.ResponseMessage;
import com.example.service.FixedWidthDataParser;
import com.example.service.TxDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TxDataController {
	
	@Autowired
	private TxDataService txDataService;

	@Autowired
	FixedWidthDataParser fileService;
	
	@GetMapping("/")
	public List<TxData> getTxDataList() {
		return txDataService.findAll();
	}

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			List<TxData> txData = fileService.getParsedData(file);
			txDataService.saveAll(txData);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}

	}

}
