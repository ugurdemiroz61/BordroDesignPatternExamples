package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.EsCalismaDurumu;
import com.uur.bordro.hesaplamalar.maas.MedeniHali;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class DengeTazminatiHesap implements IHakedis {
	public DengeTazminatiHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
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
		return getDengeTazminatiTutari();
	}

	private BigDecimal getDengeTazminatiTutari() {
		BigDecimal dengeTutari = BigDecimal.ZERO;
		dengeTutari = parametreBilgi.getMemurMaasKatsayisi().multiply(girisBilgileri.getDengeTazminatiOrani())
				.multiply(gunOrani).round(BordroUtils.getMathContext());
		return dengeTutari;
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
		return getDengeTazminatiTutari();
	}

	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Denge Tazminatı";
	}
}
