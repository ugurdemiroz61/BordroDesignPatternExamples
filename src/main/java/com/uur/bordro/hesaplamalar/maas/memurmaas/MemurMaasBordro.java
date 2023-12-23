package com.uur.bordro.hesaplamalar.maas.memurmaas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.IKesinti;
import com.uur.bordro.hesaplamalar.maas.MaasBordro;

public class MemurMaasBordro extends MaasBordro {
	private MemurMaasGirisBilgileri memurMaasGirisBilgileri;
	private MemurMaasParametreBilgileri memurMaasParametreBilgileri;
	private IMemurMaasFactory memurMaasFactory;

	public MemurMaasBordro(MemurMaasGirisBilgileri memurMaasGirisBilgileri,
			MemurMaasParametreBilgileri memurMaasParametreBilgileri) {
		super();
		this.memurMaasGirisBilgileri = memurMaasGirisBilgileri;
		this.memurMaasParametreBilgileri = memurMaasParametreBilgileri;

		switch (memurMaasParametreBilgileri.getBordroSekli()) {
		case NORMAL: {
			memurMaasFactory = new MemurMaasFactory(memurMaasParametreBilgileri, memurMaasGirisBilgileri);
		}
		case FARK: {
			memurMaasFactory = new MemurMaasFarkFactory(memurMaasParametreBilgileri, memurMaasGirisBilgileri);
		}
		default:
			memurMaasFactory = new MemurMaasFactory(memurMaasParametreBilgileri, memurMaasGirisBilgileri);
		}
	}

	@Override
	public void hesapla() {
		hakedisleriHesapla();
		kesintileriHesapla();
		BigDecimal HakedisToplami = this.getHakedisToplami();
		BigDecimal KesintiToplami = this.getKesintiToplami();
	}

	private void hakedisleriHesapla() {
		super.hakedisler = new ArrayList<IHakedis>();
		IHakedis tabanAylik = memurMaasFactory.createTabanAylik();
		super.hakedisler.add(tabanAylik);
		IHakedis aylikTutar = memurMaasFactory.createAylikTutar();
		super.hakedisler.add(aylikTutar);
		IHakedis ekGosterge = memurMaasFactory.createEkGostergeTutar();
		super.hakedisler.add(ekGosterge);
		IHakedis yanOdeme = memurMaasFactory.createYanOdeme();
		super.hakedisler.add(yanOdeme);
		IHakedis ozelHizmet = memurMaasFactory.createOzelHizmet();
		super.hakedisler.add(ozelHizmet);
		IHakedis kidemAylik = memurMaasFactory.createKidemAylik();
		super.hakedisler.add(kidemAylik);
		IHakedis bolgeTazminati = memurMaasFactory.createBolgeTazminati();
		super.hakedisler.add(bolgeTazminati);
		IHakedis aileYardimi = memurMaasFactory.createAileYardimi();
		super.hakedisler.add(aileYardimi);
		IHakedis cocukYardimi = memurMaasFactory.createCocukYardimi();
		super.hakedisler.add(cocukYardimi);
		IHakedis sendikaTazminati = memurMaasFactory.createSendikaTazminati();
		super.hakedisler.add(sendikaTazminati);
		IHakedis seyyaneTutar = memurMaasFactory.createSeyyaneTutari();
		super.hakedisler.add(seyyaneTutar);
		IHakedis sabitOdeme = memurMaasFactory.createSeyyaneTutari();
		super.hakedisler.add(sabitOdeme);
		IHakedis dengeTazminati = memurMaasFactory.createDengeTazminati();
		super.hakedisler.add(dengeTazminati);
	}

	private void kesintileriHesapla() {
		super.kesintiler = new ArrayList<IKesinti>();
		BigDecimal damgaVergisiMatrahi = super.hakedisler.stream().map(x -> x.getDamgaVergisiMatrahi()).reduce(BigDecimal.ZERO, BigDecimal::add);
		super.kesintiler.add(memurMaasFactory.createDamgaVergisi(damgaVergisiMatrahi));
		
	}
}
