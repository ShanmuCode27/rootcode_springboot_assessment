package com.shanmu.assessment.database.repositories;

import com.shanmu.assessment.database.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("""
    SELECT b FROM Book b
    WHERE (:authorId IS NULL OR b.author.id = :authorId)
      AND (:authorName IS NULL OR LOWER(b.author.name) LIKE LOWER(CONCAT('%', :authorName, '%')))
      AND (:publishedYear IS NULL OR YEAR(b.publishedYear) = :publishedYear)
""")
    Page<Book> findBooksByFilters(
            @Param("authorId") Long authorId,
            @Param("authorName") String authorName,
            @Param("publishedYear") Integer publishedYear,
            Pageable pageable
    );

    Page<Book> findAll(Pageable pageable);
}
