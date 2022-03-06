package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "message")
@Data
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text_message")
    private String textMessage;
    private boolean viewed;

    @Column(name = "time_stamp")
    private Timestamp timeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User to;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User from;

    public Message() {
        this.timeStamp = new Timestamp(System.currentTimeMillis());
    }
}
