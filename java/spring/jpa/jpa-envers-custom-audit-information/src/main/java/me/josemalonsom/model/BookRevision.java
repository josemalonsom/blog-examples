package me.josemalonsom.model;

import java.util.Date;
import org.hibernate.envers.RevisionType;
import me.josemalonsom.entity.Book;

public class BookRevision {

    private Book book;
    private Date date;
    private RevisionType revisionType;

    public BookRevision(Book book, Date date, RevisionType revisionType) {

        this.book = book;
        this.date = date;
        this.revisionType = revisionType;
    }

    public Book getBook() {
        return book;
    }

    public Date getDate() {
        return date;
    }

    public RevisionType getRevisionType() {
        return revisionType;
    }

}
