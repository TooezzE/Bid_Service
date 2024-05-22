package com.example.applications.model.entity;

import com.example.applications.model.enums.BidStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "bids")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private BidStatus status;
    private Long user_id;
    private String userMessage;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public Bid() {
        this.creationDate = LocalDate.now();
    }

    public Bid(BidStatus status, Long user_id, String userMessage) {
        if(status == null) {
            this.status = BidStatus.DRAFT;
        } else {
            this.status = status;
        }
        this.user_id = user_id;
        this.userMessage = userMessage;
        this.creationDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BidStatus getStatus() {
        return status;
    }

    public void setStatus(BidStatus status) {
        this.status = status;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return Objects.equals(id, bid.id) && status == bid.status && Objects.equals(user_id, bid.user_id) && Objects.equals(creationDate, bid.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, creationDate);
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", status=" + status +
                ", user_id=" + user_id +
                ", userMessage='" + userMessage + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
