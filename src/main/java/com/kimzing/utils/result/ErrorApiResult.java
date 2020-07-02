package com.kimzing.utils.result;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 成功返回体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/12/4 17:19
 */
public final class ErrorApiResult extends ApiResult {

    public ErrorApiResult(String... codes) {
        this.ts = System.currentTimeMillis();
        List<String> codeList = Arrays.asList(codes);
        this.code = codeList.stream().collect(Collectors.joining(","));
        this.message = codeList.stream().map(c -> getMessageByCode(c)).collect(Collectors.joining(","));
    }

    public ErrorApiResult(String code, String message) {
        this.ts = System.currentTimeMillis();
        this.code = code;
        this.message = message;
    }
}
