package com.pichincha.Cliente.utils;

import java.util.Date;

public final class PichinchaUtil {

	public static boolean esCampoLleno(String campo) {
		if (null == campo || campo.isEmpty() || campo.isBlank()) {
			return false;
		}
		return true;
	}

	public static boolean esCampoLleno(Date campo) {
		if (null == campo) {
			return false;
		}
		return true;
	}

	public static boolean esCampoLleno(int campo) {
		if (0 == campo) {
			return false;
		}
		return true;
	}

	public static boolean esCampoLleno(double campo) {
		if (0 == campo) {
			return false;
		}
		return true;
	}

}
