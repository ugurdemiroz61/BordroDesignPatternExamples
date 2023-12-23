package com.uur.bordro.hesaplamalar.maas;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.AileYardimiHesap.AileYardimiHesapBuilder;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class CocukYardimiHesap implements IHakedis {
	public CocukYardimiHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani,CocukYardimiHesapBuilder builder) {
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.gunOrani = gunOrani;
		this.isGelirVergisineTabii = builder.isGelirVergisineTabii;
		this.isDamgaVergisineTabii = builder.isDamgaVergisineTabii;
		this.isSendikaAidatinaTabii = builder.isSendikaAidatinaTabii;
	}
	
	private boolean isGelirVergisineTabii;
	private boolean isDamgaVergisineTabii;
	private boolean isSendikaAidatinaTabii;
	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal gunOrani;

	@Override
	public BigDecimal getHakedisTutari() {
		return getCocukYardimiTutari();
	}

	private BigDecimal getCocukYardimiTutari() {
		BigDecimal cocukYardimTutari = BigDecimal.ZERO;
		if (girisBilgileri.getBuyukCocukSayisi() > 0) {
			cocukYardimTutari.add(parametreBilgi.getMemurMaasKatsayisi()
					.multiply(new BigDecimal(parametreBilgi.getBuyukCocukYardimPuani()))
					.multiply(new BigDecimal(girisBilgileri.getBuyukCocukSayisi())).multiply(gunOrani)
					.round(BordroUtils.getMathContext()));
		}
		if (girisBilgileri.getKucukCocukSayisi() > 0) {
			cocukYardimTutari.add(parametreBilgi.getMemurMaasKatsayisi()
					.multiply(new BigDecimal(parametreBilgi.getKucukCocukYardimPuani()))
					.multiply(new BigDecimal(girisBilgileri.getKucukCocukSayisi())).multiply(gunOrani)
					.round(BordroUtils.getMathContext()));
		}
		return cocukYardimTutari;
	}

	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		if (isGelirVergisineTabii) {
			return getCocukYardimiTutari();
		}
		else {
			return BigDecimal.ZERO;
		}
	}

	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		if (isSendikaAidatinaTabii) {
			return getCocukYardimiTutari();
		}
		else {
			return BigDecimal.ZERO;
		}
	}

	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		if (isDamgaVergisineTabii) {
			return getCocukYardimiTutari();
		}
		else {
			return BigDecimal.ZERO;
		}
	}
	
	public static class CocukYardimiHesapBuilder {
		public CocukYardimiHesapBuilder() {
			this.isGelirVergisineTabii=false;
			this.isDamgaVergisineTabii=false;
			this.isSendikaAidatinaTabii =false;
		}
		private boolean isGelirVergisineTabii;
		private boolean isDamgaVergisineTabii;
		private boolean isSendikaAidatinaTabii;

		public CocukYardimiHesapBuilder setGelirVergisineTabii() {
			this.isGelirVergisineTabii = true;
			return this;
		}

		public CocukYardimiHesapBuilder setDamgaVergisineTabii() {
			this.isDamgaVergisineTabii = true;
			return this;
		}

		public CocukYardimiHesapBuilder setSendikaAidatinaTabii() {
			this.isSendikaAidatinaTabii = true;
			return this;
		}

		public CocukYardimiHesap build(MemurMaasParametreBilgileri parametreBilgi,
				MemurMaasGirisBilgileri girisBilgileri, BigDecimal gunOrani) {
			return new CocukYardimiHesap(parametreBilgi, girisBilgileri, gunOrani, this);
		}
	}

	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Çocuk Yardımı";
	}
}
