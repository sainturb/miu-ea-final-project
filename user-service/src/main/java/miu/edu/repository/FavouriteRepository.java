package miu.edu.repository;

import miu.edu.model.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

    List<Favourite> findAllByUserId(String userId);
}
