package com.uur.bordro.hesaplamalar;

public class Personel {
	private int personelNo;
	private String adi;
	private String soyadi;
	public int getPersonelNo() {
		return personelNo;
	}
	public void setPersonelNo(int personelNo) {
		this.personelNo = personelNo;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public Personel(int personelNo, String adi, String soyadi) {
		this.personelNo = personelNo;
		this.adi = adi;
		this.soyadi = soyadi;
	}
}
