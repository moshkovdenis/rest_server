package ru.denis.rest_server.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user2_id")
    private User user2;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @Column(name = "time_creation")
    private Date time_creation;

    public Message() {
    }

    public Message(User user1, User user2, Chat chat, Date time_creation) {
        this.user1 = user1;
        this.user2 = user2;
        this.chat = chat;
        this.time_creation = time_creation;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Date getTime_creation() {
        return time_creation;
    }

    public void setTime_creation(Date time_creation) {
        this.time_creation = time_creation;
    }
}
