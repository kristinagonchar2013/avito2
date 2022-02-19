package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Builder
@Table(name = "feedback")
public class Feedback {
    //TODO обратная связь от покупателей (книга жалоб и предложений :))
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String reason;
    @Column
    private String fullText;
    @Column
    private LocalDateTime dateTime;
    @Column
    private String username;

    public Feedback() {

    }
}