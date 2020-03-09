package me.josemalonsom.repository;

import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import me.josemalonsom.entity.Book;
import me.josemalonsom.model.BookRevision;

// Book, DefaultRevisionEntity, RevisionType

@Repository
public class BookAuditRepository {

    @Autowired
    private AuditReader auditReader;

    public List<BookRevision> getRevisions(Long id) {

        // Object[] -> Entity (Book), DefaultRevisionEntity, RevisionType
        @SuppressWarnings("unchecked")
        List<Object[]> resultList =
                auditReader.createQuery().forRevisionsOfEntity(Book.class, false, true)
                .add(AuditEntity.property("id").eq(id))
                .getResultList();

        return resultList.stream().map(values -> {

            Book book = (Book) values[0];
            DefaultRevisionEntity revisionEntity = (DefaultRevisionEntity) values[1];

            return new BookRevision(book, revisionEntity.getRevisionDate(), (RevisionType) values[2]);

        }).collect(Collectors.toList());
    }

}
