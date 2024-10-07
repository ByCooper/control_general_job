package ru.skypro.homework.dto;

import lombok.*;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ImageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filePath;
    private long fileSize;
    private String mediaType;
    @Lob
    private byte[] data;
    @ManyToOne(fetch = FetchType.EAGER)
    private Ad ad;
}
