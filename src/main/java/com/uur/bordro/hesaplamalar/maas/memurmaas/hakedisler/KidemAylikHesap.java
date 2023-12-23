package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class KidemAylikHesap implements IHakedis{

	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal gunOrani;
	private int kidemYili;
	
	public KidemAylikHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani,int kidemYili) {
		super();
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.gunOrani = gunOrani;
		this.kidemYili = kidemYili;
	}

	@Override
	public BigDecimal getHakedisTutari() {
		return getKidemAylik();
	}

	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return getKidemAylik();
	}

	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return getKidemAylik();
	}

	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getKidemAylik();
	}
	private BigDecimal getKidemAylik() {
		BigDecimal kidemAylik = parametreBilgi.getMemurMaasKatsayisi().multiply(new BigDecimal(kidemYili)).multiply(new BigDecimal(parametreBilgi.getKidemYilKatsayisi())).multiply(gunOrani).round(BordroUtils.getMathContext());
		return kidemAylik;
	}

	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Kıdem Aylık Tutarı";
	}
}