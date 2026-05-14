package emt.lab_2_final.service.application.impl;

import emt.lab_2_final.model.Book;
import emt.lab_2_final.model.Wishlist;
import emt.lab_2_final.model.domain.User;
import emt.lab_2_final.repository.BookRepository;
import emt.lab_2_final.repository.WishlistRepository;
import emt.lab_2_final.service.application.WishlistService;
import emt.lab_2_final.service.domain.UserService;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;
    private final BookRepository bookRepository;
    private final UserService userService;

    public WishlistServiceImpl(WishlistRepository wishlistRepository,
                               BookRepository bookRepository,
                               UserService userService) {
        this.wishlistRepository = wishlistRepository;
        this.bookRepository = bookRepository;
        this.userService = userService;
    }

    @Override
    public Wishlist getOrCreateWishlist(String username) {
        User user = (User) userService.loadUserByUsername(username);
        return wishlistRepository.findByUser(user)
                .orElseGet(() -> wishlistRepository.save(new Wishlist(user)));
    }

    @Override
    public Wishlist addBookToWishlist(String username, Long bookId) {
        Wishlist wishlist = getOrCreateWishlist(username);
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));
        if (!wishlist.getBooks().contains(book)) {
            wishlist.getBooks().add(book);
        }
        return wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist removeBookFromWishlist(String username, Long bookId) {
        Wishlist wishlist = getOrCreateWishlist(username);
        wishlist.getBooks().removeIf(b -> b.getId().equals(bookId));
        return wishlistRepository.save(wishlist);
    }
}