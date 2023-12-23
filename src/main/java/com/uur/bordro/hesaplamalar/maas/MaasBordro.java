package com.uur.bordro.hesaplamalar.maas;

import java.math.BigDecimal;
import java.util.List;

import com.uur.bordro.hesaplamalar.Bordro;
import com.uur.bordro.hesaplamalar.IHakedis;

public abstract class MaasBordro extends Bordro {
	public MaasBordro() {
		super();
	}

	protected BigDecimal getAylikVergiMatrahi() {
		BigDecimal aylikVergiMatrahi = BigDecimal.ZERO;
		for (IHakedis hakedis : super.hakedisler) {
			aylikVergiMatrahi.add(hakedis.getGelirVergisiMatrahi());
		}
		return aylikVergiMatrahi;
	}

	protected BigDecimal getDamgaVergisiMatrahi() {
		BigDecimal damgaVergisiMatrahi = BigDecimal.ZERO;
		for (IHakedis hakedis : super.hakedisler) {
			damgaVergisiMatrahi.add(hakedis.getDamgaVergisiMatrahi());
		}
		return damgaVergisiMatrahi;
	}

	protected BigDecimal getSendikaAidatiMatrahi() {
		BigDecimal sendikaAidati = BigDecimal.ZERO;
		for (IHakedis hakedis : super.hakedisler) {
			sendikaAidati.add(hakedis.getSendikaAidatiMatrahi());
		}
		return sendikaAidati;
	}
}
