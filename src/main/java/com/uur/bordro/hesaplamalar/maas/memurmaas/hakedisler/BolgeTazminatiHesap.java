package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class BolgeTazminatiHesap implements IHakedis {

	public BolgeTazminatiHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani) {
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.gunOrani = gunOrani;
	}

	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal gunOrani;
	private BigDecimal getBolgeTazminatiTutari() {
		BigDecimal bolgeTazminati = girisBilgileri.getBolgeTazminatPuani().multiply(parametreBilgi.getEnYuksekDevletMemurMaasi()).multiply(gunOrani).round(BordroUtils.getMathContext());
		return bolgeTazminati;
	}
	@Override
	public BigDecimal getHakedisTutari() {
		return getBolgeTazminatiTutari();
	}

	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return getBolgeTazminatiTutari();
	}

	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getBolgeTazminatiTutari();
	}
	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Bölge Tazminatı";
	}

}
