package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.model.Avatar;

@Repository
public interface AvatarRepository extends JpaRepository<Avatar, Long> {
    Avatar findAvatarById(Long id);
}
