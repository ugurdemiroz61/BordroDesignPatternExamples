package com.uur.bordro.hesaplamalar.maas.memurmaas;

import java.math.BigDecimal;
import java.util.List;

import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.IKesinti;

public class MemurMaasFarkFactory implements IMemurMaasFactory{
	private MemurMaasParametreBilgileri memurMaasParametreBilgileri;
	private MemurMaasGirisBilgileri memurMaasGirisBilgileri;
	
	public MemurMaasFarkFactory(MemurMaasParametreBilgileri memurMaasParametreBilgileri,MemurMaasGirisBilgileri memurMaasGirisBilgileri) {
		this.memurMaasParametreBilgileri = memurMaasParametreBilgileri;
		this.memurMaasGirisBilgileri = memurMaasGirisBilgileri;
	}
	@Override
	public IHakedis createTabanAylik() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IHakedis createAylikTutar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IHakedis createEkGostergeTutar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IHakedis createYanOdeme() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getGunOrani() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BigDecimal getPrimGunOrani() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPrimGunu() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public IHakedis createOzelHizmet() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IHakedis createBolgeTazminati() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IHakedis createKidemAylik() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IHakedis createAileYardimi() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IHakedis createCocukYardimi() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IHakedis createSendikaTazminati() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IHakedis createSeyyaneTutari() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IHakedis createSabitOdemeTutari() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IHakedis createDengeTazminati() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IKesinti createDamgaVergisi(List<IHakedis> hakedisler) {
		// TODO Auto-generated method stub
		return null;
	}



}
