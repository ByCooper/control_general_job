package ru.skypro.homework.model;

import lombok.*;

import javax.persistence.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author; //id автора
    private String authorImage; //ссылка на аватар автора
    private String authorFirstName;
    private Long createAd; //дата и время создания комментария в миллисекундах с 00:00:00 01.01.1970
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ad_id")
    private Ad pk; //id комментария
    private String text; //текст комментария
}
