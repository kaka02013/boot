package com.lps.boot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lps.boot.reflect.ReflectBean;
import com.lps.boot.reflect.ReflectHandler;
import com.lps.boot.service.TestService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    private static final ObjectMapper mapper = new ObjectMapper();

    private final TestService testService;

    @Resource
    ConfigurableApplicationContext context;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @SneakyThrows
    @PostMapping("/doPost")
    public String doPost(@RequestBody String jsonStr) {
        log.info("请求参数合并：{}", jsonStr);
        log.info("dev修改");
        Thread.sleep(50000);
        testService.test();
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("name", "danier");
        map.put("age", 19);
        map.put("birthday", "19921019");
        return mapper.writeValueAsString(map);
    }

    @GetMapping("/reflect")
    public String reflect() {
        String paramHelper = (String) ReflectHandler.invoke(new ReflectBean("batchCreateProcessServiceImpl", "execute"), new Object[]{""}, this.context);
        return "OK";
    }
}
