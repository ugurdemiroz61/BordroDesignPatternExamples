package com.uur.bordro.hesaplamalar.maas.memurmaas;

import java.math.BigDecimal;

import com.uur.bordro.hesaplamalar.Personel;
import com.uur.bordro.hesaplamalar.maas.EsCalismaDurumu;
import com.uur.bordro.hesaplamalar.maas.MedeniHali;

public class MemurMaasGirisBilgileri extends Personel {

	private int maasGunSayisi;
	private int gostergePuani;
	private int ekGostergePuani;
	private int yanOdemePuani;
	private BigDecimal ozelHizmetPuani;
	private int kidemYili;
	private int emekliKidemYili;
	private BigDecimal bolgeTazminatPuani;
	private MedeniHali medeniHali;
	private EsCalismaDurumu esCalismaDurumu;
	private int kucukCocukSayisi;
	private int buyukCocukSayisi;
	private boolean sendikali;
	private boolean sendikasiYuzdelikDilimAltinda;
	private BigDecimal sendikaKesintiOrani;
	private boolean doktor;
	private BigDecimal sabitOdemeOrani;
	private BigDecimal dengeTazminatiOrani;
	private BigDecimal sakatlikMatrahVergiIndirimi;
	private BigDecimal policeMatrahVergiIndirimi;
	private BigDecimal suregelenToplamVergiMatrahi;
	private BigDecimal icraOrani;
	private BigDecimal icraOraniYuzde;
	public MemurMaasGirisBilgileri(int personelNo, String adi, String soyadi) {
		super(personelNo, adi, soyadi);
	}
	
	public int getMaasGunSayisi() {
		return maasGunSayisi;
	}
	public void setMaasGunSayisi(int maasGunSayisi) {
		this.maasGunSayisi = maasGunSayisi;
	}
	public int getGostergePuani() {
		return gostergePuani;
	}
	public void setGostergePuani(int gostergePuani) {
		this.gostergePuani = gostergePuani;
	}
	public int getEkGostergePuani() {
		return ekGostergePuani;
	}
	public void setEkGostergePuani(int ekGostergePuani) {
		this.ekGostergePuani = ekGostergePuani;
	}
	public int getYanOdemePuani() {
		return yanOdemePuani;
	}
	public void setYanOdemePuani(int yanOdemePuani) {
		this.yanOdemePuani = yanOdemePuani;
	}
	public BigDecimal getOzelHizmetPuani() {
		return ozelHizmetPuani;
	}
	public void setOzelHizmetPuani(BigDecimal ozelHizmetPuani) {
		this.ozelHizmetPuani = ozelHizmetPuani;
	}
	public int getKidemYili() {
		return kidemYili;
	}
	public void setKidemYili(int kidemYili) {
		this.kidemYili = kidemYili;
	}
	public int getEmekliKidemYili() {
		return emekliKidemYili;
	}
	public void setEmekliKidemYili(int emekliKidemYili) {
		this.emekliKidemYili = emekliKidemYili;
	}
	public BigDecimal getBolgeTazminatPuani() {
		return bolgeTazminatPuani;
	}
	public void setBolgeTazminatPuani(BigDecimal bolgeTazminatPuani) {
		this.bolgeTazminatPuani = bolgeTazminatPuani;
	}
	public MedeniHali getMedeniHali() {
		return medeniHali;
	}
	public void setMedeniHali(MedeniHali medeniHali) {
		this.medeniHali = medeniHali;
	}
	public EsCalismaDurumu getEsCalismaDurumu() {
		return esCalismaDurumu;
	}
	public void setEsCalismaDurumu(EsCalismaDurumu esCalismaDurumu) {
		this.esCalismaDurumu = esCalismaDurumu;
	}
	public int getKucukCocukSayisi() {
		return kucukCocukSayisi;
	}
	public void setKucukCocukSayisi(int kucukCocukSayisi) {
		this.kucukCocukSayisi = kucukCocukSayisi;
	}
	public int getBuyukCocukSayisi() {
		return buyukCocukSayisi;
	}
	public void setBuyukCocukSayisi(int buyukCocukSayisi) {
		this.buyukCocukSayisi = buyukCocukSayisi;
	}
	public boolean isSendikali() {
		return sendikali;
	}
	public void setSendikali(boolean sendikali) {
		this.sendikali = sendikali;
	}
	public boolean isSendikasiYuzdelikDilimAltinda() {
		return sendikasiYuzdelikDilimAltinda;
	}
	public void setSendikasiYuzdelikDilimAltinda(boolean sendikasiYuzdelikDilimAltinda) {
		this.sendikasiYuzdelikDilimAltinda = sendikasiYuzdelikDilimAltinda;
	}
	public BigDecimal getSendikaKesintiOrani() {
		return sendikaKesintiOrani;
	}
	public void setSendikaKesintiOrani(BigDecimal sendikaKesintiOrani) {
		this.sendikaKesintiOrani = sendikaKesintiOrani;
	}
	public boolean isDoktor() {
		return doktor;
	}
	public void setDoktor(boolean doktor) {
		this.doktor = doktor;
	}
	public BigDecimal getSabitOdemeOrani() {
		return sabitOdemeOrani;
	}
	public void setSabitOdemeOrani(BigDecimal sabitOdemeOrani) {
		this.sabitOdemeOrani = sabitOdemeOrani;
	}
	public BigDecimal getDengeTazminatiOrani() {
		return dengeTazminatiOrani;
	}
	public void setDengeTazminatiOrani(BigDecimal dengeTazminatiOrani) {
		this.dengeTazminatiOrani = dengeTazminatiOrani;
	}
	public BigDecimal getSakatlikMatrahVergiIndirimi() {
		return sakatlikMatrahVergiIndirimi;
	}
	public void setSakatlikMatrahVergiIndirimi(BigDecimal sakatlikMatrahVergiIndirimi) {
		this.sakatlikMatrahVergiIndirimi = sakatlikMatrahVergiIndirimi;
	}
	public BigDecimal getPoliceMatrahVergiIndirimi() {
		return policeMatrahVergiIndirimi;
	}
	public void setPoliceMatrahVergiIndirimi(BigDecimal policeMatrahVergiIndirimi) {
		this.policeMatrahVergiIndirimi = policeMatrahVergiIndirimi;
	}
	public BigDecimal getSuregelenToplamVergiMatrahi() {
		return suregelenToplamVergiMatrahi;
	}
	public void setSuregelenToplamVergiMatrahi(BigDecimal suregelenToplamVergiMatrahi) {
		this.suregelenToplamVergiMatrahi = suregelenToplamVergiMatrahi;
	}
	public BigDecimal getIcraOrani() {
		return icraOrani;
	}
	public void setIcraOrani(BigDecimal icraOrani) {
		this.icraOrani = icraOrani;
	}
	public BigDecimal getIcraOraniYuzde() {
		return icraOraniYuzde;
	}
	public void setIcraOraniYuzde(BigDecimal icraOraniYuzde) {
		this.icraOraniYuzde = icraOraniYuzde;
	}
}
