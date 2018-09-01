package demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByUsername(String username);
}
