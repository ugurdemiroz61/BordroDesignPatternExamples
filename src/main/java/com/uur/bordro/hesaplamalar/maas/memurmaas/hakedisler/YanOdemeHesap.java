package com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class YanOdemeHesap implements IHakedis{
	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal gunOrani;
	public YanOdemeHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani) {
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.gunOrani = gunOrani;
	}
	private BigDecimal getYanOdemeHesapla() {
		BigDecimal yanOdemeTutari = parametreBilgi.getYanOdemeKatsayisi().multiply(new BigDecimal(girisBilgileri.getYanOdemePuani())).multiply(gunOrani).round(BordroUtils.getMathContext());
		return yanOdemeTutari;
	}
	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		return getYanOdemeHesapla();
	}
	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		return getYanOdemeHesapla();
	}
	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		return getYanOdemeHesapla();
	}
	@Override
	public BigDecimal getHakedisTutari() {
		return getYanOdemeHesapla();
	}
	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Yan Ödeme Tutarı";
	}
}
