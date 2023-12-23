package com.uur.bordro.hesaplamalar.maas;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class AileYardimiHesap implements IHakedis {
	public AileYardimiHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal gunOrani, AileYardimiHesapBuilder builder) {
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
		return getAileYardimiTutari();
	}

	private BigDecimal getAileYardimiTutari() {
		BigDecimal aileYardimTutari = BigDecimal.ZERO;
		if (girisBilgileri.getEsCalismaDurumu() == EsCalismaDurumu.Calisiyor
				&& girisBilgileri.getMedeniHali() == MedeniHali.Evli) {
			aileYardimTutari = parametreBilgi.getMemurMaasKatsayisi()
					.multiply(new BigDecimal(parametreBilgi.getAileYardimPuani())).multiply(gunOrani)
					.round(BordroUtils.getMathContext());
		}
		return aileYardimTutari;
	}

	@Override
	public BigDecimal getGelirVergisiMatrahi() {
		if (isGelirVergisineTabii) {
			return getAileYardimiTutari();
		}
		else {
			return BigDecimal.ZERO;
		}
	}

	@Override
	public BigDecimal getSendikaAidatiMatrahi() {
		if (isSendikaAidatinaTabii) {
			return getAileYardimiTutari();
		}
		else {
			return BigDecimal.ZERO;
		}
	}

	@Override
	public BigDecimal getDamgaVergisiMatrahi() {
		if (isDamgaVergisineTabii) {
			return getAileYardimiTutari();
		}
		else {
			return BigDecimal.ZERO;
		}
	}

	public static class AileYardimiHesapBuilder {
		public AileYardimiHesapBuilder() {
			this.isGelirVergisineTabii=false;
			this.isDamgaVergisineTabii=false;
			this.isSendikaAidatinaTabii =false;
		}
		private boolean isGelirVergisineTabii;
		private boolean isDamgaVergisineTabii;
		private boolean isSendikaAidatinaTabii;

		public AileYardimiHesapBuilder setGelirVergisineTabii() {
			this.isGelirVergisineTabii = true;
			return this;
		}

		public AileYardimiHesapBuilder setDamgaVergisineTabii() {
			this.isDamgaVergisineTabii = true;
			return this;
		}

		public AileYardimiHesapBuilder setSendikaAidatinaTabii() {
			this.isSendikaAidatinaTabii = true;
			return this;
		}

		public AileYardimiHesap build(MemurMaasParametreBilgileri parametreBilgi,
				MemurMaasGirisBilgileri girisBilgileri, BigDecimal gunOrani) {
			return new AileYardimiHesap(parametreBilgi, girisBilgileri, gunOrani, this);
		}
	}

	@Override
	public String getHakedisAdi() {
		// TODO Auto-generated method stub
		return "Aile yardımı";
	}
}
