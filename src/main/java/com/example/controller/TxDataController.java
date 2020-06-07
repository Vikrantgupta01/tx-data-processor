package com.example.controller;

import com.example.entity.TxData;
import com.example.helper.DataParserUtil;
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

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class TxDataController {

    @Autowired
    private TxDataService txDataService;

    @Autowired
    private FixedWidthDataParser fileService;

    @GetMapping("/report")
    public void getTxDataList(@RequestParam("date") String date, HttpServletResponse response) throws IOException {
        Date date1 = DataParserUtil.verifyDateInput(date, "yyyyMMdd");
        if (date1 == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad Input data");
        }
        Map<ClientInformation, Map<ProductInformation, List<TxData>>> result =
                txDataService.getClientProductTxDataList(date1);
        txDataService.summaryReport(response, result);

    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "Success";
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
