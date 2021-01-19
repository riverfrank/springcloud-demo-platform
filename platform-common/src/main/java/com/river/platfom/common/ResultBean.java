package com.river.platfom.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 数据统一返回模型
 *
 * @author Young
 * @description
 * @date 2020/6/23
 */

@Data
public class ResultBean<T> implements Serializable {


	/**
	 * 操作码
	 */
	private Integer code;
	/**
	 * 提供给开发人员看的信息
	 */
	private String errorMsg;
	/**
	 * 需要提示用户的信息
	 */
	private String message;
	/**
	 * 请求返回数据
	 */
	private T data;



	public ResultBean(Integer code, String message, String errorMsg, T data) {
		this.code = code;
		this.message = message;
		this.errorMsg = errorMsg;
		this.data = data;
	}

	/**
	 * 操作成功，返回数据结果集
	 *
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> ResultBean<T> success(T data) {
		return new ResultBean(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMessage(), "", data);
	}

	/**
	 * 操作失败
	 *
	 * @param <T>
	 * @return
	 */
	public static <T> ResultBean<T> fail(ReturnCode returnCode) {
		return  ResultBean.fail(returnCode.getCode(), returnCode.getMessage());
	}
	public static <T> ResultBean<T> fail(Integer code, String message) {
		return new ResultBean(code, message, message, null);
	}

	/**
	 * 操作失败
	 *
	 * @param <T>
	 * @return
	 */
	public static <T> ResultBean<T> fail(Integer code, String exceptionMessage, String userMessage) {
		return new ResultBean(code, exceptionMessage, userMessage, null);
	}
}
