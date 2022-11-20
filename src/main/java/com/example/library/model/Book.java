package com.example.library.model;

import com.example.library.enums.BookStatus;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Getter
@Builder(toBuilder = true)
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book extends BaseEntity {
    private String title;
    private String authorName;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
    private String publisher;
    private Integer lastPageNumber;
    private Integer totalPage;
    @OneToOne
    private Image image;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private Long userId;

    public Image getImage() {
        return image == null ? new Image() : image;
    }
}