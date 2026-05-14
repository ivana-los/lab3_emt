package emt.lab_2_final.web;

import emt.lab_2_final.model.Wishlist;

import emt.lab_2_final.service.application.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping
    public ResponseEntity<Wishlist> getWishlist(
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(
                wishlistService.getOrCreateWishlist(userDetails.getUsername())
        );
    }

    @PostMapping("/add/{bookId}")
    public ResponseEntity<Wishlist> addBook(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long bookId) {
        return ResponseEntity.ok(
                wishlistService.addBookToWishlist(userDetails.getUsername(), bookId)
        );
    }

    @DeleteMapping("/remove/{bookId}")
    public ResponseEntity<Wishlist> removeBook(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long bookId) {
        return ResponseEntity.ok(
                wishlistService.removeBookFromWishlist(userDetails.getUsername(), bookId)
        );
    }
}