/*
 * Copyright (c) 2018-present the original author or authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.flora;

import java.util.HashMap;
import java.util.Map;

import org.flora.FloraException;
import org.flora.common.ResponseCodes;

public class DefaultResult<T> implements Result<T> {

	/**
	 * 创建一个成功的结果，不含 payload
	 */
	public static Result<?> newResult() {
		DefaultResult<?> result = new DefaultResult<>();
		result.status = Result.STATUS_SUCCESS;
		result.responseCode = ResponseCodes.RESPONSE_CODE_SUCCESS;
		return result;
	}

	/**
	 * 创建一个成功的结果
	 * 
	 * @param payload 结果中的数据
	 * @return 新创建的交易结果
	 */
	public static <T> Result<T> newResult(T payload) {
		DefaultResult<T> result = new DefaultResult<>();
		result.status = Result.STATUS_SUCCESS;
		result.responseCode = ResponseCodes.RESPONSE_CODE_SUCCESS;
		result.payload = payload;
		return result;
	}

	/**
	 * 创建一个失败的结果
	 * 
	 * @param ex 导致交易失败的具体异常
	 * @return 新创建的交易结果
	 */
	public static <T> Result<T> newFailResult(Throwable ex) {
		DefaultResult<T> result = new DefaultResult<>();
		result.status = Result.STATUS_FAIL;
		result.responseMessage = ex.getMessage();
		result.responseCode = (ex instanceof FloraException) ? ((FloraException) ex).getCode()
				: ResponseCodes.RESPONSE_CODE_SYSTEM_ERROR;
		return result;
	}

	/**
	 * 创建一个具有指定错误消息的失败结果
	 * 
	 * @param message 错误消息
	 * @return 新创建的交易结果
	 */
	public static <T> Result<T> newFailResult(String message) {
		DefaultResult<T> result = new DefaultResult<>();
		result.status = Result.STATUS_FAIL;
		result.responseMessage = message;
		result.responseCode = ResponseCodes.RESPONSE_CODE_SYSTEM_ERROR;
		return result;
	}

	private DefaultResult() {
	}

	private Map<String, Object> headers = new HashMap<>();

	private int status;

	private T payload;

	private String responseCode;

	private String responseMessage;

	@Override
	public int getStatus() {
		return status;
	}

	@Override
	public boolean isSuccess() {
		return Result.STATUS_SUCCESS == status;
	}

	@Override
	public String getResponseCode() {
		return responseCode;
	}

	@Override
	public String getResponseMessage() {
		return responseMessage;
	}

	@Override
	public T getPayload() {
		return payload;
	}

	@Override
	public Map<String, Object> getHeaders() {
		return headers;
	}

	@Override
	public Result<T> setHeader(String key, Object value) {
		headers.put(key, value);
		return this;
	}

	@Override
	public Object getHeader(String key) {
		return headers.get(key);
	}
}
