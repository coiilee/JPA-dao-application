package edu.kh.com.daoapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class KHTBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String title; //column 작성 안할 경우 기본값 (nullable= true , unique = false)
    @Column(nullable = false, unique = true)
    private String author;
    @Column(nullable = false, unique = true)
    private String genre;
}
