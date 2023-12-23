package com.uur.bordro.hesaplamalar.maas.sozlesmeli4924memurmaas;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.maas.EsCalismaDurumu;
import com.uur.bordro.hesaplamalar.maas.MedeniHali;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;

public class Sozlesmeli4924GirisBilgileri extends MemurMaasGirisBilgileri {
	public Sozlesmeli4924GirisBilgileri(int personelNo, String adi, String soyadi,
			BigDecimal sozlesmeBrutUcreti, BigDecimal unvanOrani, BigDecimal unvanCarpani, BigDecimal yilOrani) {
		super(personelNo, adi, soyadi);
		this.sozlesmeBrutUcreti = sozlesmeBrutUcreti;
		this.unvanOrani = unvanOrani;
		this.unvanCarpani = unvanCarpani;
		this.yilOrani = yilOrani;
	}
	public BigDecimal getSozlesmeBrutUcreti() {
		return sozlesmeBrutUcreti;
	}
	public void setSozlesmeBrutUcreti(BigDecimal sozlesmeBrutUcreti) {
		this.sozlesmeBrutUcreti = sozlesmeBrutUcreti;
	}
	public BigDecimal getUnvanOrani() {
		return unvanOrani;
	}
	public void setUnvanOrani(BigDecimal unvanOrani) {
		this.unvanOrani = unvanOrani;
	}
	public BigDecimal getUnvanCarpani() {
		return unvanCarpani;
	}
	public void setUnvanCarpani(BigDecimal unvanCarpani) {
		this.unvanCarpani = unvanCarpani;
	}
	public BigDecimal getYilOrani() {
		return yilOrani;
	}
	public void setYilOrani(BigDecimal yilOrani) {
		this.yilOrani = yilOrani;
	}
	private BigDecimal sozlesmeBrutUcreti;
	private BigDecimal unvanOrani;
	private BigDecimal unvanCarpani;
	private BigDecimal yilOrani;

}
