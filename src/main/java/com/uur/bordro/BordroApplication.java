package com.uur.bordro;

import java.io.Console;
import java.math.BigDecimal;
import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uur.bordro.hesaplamalar.IHakedis;
import com.uur.bordro.hesaplamalar.maas.EsCalismaDurumu;
import com.uur.bordro.hesaplamalar.maas.MedeniHali;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasBordro;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasBordroSekli;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasGirisBilgileri;
import com.uur.bordro.hesaplamalar.maas.memurmaas.MemurMaasParametreBilgileri;

@SpringBootApplication
public class BordroApplication {

	public static void main(String[] args) {
		SpringApplication.run(BordroApplication.class, args);
	}

}
