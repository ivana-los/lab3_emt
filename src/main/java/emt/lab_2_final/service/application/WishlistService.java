package emt.lab_2_final.service.application;

import emt.lab_2_final.model.Wishlist;

public interface WishlistService {
    Wishlist getOrCreateWishlist(String username);
    Wishlist addBookToWishlist(String username, Long bookId);
    Wishlist removeBookFromWishlist(String username, Long bookId);
}