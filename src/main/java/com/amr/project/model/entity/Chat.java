package com.amr.project.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat")
@Data
@Builder
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Long hash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List <User> members;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "message")
    private List<Message> messages;

    public Chat(List<User> members) {
        this.members = members;
        this.hash = members.stream().map(User::hashCode).mapToLong(e -> e).sum();
    }

    public Chat() {

    }
}
