package workshop.dto;

import java.io.Serializable;
import java.util.Date;

public class CommentsDTO implements Serializable {
    private String text;
    private Date date;
    private authorDTO author;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public authorDTO getAuthor() {
        return author;
    }

    public void setAuthor(authorDTO author) {
        this.author = author;
    }

    public CommentsDTO(){
        
    }

    public CommentsDTO(String text, Date date, authorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }
}
