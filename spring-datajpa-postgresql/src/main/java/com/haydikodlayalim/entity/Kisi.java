package com.haydikodlayalim.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kisi")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Kisi {
    @Id
    @SequenceGenerator(name = "seq_kisi" ,allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi" , strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100 , name = "adi")
    private String adi;

    @Column(length = 100 , name = "soyadi")
    private String soyadi;

    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    private List<Adres> adresleri;
}
