package com.uur.bordro.hesaplamalar;

import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Value;

public class BordroUtils   {
	
	//@Value("${yuvarlamahanesi}")
	private static int TLYuvarlamaHanesi =3;
	
	public static int getTLYuvarlamaHanesi() {
		return TLYuvarlamaHanesi;
	}

	public static MathContext getMathContext() {
		return MathContextHelper.mathContext;
	}
	private static class MathContextHelper{
		private static final MathContext mathContext = new MathContext(TLYuvarlamaHanesi,RoundingMode.HALF_UP);
	}
}
