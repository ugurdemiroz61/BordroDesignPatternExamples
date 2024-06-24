package com.uur.bordro.hesaplamalar.maas.memurmaas;

import java.math.BigDecimal;
import java.util.List;

import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.IKesinti;

public interface IMemurMaasFactory {
	IHakedis createTabanAylik();

	IHakedis createAylikTutar();

	IHakedis createEkGostergeTutar();

	IHakedis createYanOdeme();
	
	IHakedis createOzelHizmet();
	
	IHakedis createKidemAylik();
	
	IHakedis createBolgeTazminati();
	
	IHakedis createAileYardimi();
	
	IHakedis createCocukYardimi();
	
	IHakedis createSendikaTazminati();
	
	IHakedis createSeyyaneTutari();
	
	IHakedis createSabitOdemeTutari();
	
	IHakedis createDengeTazminati();
	
	IKesinti createDamgaVergisi(List<IHakedis> hakedisler) ;

	BigDecimal getGunOrani();

	BigDecimal getPrimGunOrani();

	public int getPrimGunu();
}
