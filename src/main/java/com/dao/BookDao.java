package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.BookBean;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addBook(BookBean bookBean) {

		return jdbcTemplate.update("insert into book(bname,bprice,bookqty)values(?,?,?)", bookBean.getbName(),
				bookBean.getbPrice(), bookBean.getbQty());

	}

	private final static class BookMapper implements RowMapper<BookBean> {

		@Override
		public BookBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookBean bookBean = new BookBean();
			bookBean.setbId(rs.getInt("bid"));
			bookBean.setbName(rs.getString("bname"));
			bookBean.setbPrice(rs.getInt("bprice"));
			bookBean.setbQty(rs.getInt("bookqty"));

			return bookBean;
		}

	}

	public BookBean getBookById(int id) {

		return jdbcTemplate.queryForObject("select * from book where bid = " + id + "", new BookMapper());
	}

	public List<BookBean> bookList() {

		return jdbcTemplate.query("select * from book", new BookMapper());
	}

}
