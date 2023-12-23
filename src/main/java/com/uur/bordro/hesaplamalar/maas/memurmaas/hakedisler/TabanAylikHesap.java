package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class TabanAylikHesap implements IHakedis {

	public TabanAylikHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
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
		return getTabanAylikTutari();
	}
	private BigDecimal getTabanAylikTutari() {
		BigDecimal tabanAylikTutari = parametreBilgi.getTabanAylikKatsayisi().multiply(new BigDecimal(parametreBilgi.getTabanAylikOrani())).multiply(gunOrani).round(BordroUtils.getMathContext());
		return tabanAylikTutari;
	}
	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return getTabanAylikTutari();
	}
	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return getTabanAylikTutari();
	}
	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getTabanAylikTutari();
	}
	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Taban Aylık Tutarı";
	}
	
}
