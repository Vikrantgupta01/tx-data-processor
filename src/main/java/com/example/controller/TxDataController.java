package com.example.controller;

import com.example.entity.TxData;
import com.example.helper.DataParserUtil;
import com.example.helper.ResponseMessage;
import com.example.model.ClientInformation;
import com.example.model.ProductInformation;
import com.example.service.FixedWidthDataParser;
import com.example.service.TxDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    private static final Logger logger = LoggerFactory.getLogger(TxDataController.class);


    @Autowired
    private TxDataService txDataService;

    @Autowired
    private FixedWidthDataParser fileService;

    @GetMapping(path = "/report", produces = "multipart/form-data")
    public void getTxDataList(@RequestParam("date") String date, HttpServletResponse response) throws IOException {
        Date summaryDate = DataParserUtil.verifyDateInput(date, "yyyyMMdd");
        logger.info("Request to get summery report for date {}", date);
        if (summaryDate == null) {
            logger.error("request date is not valid, aborting operation");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Bad Input data");
        }
        Map<ClientInformation, Map<ProductInformation, List<TxData>>> result =
                txDataService.getClientProductTxDataList(summaryDate);
        txDataService.summaryReport(response, result);
        logger.info("successfully operation done !!");
    }

    @PostMapping(path = "/upload", consumes = "multipart/form-data")
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
