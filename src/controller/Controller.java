package controller;

import utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.entity.Author;
import model.entity.Book;
import model.entity.Lead;
import model.entity.Student;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Controller {

    public boolean addBook(Book book) {
        String sql = "insert into book(book_isbn, book_title, category, book_stock) values(?, ?, ?, ?)";
        int rows = 0;

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getCategory());
            ps.setInt(4, book.getQuantity());

            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public boolean addAuthor(Author author) {
        String sql = "insert into author(author_name, book_isbn) values(?, ?)";
        int rows = 0;

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, author.getName());
            ps.setString(2, author.getBook_isbn());

            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows > 0;
    }

    public boolean addStudent(Student stud) {
        String sql = "insert into student(cie, name) values(?, ?)";
        int rows = 0;

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stud.getCie());
            ps.setString(2, stud.getName());

            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows >= 0;
    }

    public boolean studentExist(Student stud) {
        String sql = "select cie, name from student where cie = ?";
        boolean exist = false;

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, stud.getCie());
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                exist = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exist;
    }

    public DefaultTableModel getStudentbyCie(String cie) {
        String sql = "select cie, name from student where LOWER(cie) = ?";
        Vector<String> colNames = new Vector<>();
        colNames.add("CIE");
        colNames.add("Nome");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cie.toLowerCase());

            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DefaultTableModel(data, colNames);
    }

    public DefaultTableModel getStudentbyName(String name) {
        String sql = "select cie, name from student where LOWER(name) = ?";
        Vector<String> colNames = new Vector<>();
        colNames.add("CIE");
        colNames.add("Nome");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name.toLowerCase());

            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DefaultTableModel(data, colNames);
    }

    public DefaultTableModel getByTitle(String title) {
        String sql = "select b.book_isbn, b.book_title, b.category, b.book_stock, a.author_name from book b, author a where a.book_isbn = b.book_isbn and LOWER(b.book_title) like ? ";
        Vector<String> colNames = new Vector<>();
        colNames.add("Book ISBN");
        colNames.add("Book Title");
        colNames.add("Category");
        colNames.add("Quantity");
        colNames.add("Author");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + title.toLowerCase() + "%");

            ResultSet rs = ps.executeQuery();
            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(String.valueOf(rs.getInt(4)));
                row.add(rs.getString(5));
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DefaultTableModel(data, colNames);
    }

    public DefaultTableModel getByCategory(String category) {
        String sql = "select b.book_isbn, b.book_title, b.category, b.book_stock, a.author_name from book b, author a where a.book_isbn = b.book_isbn and LOWER(b.category) like ?";
        Vector<String> colNames = new Vector<>();
        colNames.add("Book ISBN");
        colNames.add("Book Title");
        colNames.add("Category");
        colNames.add("Quantity");
        colNames.add("Author");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + category.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(String.valueOf(rs.getInt(4)));
                row.add(rs.getString(5));
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DefaultTableModel(data, colNames);
    }

    public DefaultTableModel getByAuthor(String name) {
        String sql = "select b.book_isbn, b.book_title, b.category, b.book_stock, a.author_name from book b, author a where b.book_isbn = a.book_isbn and LOWER(a.author_name) like ?";
        Book b = null;
        Vector<String> colNames = new Vector<>();
        colNames.add("Book ISBN");
        colNames.add("Book Title");
        colNames.add("Category");
        colNames.add("Quantity");
        colNames.add("Author");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name.toLowerCase() + "%");
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(String.valueOf(rs.getInt(4)));
                row.add(rs.getString(5));
                data.add(row);
            }

        } catch (SQLException e) {
        }
        return new DefaultTableModel(data, colNames);
    }

    public DefaultTableModel getByIsbn(String isbn) {
        String sql = "select b.book_isbn, b.book_title, b.category, b.book_stock, a.author_name from book b, author a where a.book_isbn = b.book_isbn and LOWER(b.book_isbn) = ?";
        Vector<String> colNames = new Vector<>();
        colNames.add("Book ISBN");
        colNames.add("Book Title");
        colNames.add("Category");
        colNames.add("Quantity");
        colNames.add("Author");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, isbn.toLowerCase());
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(String.valueOf(rs.getInt(4)));
                row.add(rs.getString(5));
                data.add(row);
            }

        } catch (SQLException e) {
        }
        return new DefaultTableModel(data, colNames);
    }

    public DefaultTableModel getTableBookAuthor() {
        String sql = "select b.book_isbn, b.book_title, b.category, b.book_stock, a.author_name from book b, author a where a.book_isbn = b.book_isbn";
        Vector<String> colNames = new Vector<>();
        colNames.add("Book ISBN");
        colNames.add("Book Title");
        colNames.add("Category");
        colNames.add("Quantity");
        colNames.add("Author");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(String.valueOf(rs.getInt(4)));
                row.add(rs.getString(5));
                data.add(row);
            }

        } catch (SQLException e) {
        }
        return new DefaultTableModel(data, colNames);
    }

    public boolean leadBook(Lead lb) {
        String sql = "INSERT INTO `lead` (cie,lead_date,return_date,book_isbn) VALUES (?,?,?,?)";
        String sqlCount = "update book set book_stock = book_stock - 1 where book_isbn = ?";
        int rows = 0;
        int rowsCount = 0;
        java.sql.Date idate = new java.sql.Date(lb.getLead_date().getTime());
        java.sql.Date rdate = new java.sql.Date(lb.getReturn_date().getTime());

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement psCount = conn.prepareStatement(sqlCount);
            psCount.setString(1, lb.getBook_isbn());
            rowsCount = psCount.executeUpdate();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, lb.getCie());
            ps.setDate(2, idate);
            ps.setDate(3, rdate);
            ps.setString(4, lb.getBook_isbn());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
        }

        return rows > 0 && rowsCount > 0;
    }

    public DefaultTableModel listBookByCie(String cie) {
        String sql = "select bi.lead_id, b.book_title, bi.cie, s.name, bi.lead_date, bi.return_date, bi.book_isbn  from book b, student s, lead bi where b.book_isbn = bi.book_isbn and bi.cie = s.cie and LOWER(bi.cie) = ?";
        Vector<String> colNames = new Vector<>();
        colNames.add("ID");
        colNames.add("Book Title");
        colNames.add("USN");
        colNames.add("Student Name");
        colNames.add("Issue Date");
        colNames.add("Return Date");
        colNames.add("ISBN");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cie);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt(1)));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(String.valueOf(rs.getDate(5)));
                row.add(String.valueOf(rs.getDate(6)));
                row.add(rs.getString(7));
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DefaultTableModel(data, colNames);
    }

    public DefaultTableModel listILeadBooks() {
        String sql = "select l.lead_id, l.cie, s2.name, l.lead_date, l.return_date, l.book_isbn  from book b2 , student s2 , `lead` l   where b2.book_isbn  = l.book_isbn  and l.cie = s2.cie";
        Vector<String> colNames = new Vector<>();
        colNames.add("Préstamo ID");
        colNames.add("CIA");
        colNames.add("Nome Estudante");
        colNames.add("Data Préstamo");
        colNames.add("Data Devolución");
        colNames.add("ISBN");

        Vector<Vector<String>> data = new Vector<>();

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt(1)));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(String.valueOf(rs.getDate(4)));
                row.add(String.valueOf(rs.getDate(5)));
                row.add(rs.getString(6));
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DefaultTableModel(data, colNames);
    }

    public DefaultTableModel getBookToReturn(Date curDate) {
        String sql = "select l.lead_id ,b.book_title ,l.cie ,s.name ,l.lead_date ,l.return_date ,l.book_isbn  from book b , student s , `lead` l where b.book_isbn = l.book_isbn and l.cie = s.cie and l.return_date = ?";
        Vector<String> colNames = new Vector<>();
        colNames.add("ID");
        colNames.add("Book Title");
        colNames.add("USN");
        colNames.add("Student Name");
        colNames.add("Issue Date");
        colNames.add("Return Date");
        colNames.add("ISBN");

        Vector<Vector<String>> data = new Vector<>();
        java.sql.Date cdate = new java.sql.Date(curDate.getTime());

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDate(1, cdate);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt(1)));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                row.add(String.valueOf(rs.getDate(5)));
                row.add(String.valueOf(rs.getDate(6)));
                row.add(rs.getString(7));
                data.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new DefaultTableModel(data, colNames);
    }

    public boolean returnBook(int id, String isbn) {
        String sql = "Delete from `lead` where lead_id = ? ";

        String sqlCount = "update book set book_stock = book_stock+1 where book_isbn = ? ";

        int rows = 0;
        int rowsCount = 0;

        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rows = ps.executeUpdate();

            PreparedStatement psCount = conn.prepareStatement(sqlCount);
            psCount.setString(1, isbn);
            rowsCount = psCount.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ((rows > 0) && (rowsCount > 0));
    }

    public String[] getAllCategory() {
        String sql = "Select unique(category) from book";
        List<String> list = new ArrayList<>();
        list.add("Select");
        try ( Connection conn = ConnectionManager.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                list.add(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] category = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            category[i] = list.get(i);
        }

        return category;
    }

}
