package com.haydikodlayalim.api;

import com.haydikodlayalim.entity.Kisi;
import com.haydikodlayalim.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kisi")
public class KisiController {
    private final KisiRepository kisiRepository;

    @PostConstruct
    public void init() {
        Kisi kisi = new Kisi();
        kisi.setId("K0001");
        kisi.setAd("Ahmet");
        kisi.setSoyad("Durur");
        kisi.setAdres("yuzuncuyil mahallesi");
        kisi.setDogumTarihi(Calendar.getInstance().getTime());
        kisiRepository.save(kisi);

    }


    @GetMapping("/{search}")
    public ResponseEntity<List<Kisi>> getKisi(@PathVariable String search) {
        return ResponseEntity.ok(kisiRepository.findByAdLikeOrSoyadLikeOrAdresLike(search, search,search));
    }
}
