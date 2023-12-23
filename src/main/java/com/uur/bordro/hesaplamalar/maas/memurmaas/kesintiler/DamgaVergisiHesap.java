package com.uur.bordro.hesaplamalar.maas.memurmaas.kesintiler;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.BordroUtils;
import com.uur.bordro.hesaplamalar.IKesinti;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

public class DamgaVergisiHesap implements IKesinti {
	public DamgaVergisiHesap(MemurMaasParametreBilgileri parametreBilgi, MemurMaasGirisBilgileri girisBilgileri,
			BigDecimal damgeVergisiMatrahi) {
		this.parametreBilgi = parametreBilgi;
		this.girisBilgileri = girisBilgileri;
		this.damgeVergisiMatrahi = damgeVergisiMatrahi;
	}

	private MemurMaasParametreBilgileri parametreBilgi;
	private MemurMaasGirisBilgileri girisBilgileri;
	private BigDecimal damgeVergisiMatrahi;

	@Override
	public BigDecimal getKesintiTutari() {
		return getDamgeVergisiTutari();
	}

	private BigDecimal getDamgeVergisiTutari() {
		return parametreBilgi.getDamgaVergisiOrani().multiply(damgeVergisiMatrahi).round(BordroUtils.getMathContext());
	}

	@Override
	public String getKesintiAdi() {
		// TODO Auto-generated method stub
		return "Damga Vergisi";
	}
}
