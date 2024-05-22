package com.example.applications.controllers;

import com.example.applications.model.dto.CreateBid;
import com.example.applications.model.dto.EditBid;
import com.example.applications.service.BidService;
import com.example.applications.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/bids")
public class BidController {

    private final UserService userService;
    private final BidService bidService;

    public BidController(UserService userService, BidService bidService) {
        this.userService = userService;
        this.bidService = bidService;
    }

    @PostMapping("/new-bid")
    public ResponseEntity<?> createBid(@RequestBody CreateBid newBid, Principal principal) {
        bidService.createBid(userService.findByUsername(principal.getName()).get().getId(), newBid.getUserMessage());
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/edit-bid")
    public ResponseEntity<?> editBid(@RequestBody EditBid bidToEdit) {
        bidService.editBid(bidToEdit.getBidId(), bidToEdit.getUserMessage());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/send-bid/{bidId}")
    public ResponseEntity<?> sendBid(@PathVariable Long bidId) {
        bidService.sendBid(bidId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/cancel-bid/{bidId}")
    public ResponseEntity<?> cancelBid(@PathVariable Long bidId) {
        bidService.cancelBidSending(bidId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-bid/{bidId}")
    public ResponseEntity<?> deleteBid(@PathVariable Long bidId) {
        bidService.deleteBid(bidId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/accept-bid/{bidId}")
    public ResponseEntity<?> acceptBid(@PathVariable Long bidId) {
        bidService.acceptBid(bidId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reject-bid/{bidId}")
    public ResponseEntity<?> rejectBid(@PathVariable Long bidId) {
        bidService.rejectBid(bidId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-bid/{bidId}")
    public ResponseEntity<?> getBid(@PathVariable Long bidId) {
        return ResponseEntity.ok(bidService.getBidById(bidId));
    }

    @GetMapping("/all-bids")
    public ResponseEntity<?> getAllBids() {
        return ResponseEntity.ok(bidService.getAllBids());
    }

    @GetMapping("/all-user-bids")
    public ResponseEntity<?> getAllBids(Principal principal) {
        return ResponseEntity.ok(bidService.getAllUserBidsBy(userService.findByUsername(principal.getName()).get().getId()));
    }
}
