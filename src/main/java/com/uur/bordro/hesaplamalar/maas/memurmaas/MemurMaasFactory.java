package com.uur.bordro.hesaplamalar.maas.memurmaas;

import java.math.BigDecimal;
import java.util.List;

import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.IKesinti;
import com.uur.bordro.hesaplamalar.maas.AileYardimiHesap;
import com.uur.bordro.hesaplamalar.maas.CocukYardimiHesap;
import com.uur.bordro.hesaplamalar.maas.AileYardimiHesap.AileYardimiHesapBuilder;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.AylikTutarHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.BolgeTazminatiHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.DengeTazminatiHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.EkGostergeTutarHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.KidemAylikHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.OzelHizmetHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.SabitOdemeHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.SendikaTazminatiHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.SeyyaneTutarHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.TabanAylikHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.hakedisler.YanOdemeHesap;
import com.uur.bordro.hesaplamalar.maas.memurmaas.kesintiler.DamgaVergisiHesap;

public class MemurMaasFactory implements IMemurMaasFactory {
	private MemurMaasParametreBilgileri memurMaasParametreBilgileri;
	private MemurMaasGirisBilgileri memurMaasGirisBilgileri;
	
	public MemurMaasFactory(MemurMaasParametreBilgileri memurMaasParametreBilgileri,MemurMaasGirisBilgileri memurMaasGirisBilgileri) {
		this.memurMaasParametreBilgileri = memurMaasParametreBilgileri;
		this.memurMaasGirisBilgileri = memurMaasGirisBilgileri;
	}

	public IHakedis createTabanAylik() {
		return new TabanAylikHesap(memurMaasParametreBilgileri,  memurMaasGirisBilgileri, getGunOrani());
	}

	@Override
	public IHakedis createAylikTutar() {
		return new AylikTutarHesap(memurMaasParametreBilgileri,  memurMaasGirisBilgileri, getGunOrani());
	}

	@Override
	public IHakedis createEkGostergeTutar() {
		return new EkGostergeTutarHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}

	@Override
	public IHakedis createYanOdeme() {
		return new YanOdemeHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}
	
	public IHakedis createKidemAylik() {
		return new KidemAylikHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani(),memurMaasGirisBilgileri.getKidemYili());
	}
	
	@Override
	public IHakedis createOzelHizmet() {
		return new OzelHizmetHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}
	
	public IHakedis createBolgeTazminati() {
		return new BolgeTazminatiHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}
	
	
	@Override
	public IHakedis createAileYardimi() {
		return new AileYardimiHesap.AileYardimiHesapBuilder().setGelirVergisineTabii().setDamgaVergisineTabii().setSendikaAidatinaTabii().build(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}

	@Override
	public IHakedis createCocukYardimi() {
		return new CocukYardimiHesap.CocukYardimiHesapBuilder().setDamgaVergisineTabii().setGelirVergisineTabii().setSendikaAidatinaTabii().build(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}

	@Override
	public IHakedis createSendikaTazminati() {
		return new SendikaTazminatiHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}

	@Override
	public IHakedis createSeyyaneTutari() {
		return new SeyyaneTutarHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}

	@Override
	public IHakedis createSabitOdemeTutari() {
		return new SabitOdemeHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}

	@Override
	public IHakedis createDengeTazminati() {
		return new DengeTazminatiHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri, getGunOrani());
	}
	@Override
	public BigDecimal getGunOrani() {
		BigDecimal gunOrani = new BigDecimal(memurMaasGirisBilgileri.getMaasGunSayisi()).divide(new BigDecimal(memurMaasParametreBilgileri.getAyinGunSayisi()));
		return gunOrani;
	}

	@Override
	public BigDecimal getPrimGunOrani() {
		int primGunu = getPrimGunu();
		BigDecimal primGunOrani = new BigDecimal(primGunu).divide(new BigDecimal(memurMaasParametreBilgileri.getEmekliSandigiAyinGunSiniri()));
		return primGunOrani;
	}
	@Override
	public int getPrimGunu() {
		int primGunu = memurMaasParametreBilgileri.getEmekliSandigiAyinGunSiniri();
		if (memurMaasGirisBilgileri.getMaasGunSayisi() != memurMaasParametreBilgileri.getAyinGunSayisi()) {
			int eksikGunu = memurMaasParametreBilgileri.getEmekliSandigiAyinGunSiniri()
					- memurMaasGirisBilgileri.getMaasGunSayisi();
			primGunu -= eksikGunu;
		}
		return primGunu;
	}

	@Override
	public IKesinti createDamgaVergisi(List<IHakedis> hakedisler){
		return new DamgaVergisiHesap(memurMaasParametreBilgileri, memurMaasGirisBilgileri,hakedisler);
	}

	
}
