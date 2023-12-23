package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.EsCalismaDurumu;
import com.uur.bordro.hesaplamalar.maas.MedeniHali;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class SabitOdemeHesap implements IHakedis {
	public SabitOdemeHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
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
		return getSabitOdemeTutari();
	}

	private BigDecimal getSabitOdemeTutari() {
		BigDecimal sabitOdemeTutari = BigDecimal.ZERO;
		if (girisBilgileri.isDoktor()) {
			sabitOdemeTutari = parametreBilgi.getMemurMaasKatsayisi().multiply(girisBilgileri.getSabitOdemeOrani())
					.multiply(gunOrani).round(BordroUtils.getMathContext());
		}
		return sabitOdemeTutari;
	}

	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return getSabitOdemeTutari();
	}

	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return BigDecimal.ZERO;
	}

	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getSabitOdemeTutari();
	}

	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Sabit Ödeme Tutarı";
	}
}
