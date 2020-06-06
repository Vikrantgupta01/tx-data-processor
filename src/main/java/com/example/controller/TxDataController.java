package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.entity.TxData;
import com.example.helper.ResponseMessage;
import com.example.model.ClientInformation;
import com.example.model.ProductInformation;
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
	public Map<ClientInformation,Map<ProductInformation, List<TxData>>> getTxDataList() {
		List<TxData> dataList = txDataService.findAll();
		Map<ClientInformation,Map<ProductInformation, List<TxData>>> result = new HashMap<>();
		Map<ClientInformation, List<TxData>> clientTxData = dataList.stream()
				.collect(Collectors.groupingBy(tx ->
						new ClientInformation(tx.getClientType(), tx.getClientNumber(),
								tx.getAccountNumber(),tx.getSubAccountNumber())));

		for (ClientInformation clientInformation: clientTxData.keySet()) {
			List<TxData> txData = clientTxData.get(clientInformation);
			Map<ProductInformation, List<TxData>> clientProductTxData =
					txData.stream().collect(Collectors.groupingBy(x ->
							new ProductInformation(x.getProductGroupCode(), x.getExchangeCode(),
									x.getSymbol(),x.getExpirationDate())));
			result.put(clientInformation,clientProductTxData);

		}

		for (ClientInformation clientInformation: result.keySet()) {

			Map<ProductInformation, List<TxData>> clientProductTxData = result.get(clientInformation);
			for (ProductInformation productInformation: clientProductTxData.keySet()) {
				List<TxData> txData = clientProductTxData.get(productInformation);
				int Total_Transaction_Amount =0;
				for (TxData txData1: txData){
					Total_Transaction_Amount+=(txData1.getQuantityLong()-txData1.getQuantityShort());
				}
				System.out.println(clientInformation+""+productInformation+""+Total_Transaction_Amount);
			}

		}
		return result;
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
