package com.example.applications.model.entity;

import com.example.applications.model.enums.BidStatus;
import jakarta.persistence.*;

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
    private String userName;
    private String userMessage;
    private String userPhone;
    private LocalDate creationDate;

    public Bid() {
        this.creationDate = LocalDate.now();
    }

    public Bid(Long id, BidStatus status, String userName, String userMessage, String userPhone) {
        this.id = id;
        this.status = status;
        this.userName = userName;
        this.userMessage = userMessage;
        this.userPhone = userPhone;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bid bid = (Bid) o;
        return Objects.equals(id, bid.id) && status == bid.status && Objects.equals(userName, bid.userName) && Objects.equals(userMessage, bid.userMessage) && Objects.equals(userPhone, bid.userPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, userName, userMessage, userPhone);
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id +
                ", status=" + status +
                ", userName='" + userName + '\'' +
                ", userMessage='" + userMessage + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }
}
