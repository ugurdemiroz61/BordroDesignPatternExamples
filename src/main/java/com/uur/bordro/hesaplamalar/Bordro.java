package com.uur.bordro.hesaplamalar;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public abstract class Bordro {

	public List<IHakedis> hakedisler;
	public List<IKesinti> kesintiler;

	protected BigDecimal getHakedisToplami() {
		BigDecimal HakedisToplami = BigDecimal.ZERO;
		for (IHakedis hakedis : hakedisler) {
			HakedisToplami = HakedisToplami.add(hakedis.getHakedisTutari());
		}
		return HakedisToplami;
	}

	protected BigDecimal getKesintiToplami() {
		BigDecimal KesintiToplami = BigDecimal.ZERO;
		for (IKesinti kesinti : kesintiler) {
			KesintiToplami = KesintiToplami.add(kesinti.getKesintiTutari());
		}
		return KesintiToplami;
	}

	protected BigDecimal getNetOdemeTutari() {
		BigDecimal netOdemeTutari = getHakedisToplami().subtract(getKesintiToplami());
		return netOdemeTutari;
	}

	public abstract void hesapla();
}
