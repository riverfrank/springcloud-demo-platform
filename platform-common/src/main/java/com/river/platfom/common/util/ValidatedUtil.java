package com.river.platfom.common.util;


import com.river.platfom.common.ReturnCode;
import com.river.platfom.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * @author river
 */
public class ValidatedUtil {

	public static void notNull(Object value){
		if (value == null) {
			BizException.throwException(ReturnCode.DATA_VALID_ERROR);
		}
	}

	public static void notNull(Object value,String desc){
		if (value == null) {
			BizException.throwException(ReturnCode.DATA_VALID_ERROR,desc);
		}
	}

	public static void notNull(Object value,ReturnCode msgConstantEnum){
		if (value == null) {
			BizException.throwException(msgConstantEnum);
		}
	}


	public static void notBlank(Object value) {
		notBlank(value,"");
	}

	public static void notBlank(Object value,String desc) {
		if (value == null) {
			BizException.throwException(ReturnCode.DATA_VALID_ERROR,desc);
		}
		if (value instanceof CharSequence) {
			if (StringUtils.isBlank((CharSequence) value)) {
				BizException.throwException(ReturnCode.DATA_VALID_ERROR,desc);
			}
		}
		if (value instanceof Collection) {
			if (CollectionUtils.isEmpty((Collection) value)) {
				BizException.throwException(ReturnCode.DATA_VALID_ERROR,desc);
			}
		}
		if (value.getClass().isArray()) {
			if (Array.getLength(value) == 0) {
				BizException.throwException(ReturnCode.DATA_VALID_ERROR,desc);
			}
		}
	}
	public static void verify(boolean expression, ReturnCode msgConstantEnum) {
		if (!expression) {
			BizException.throwException(msgConstantEnum);
		}

	}
	public static void verify(boolean expression, String desc) {
		if (!expression) {
			BizException.throwException(9, desc);
		}

	}

	public static void verify(boolean expression, int code, String desc) {
		if (!expression) {
			BizException.throwException(code, desc);
		}

	}

}
