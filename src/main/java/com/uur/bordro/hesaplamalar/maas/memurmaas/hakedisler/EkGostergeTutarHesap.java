package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class EkGostergeTutarHesap implements IHakedis {
	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal gunOrani;

	public EkGostergeTutarHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani) {
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.gunOrani = gunOrani;
	}

	private BigDecimal getEkGostergeTutar() {
		BigDecimal ekGostergeTutar = parametreBilgi.getMemurMaasKatsayisi()
				.multiply(new BigDecimal(girisBilgileri.getEkGostergePuani())).multiply(gunOrani)
				.round(BordroUtils.getMathContext());
		return ekGostergeTutar;
	}

	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return getEkGostergeTutar();
	}

	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getEkGostergeTutar();
	}

	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return getEkGostergeTutar();
	}

	@Override
	public BigDecimal getHakedisTutari() {
		return getEkGostergeTutar();
	}

	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Ek Gösterge Tutarı";
	}

}
