package webService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import model.CalculationModel;
import dao.ExpensesDao;
import entities.Expenses;

@Path("/expenses")
public class ExpenseService {
	
	@GET
	@Path("/get")
	@Produces("application/json")
	public Response returnExpenses() {
		
		Response rb = null;
		rb = Response.ok(ExpensesDao.list()).build();
		return rb;
	}
	
	@POST
	@Path("/post")
	@Consumes("application/json")
	public void createExpense(Expenses expense) {
		
		// tax calculation		
		expense.setAmount(CalculationModel.taxCalculation(expense));
		
		ExpensesDao.save(expense);
	}

}
