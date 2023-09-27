package com.lps.boot.service;

import com.lps.boot.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Slf4j
@Service
public class BatchCreateProcessServiceImpl extends BaseFlowService {


    public static final String SUBPROC_SEQ_START = "01";

    public BatchCreateProcessServiceImpl() {
    }

    @Override
    protected void doAction(String paramHelper) throws Exception {
        log.info("BatchCreateProcessServiceImpl----------doAction-----method");
    }

    @Override
    protected void submitWorkItem(String paramHelper) throws Exception {
        log.info("BatchCreateProcessServiceImpl----------submitWorkItem-----method");
    }

    public Priority getPriorityByBusiNo(String paramHelper, String busiCode, String brCode, int priority) {
        log.info("BatchCreateProcessServiceImpl----------getPriorityByBusiNo-----method");

        return new Priority(priority, 1);
    }

    private int calTotalSecondsOfTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(11);
        int minute = calendar.get(12);
        int second = calendar.get(13);
        int totalSec = (hour * 60 + minute) * 60 + second;
        return totalSec;
    }

    private Date StringToDate(String date, String formatStr) {
        if (StringUtil.isBlank(date)) {
            return null;
        } else {
            try {
                Date dater = (new SimpleDateFormat(formatStr)).parse(date);
                return dater;
            } catch (ParseException var5) {
                log.error("日期转换出错.", var5);
                return null;
            }
        }
    }

    private void rollback(List<String> succesList) {
        log.info("BatchCreateProcessServiceImpl----------rollback-----method");
    }

    class BatchStartParameterDTO {
        private String startParameterDTO;
        private String flwTSubprocInsId;
        private String paramHelper;

        public BatchStartParameterDTO(String startParameterDTO, String flwTSubprocInsId, String paramHelper) {
            this.startParameterDTO = startParameterDTO;
            this.flwTSubprocInsId = flwTSubprocInsId;
            this.paramHelper = paramHelper;
        }

        public String getFlwTSubprocInsId() {
            return this.flwTSubprocInsId;
        }

        public String getParamHelper() {
            return this.paramHelper;
        }

        public String getStartParameterDTO() {
            return this.startParameterDTO;
        }
    }

    class Priority {
        int priority;
        int result;

        public Priority(int priority, int result) {
            this.priority = priority;
            this.result = result;
        }
    }
}
