import org.example.AuctionService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AuctionServiceTest {

    AuctionService service = new AuctionService();

    @Test
    void testValidateBid_Success() {
        assertTrue(service.validateBid(100, 120));
    }

    @Test
    void testValidateBid_TooLow() {
        assertFalse(service.validateBid(100, 105));
    }

    @Test
    void testValidateBid_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.validateBid(100, -5);
        });
    }

    @Test
    void testGetAuctionStatus_Active() {
        assertEquals("ACTIVE", service.getAuctionStatus(5));
    }

    @Test
    void testGetAuctionStatus_ClosingSoon() {
        assertEquals("CLOSING_SOON", service.getAuctionStatus(1));
    }

    @Test
    void testGetAuctionStatus_Finished() {
        assertEquals("FINISHED", service.getAuctionStatus(-1));
    }
}