package com.lps.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public abstract class BaseFlowService {

    public static final String SCRIPT_POSITION_TYPE_GET = "get";
    public static final String SCRIPT_POSITION_TYPE_PUT = "put";
    public static final String SCRIPT_POSITION_TYPE_ROLLBACK = "rollback";
    @Resource
    private ConfigurableApplicationContext context;

    public BaseFlowService() {
    }

    protected void beforeAction(String paramHelper) throws Exception {
    }

    protected void afterAction(String paramHelper) throws Exception {
    }

    protected abstract void doAction(String paramHelper) throws Exception;

    protected void submitWorkItem(String paramHelper) throws Exception {
    }

    public String execute(String paramHelper) throws Exception {
        log.info("BaseFlowService----------execute-----method");
        this.doAction(paramHelper);
        this.submitWorkItem(paramHelper);
        return paramHelper;
    }

    protected String runScript(String paramHelper, String scriptPosition) {
        log.info("BaseFlowService----------runScript-----method");
        return paramHelper;
    }

    protected boolean isExecuteRight(String paramHelper) {
        log.info("BaseFlowService----------isExecuteRight-----method");
        return false;
    }

    public static void setError(String paramHelper, String errCode, String errMsg) {
        log.info("BaseFlowService----------setError-----method");
    }

    protected String getStringByRoute(String paramHelper, String jsonPath) {
        log.info("BaseFlowService----------getStringByRoute-----method");
        return "";
    }

    protected String getStringByRouteNoConvert(String paramHelper, String jsonPath) {
        log.info("BaseFlowService----------getStringByRouteNoConvert-----method");
        return "";
    }

    protected String getStringByRouteWithCheck(String paramHelper, String jsonPath) {
        log.info("BaseFlowService----------getStringByRouteWithCheck-----method");
        return "";
    }

    protected boolean hasPath(String paramHelper, String jsonPath) {
        log.info("BaseFlowService----------hasPath-----method");
        return true;
    }

    protected String setValueByRoute(String paramHelper, String jsonpath, Object obj) {
        log.info("BaseFlowService----------setValueByRoute-----method");
        return "";
    }

    protected String queryRolesByMenuCode(String menuCode, String userNo) {
        log.info("BaseFlowService----------queryRolesByMenuCode-----method");
        return "";
    }

    protected boolean isNeedSubmit(String paramHelper) {
        log.info("BaseFlowService----------isNeedSubmit-----method");
        return true;
    }

    protected String queryCenterId(String centerCode, String brCode) {
        log.info("BaseFlowService----------queryCenterId-----method");
        return "";
    }
}
