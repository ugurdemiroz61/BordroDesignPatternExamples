package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class AylikTutarHesap  implements IHakedis {
	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal gunOrani;

	public AylikTutarHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani) {
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.gunOrani = gunOrani;
	}
	
	@Override
	public BigDecimal getHakedisTutari() {
		return getAylikTutar();
	}
	
	private BigDecimal getAylikTutar() {
		BigDecimal aylikTutar = parametreBilgi.getMemurMaasKatsayisi().multiply(new BigDecimal(girisBilgileri.getGostergePuani())).multiply(gunOrani).round(BordroUtils.getMathContext());
		return aylikTutar;
	}
	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return getAylikTutar();
	}
	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getAylikTutar();
	}
	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return getAylikTutar();
	}

	@Override
	public String getHakedisAdi() {
		return "Aylık Tutarı";
	}
}
