package entities;

// Generated 03-Mar-2015 20:31:56 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Expenses generated by hbm2java
 */
@Entity
@Table(name = "expenses")
public class Expenses implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8603359274578351238L;
	private Integer id;
	private Date date;
	private double amount;
	private String reason;

	public Expenses() {
	}

	public Expenses(Date date, double amount, String reason) {
		this.date = date;
		this.amount = amount;
		this.reason = reason;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "amount", nullable = false)
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Column(name = "reason", nullable = false, length = 45)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
