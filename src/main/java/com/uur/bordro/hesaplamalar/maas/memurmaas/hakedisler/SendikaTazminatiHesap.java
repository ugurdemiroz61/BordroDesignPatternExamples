package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.EsCalismaDurumu;
import com.uur.bordro.hesaplamalar.maas.MedeniHali;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class SendikaTazminatiHesap implements IHakedis {
	public SendikaTazminatiHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
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
		return getSendikaTazminatiTutari();
	}

	private BigDecimal getSendikaTazminatiTutari() {
		BigDecimal sendikaTazminatiTutari = BigDecimal.ZERO;
		if (girisBilgileri.isSendikali()) {
			int sendikaTazminatiKatsayisi = parametreBilgi.getSendikaTazminatiKatsayisi();
			if (girisBilgileri.isSendikasiYuzdelikDilimAltinda()) {
				sendikaTazminatiKatsayisi = parametreBilgi.getSendikaTazminatiKatsayisiYuzdelikDilimAltinda();
			}
			sendikaTazminatiTutari = parametreBilgi.getMemurMaasKatsayisi()
					.multiply(new BigDecimal(sendikaTazminatiKatsayisi)).multiply(gunOrani)
					.round(BordroUtils.getMathContext());
		}
		return sendikaTazminatiTutari;
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
		return getSendikaTazminatiTutari();
	}

	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Sendika Tazminatı";
	}
}
