package org.example;

public class AuctionService {

    public boolean validateBid(double currentPrice, double bidAmount) {
        if (bidAmount <= 0) {
            throw new IllegalArgumentException("Giá thầu phải lớn hơn 0");
        }

        double minIncrement = currentPrice * 0.1;

        if (bidAmount >= currentPrice + minIncrement) {
            return true;
        } else {
            return false;
        }
    }

    public String getAuctionStatus(int hoursRemaining) {
        if (hoursRemaining < 0) {
            return "FINISHED";
        } else if (hoursRemaining <= 1) {
            return "CLOSING_SOON";
        } else {
            return "ACTIVE";
        }
    }
}