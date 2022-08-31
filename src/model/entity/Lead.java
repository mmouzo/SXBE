package model.entity;

import java.util.Date;

public class Lead {

    public String cie;
    public Date lead_date;
    public Date return_date;
    public String book_isbn;
    private int id;


    public Lead(String cie, Date lead_date, Date return_date, String book_isbn) {
        this.cie = cie;
        this.lead_date = lead_date;
        this.return_date = return_date;
        this.book_isbn = book_isbn;
    }


    public int getId() {
        return id;
    }

    public String getCie() {
        return cie;
    }

    public void setCie(String cie) {
        this.cie = cie;
    }

    public Date getLead_date() {
        return lead_date;
    }

    public void setLead_date(Date lead_date) {
        this.lead_date = lead_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public String getBook_isbn() {
        return book_isbn;
    }

    public void setBook_isbn(String book_isbn) {
        this.book_isbn = book_isbn;
    }

    @Override
    public String toString() {
        return "" + id + "\t" + cie + "\t" + lead_date + "\t" + return_date + "\t" + book_isbn;
    }

}
