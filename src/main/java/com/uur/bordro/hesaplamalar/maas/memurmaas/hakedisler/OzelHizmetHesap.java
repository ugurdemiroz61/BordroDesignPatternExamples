package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class OzelHizmetHesap implements IHakedis {

	public OzelHizmetHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani) {
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.gunOrani = gunOrani;
	}

	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal gunOrani;
	private BigDecimal getOzelHizmetTutari() {
		BigDecimal ozelHizmetTutari = girisBilgileri.getOzelHizmetPuani().multiply(parametreBilgi.getEnYuksekDevletMemurMaasi()).multiply(gunOrani).round(BordroUtils.getMathContext());
		return ozelHizmetTutari;
	}
	@Override
	public BigDecimal getHakedisTutari() {
		return getOzelHizmetTutari();
	}

	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return getOzelHizmetTutari();
	}

	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getOzelHizmetTutari();
	}
	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Özel Hizmet Tutarı";
	}

}
