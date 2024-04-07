package com.example.applications.service;

import com.example.applications.exception.BidAlreadySentException;
import com.example.applications.model.entity.Bid;
import com.example.applications.repository.BidRepository;
import com.example.applications.repository.UserRepository;
import com.example.applications.model.enums.BidStatus;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidService {

    private final BidRepository bidRepository;
    private final UserRepository userRepository;

    public BidService(BidRepository bidRepository, UserRepository userRepository) {
        this.bidRepository = bidRepository;
        this.userRepository = userRepository;
    }

    public void createBidDraft(String userName, String userMessage) {
        Bid bid = new Bid();
        bid.setStatus(BidStatus.DRAFT);
        bid.setUserMessage(userMessage);
        bid.setUserName(userName);
        bid.setUserPhone(userRepository.findByUsername(userName).get().getPhone());

        bidRepository.save(bid);
    }

    public void createAndSendBid(String userName, String userMessage) {
        Bid bid = new Bid();
        bid.setStatus(BidStatus.SENT);
        bid.setUserMessage(userMessage);
        bid.setUserName(userName);
        bid.setUserPhone(userRepository.findByUsername(userName).get().getPhone());

        Long bidId = bidRepository.save(bid).getId();
        sendBid(bidId);
    }

    public void editBid(Long bidId, String newUserMessage) {
        Bid bid = bidRepository.findById(bidId).orElseThrow();
        if(newUserMessage.isBlank() || bid.getUserMessage().equals(newUserMessage)) {
            return;
        }
        if (bid.getStatus().equals(BidStatus.DRAFT)) {
            bid.setUserMessage(newUserMessage);
            bidRepository.save(bid);
        } else {
            throw new BidAlreadySentException();
        }
    }

    public void sendBid(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElseThrow();
        bid.setStatus(BidStatus.SENT);
        bidRepository.save(bid);
    }

    public void cancelBidSending(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElseThrow();
        bid.setStatus(BidStatus.DRAFT);
        bidRepository.save(bid);
    }

    public void deleteBid(Long bidId) {
        bidRepository.deleteById(bidId);
    }

    public void acceptBid(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElseThrow();
        bid.setStatus(BidStatus.ACCEPTED);
        bidRepository.save(bid);
    }

    public void rejectBid(Long bidId) {
        Bid bid = bidRepository.findById(bidId).orElseThrow();
        bid.setStatus(BidStatus.REJECTED);
        bidRepository.save(bid);
    }

    public Bid getBidById(Long bidId) {
        return bidRepository.findById(bidId).orElseThrow();
    }

    public List<Bid> getAllBids() {
        return bidRepository.findAll(Sort.unsorted()).stream()
                .filter(b -> b.getStatus().equals(BidStatus.SENT))
                .collect(Collectors.toList());
    }

    public List<Bid> getAllUserBidsBy() {
        return bidRepository.findAll(Sort.unsorted());
    }
}
