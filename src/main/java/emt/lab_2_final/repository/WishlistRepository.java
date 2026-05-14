package emt.lab_2_final.repository;

import emt.lab_2_final.model.Wishlist;
import emt.lab_2_final.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByUser(User user);
}