package ru.skypro.homework.model;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id; //id объявления
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author; //id автора обращения
    @Lob
    @Column(name = "photo")
    private byte[] image;
    private Integer price;
    private String title;
}
