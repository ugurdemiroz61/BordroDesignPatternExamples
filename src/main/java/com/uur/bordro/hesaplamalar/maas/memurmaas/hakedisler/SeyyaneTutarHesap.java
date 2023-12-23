package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.EsCalismaDurumu;
import com.uur.bordro.hesaplamalar.maas.MedeniHali;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class SeyyaneTutarHesap implements IHakedis {
	public SeyyaneTutarHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani) {
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.gunOrani = gunOrani;
	}

	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal gunOrani;

	@Override
	public BigDecimal getHakedisTutari() {
		return getSeyyaneTutari();
	}

	private BigDecimal getSeyyaneTutari() {
		BigDecimal seyyaneTutari = BigDecimal.ZERO;
		seyyaneTutari = parametreBilgi.getMemurMaasKatsayisi()
				.multiply(new BigDecimal(parametreBilgi.getSeyyaneTutarKatsayisi())).multiply(gunOrani)
				.round(BordroUtils.getMathContext());
		return seyyaneTutari;
	}

	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getSeyyaneTutari();
	}

	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Seyyane Tutarı";
	}
}
