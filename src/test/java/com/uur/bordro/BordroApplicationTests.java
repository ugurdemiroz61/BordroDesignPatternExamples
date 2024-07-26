package com.uur.bordro;

import java.math.BigDecimal;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.EsCalismaDurumu;
import com.uur.bordro.hesaplamalar.maas.MedeniHali;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasBordro;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasBordroSekli;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

@SpringBootTest
class BordroApplicationTests {

	@Test
	void memurMaasBordroHesapla() {
		int personelNo=1;
		String adi = "uur";
		String soyadi = "dem";
		MemurMaasGirisBilgileri memurMaasGirisBilgileri = new MemurMaasGirisBilgileri(personelNo, adi, soyadi);
		memurMaasGirisBilgileri.setBolgeTazminatPuani(new BigDecimal(0.3));
		memurMaasGirisBilgileri.setBuyukCocukSayisi(2);
		memurMaasGirisBilgileri.setDengeTazminatiOrani(new BigDecimal(1.36));
		memurMaasGirisBilgileri.setDoktor(true);
		memurMaasGirisBilgileri.setEkGostergePuani(4400);
		memurMaasGirisBilgileri.setEmekliKidemYili(15);

		memurMaasGirisBilgileri.setGostergePuani(1100);
		memurMaasGirisBilgileri.setIcraOrani(new BigDecimal(0));
		memurMaasGirisBilgileri.setIcraOraniYuzde(new BigDecimal(0));
		memurMaasGirisBilgileri.setKidemYili(15);
		memurMaasGirisBilgileri.setKucukCocukSayisi(1);
		memurMaasGirisBilgileri.setMaasGunSayisi(31);
		memurMaasGirisBilgileri.setMedeniHali(MedeniHali.Evli);
		memurMaasGirisBilgileri.setEsCalismaDurumu(EsCalismaDurumu.Calismiyor);
		memurMaasGirisBilgileri.setOzelHizmetPuani(new BigDecimal(1.3));
		memurMaasGirisBilgileri.setPersonelNo(15);
		memurMaasGirisBilgileri.setPoliceMatrahVergiIndirimi(new BigDecimal(300));
		memurMaasGirisBilgileri.setSabitOdemeOrani(new BigDecimal(3.35));
		memurMaasGirisBilgileri.setSakatlikMatrahVergiIndirimi(new BigDecimal(1000));
		memurMaasGirisBilgileri.setSendikaKesintiOrani(new BigDecimal(0.5));
		memurMaasGirisBilgileri.setSendikali(true);
		memurMaasGirisBilgileri.setSendikasiYuzdelikDilimAltinda(false);
		memurMaasGirisBilgileri.setSuregelenToplamVergiMatrahi(new BigDecimal(75000));
		memurMaasGirisBilgileri.setYanOdemePuani(3000);
		
		MemurMaasParametreBilgileri memurMaasParametreBilgileri = new MemurMaasParametreBilgileri();
		memurMaasParametreBilgileri.setAyinGunSayisi(31);
		memurMaasParametreBilgileri.setBordroSekli(MemurMaasBordroSekli.NORMAL);
		memurMaasParametreBilgileri.setEmekliSandigiAyinGunSiniri(30);
		memurMaasParametreBilgileri.setEnYuksekDevletMemurMaasi(new BigDecimal(4843.062));
		memurMaasParametreBilgileri.setMemurMaasKatsayisi(new BigDecimal(0.509796));
		memurMaasParametreBilgileri.setTabanAylikKatsayisi(new BigDecimal(7.979285));
		memurMaasParametreBilgileri.setTabanAylikOrani(1000);
		memurMaasParametreBilgileri.setYanOdemeKatsayisi(new BigDecimal(0.161673));
		memurMaasParametreBilgileri.setDamgaVergisiOrani(new BigDecimal(0.000759));
		MemurMaasBordro bordro = new MemurMaasBordro(memurMaasGirisBilgileri,memurMaasParametreBilgileri);
		bordro.hesapla();
		for (Iterator<IHakedis> iterator = bordro.hakedisler.iterator(); iterator.hasNext();) {
			IHakedis hakedis = (IHakedis) iterator.next();
			System.out.println(hakedis.getHakedisAdi()+": "+ hakedis.getHakedisTutari().toPlainString());
		}
	}

}
