package ru.skypro.homework.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filePath;
    private long fileSize;
    private String mediaType;
    @Lob
    private byte[] data;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_id")
    private Ad ad;// id обращения
}
