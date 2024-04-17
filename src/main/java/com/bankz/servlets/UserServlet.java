package com.bankz.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.bankz.backend.Logic;
import com.bankz.enums.UserStatus;
import com.bankz.enums.UserType;
import com.bankz.helper.Supplement;
import com.bankz.pojo.Account;
import com.bankz.pojo.Branch;
import com.bankz.pojo.Customer;
import com.bankz.pojo.Employee;
import com.bankz.pojo.Transaction;
import com.bankz.pojo.User;
import com.bankz.utilities.BankException;
import com.bankz.utilities.InvalidInputException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Logic logic = new Logic();

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRequestURI();
		path = path.substring(path.lastIndexOf("/"));
		switch (path) {

		case "/dashboard":
			login(request, response);
			break;
		case "/createAccount":
			createAccount(request, response);
			break;
		case "/createCustomer":
			createCustomer(request, response);
			break;
		case "/createEmployee":
			createEmployee(request, response);
			break;
		case "/createBranch":
			createBranch(request, response);
			break;
		case "/depositAmount":
			depositAmount(request, response);
			break;
		case "/withdrawAmount":
			withdrawAmount(request, response);
			break;
		case "/moneyTransfer":
			moneyTransfer(request, response);
			break;
		case "/resetPassword":
			resetPassword(request, response);
			break;
		case "/editCustomerPersonalDetails":
			editCustomerPersonalDetails(request, response);
			break;
		case "/editEmployeePersonalDetails":
			editEmployeePersonalDetails(request, response);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRequestURI();
		path = path.substring(path.lastIndexOf("/"));
		switch (path) {
		case "/login":
			getLoginPage(request, response);
			break;
		case "/getEditPersonalDetailsPage":
			getEditPersonalDetailsPage(request, response);
			break;
		
		case "/miniStatement":
			miniStatement(request, response);
			break;
		case "/accountDetails":
			getAccountDetails(request, response);
			break;
		case "/customerAccountDetails":
			getCustomerAccountDetails(request, response);
			break;
		case "/depositPage":
			getDepositPage(request, response);
			break;
		case "/withdrawPage":
			getWithdrawPage(request, response);
			break;
		case "/createEmployee":
			createEmployee(request, response);
			break;
		case "/resetPasswordPage":
			getResetPasswordPage(request, response);
			break;
		case "/moneyTransferPage":
			getMoneyTransferPage(request, response);
			break;
		case "/createCustomerPage":
			getCreateCustomerPage(request, response);
			break;

		case "/customerPersonalDetailsPage":
			request.getSession().setAttribute("operation", "customerDetails");
			getCustomerIdPage(request, response);
			break;
		case "/customerPersonalDetails":
			getCustomerPersonalDetails(request, response);
			break;
		case "/customerDetails":
			getCustomerDetails(request, response);
			break;
		case "/removeCustomerPage":
			request.getSession().setAttribute("operation", "removeCustomer");
			getCustomerIdPage(request, response);
			break;
		case "/removeCustomer":
			removeCustomer(request, response);
			break;
		case "/createAccountPage":
			getCreateAccountPage(request, response);
			break;
		case "/accountDetailsPage":
			request.getSession().setAttribute("operation", "customerAccountDetails");
			getCustomerIdPage(request, response);
			break;
		case "/blockAccountPage":
			request.getSession().setAttribute("operation", "blockAccount");
			getAccountNumPage(request, response);
			break;
		case "/blockAccount":
			blockAccount(request, response);
			break;
		case "/removeAccountPage":
			request.getSession().setAttribute("operation", "removeAccount");
			getAccountNumPage(request, response);
			break;
		case "/removeAccount":
			removeAccount(request, response);
			break;
		case "/createEmployeePage":
			getCreateEmployeePage(request, response);
			break;
		case "/blockEmployeePage":
			request.getSession().setAttribute("operation", "blockEmployee");
			getEmployeeIdPage(request, response);
			break;
		case "/blockEmployee":
			blockEmployee(request, response);
			break;
		case "/removeEmployeePage":
			request.getSession().setAttribute("operation", "removeEmployee");
			getEmployeeIdPage(request, response);
			break;
		case "/removeEmployee":
			removeEmployee(request, response);
			break;
		case "/employeePersonalDetails":
			getEmployeePersonalDetails(request, response);
			break;
		case "/otherEmployeeDetailsPage":
			request.getSession().setAttribute("operation", "otherEmployeeDetails");
			getEmployeeIdPage(request, response);
			break;
		case "/otherEmployeeDetails":
			getEmployeeDetails(request, response);
			break;
		case "/createBranchPage":
			getCreateBranchPage(request, response);
			break;
		case "/removeBranchPage":
			request.getSession().setAttribute("operation", "removeBranch");
			getBranchIdPage(request, response);
			break;
		case "/removeBranch":
			removeBranch(request, response);
			break;
		case "/branchDetailsPage":
			request.getSession().setAttribute("operation", "branchDetails");
			getBranchIdPage(request, response);
			break;
		case "/branchDetails":
			getBranchDetails(request, response);
			break;
		case "/transactionDetailsPage":
			request.getSession().setAttribute("operation", "transactionDetails");
			getCustomerIdPage(request, response);
			break;
		case "/transactionDetails":
			transactionDetails(request, response);
			break;
		case "/getIconPage":
			getIconPage(request, response);
			break;
		case "/checkStatus":
			checkStatus(request, response);
			break;

		}

	}

	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.getRequestDispatcher("/jsp/User UI/login.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}

	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		int userId = Integer.parseInt(request.getParameter("userId"));

		String password = request.getParameter("password");

		try {
			Logic logic = new Logic();

			User user = logic.login(userId, password);
			request.getSession().setAttribute("userId", userId);
			request.getSession().setAttribute("userType", user.getType());
			if (user != null) {
				
				switch (UserType.values()[user.getType()]) {
				case CUSTOMER:
					request.getRequestDispatcher("/jsp/Customer UI/CustomerFrontPage.jsp").forward(request, response);
					break;
				case EMPLOYEE:
					Employee employee = logic.getEmployeePersonalInfo(userId);
					Branch branch = logic.getBranch(employee.getBranch());

					request.setAttribute("branch", branch);
					request.getRequestDispatcher("/jsp/Employee UI/EmployeeFrontPage.jsp").forward(request, response);
					break;
				case ADMIN:
					Employee admin = logic.getEmployeePersonalInfo(userId);
					Branch adminBranch = logic.getBranch(admin.getBranch());

					request.setAttribute("branch", adminBranch);
					request.getRequestDispatcher("/jsp/Employee UI/AdminFrontPage.jsp").forward(request, response);
					break;
				}
			} else {
				request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
			}
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (NoSuchAlgorithmException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ClassNotFoundException e) {
			request.setAttribute("message", "A Problem with the server");
			gotException(request, response);
		}

	}

	private void getEditPersonalDetailsPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			int userType = (int) request.getSession().getAttribute("userType");
			if (userType == 0 || userType == 1) {
				request.setAttribute("employee",
						logic.getEmployeePersonalInfo((int) request.getSession().getAttribute("userId")));
			} else if (userType == 2) {
				request.setAttribute("customer",
						logic.getCustomerPersonalInfo((int) request.getSession().getAttribute("userId")));
			}
			request.getRequestDispatcher("/jsp/User UI/EditPersonalDetails.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	
	private void editCustomerPersonalDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println(111);
			Customer customer = new Customer();
			customer.setId((int) request.getSession().getAttribute("userId"));
			Map<String, String[]> parameters = request.getParameterMap();
			System.out.println(parameters);
			for (String parameterString : parameters.keySet()) {
				System.out.println(parameterString);
			}
			
			customer.setName(request.getParameter("name"));
			
			customer.setEmail(request.getParameter("email"));
			
			customer.setDob(Supplement.dateToLong(request.getParameter("dob")));
			customer.setAddress(request.getParameter("address"));
			customer.setContactNum(Long.parseLong(request.getParameter("contactNumber")));
			
			logic.editCustomerPersonalInfo(customer);
			request.setAttribute("customer",
				logic.getCustomerPersonalInfo((int) request.getSession().getAttribute("userId")));
		request.getRequestDispatcher("/jsp/User UI/Icon.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void getCustomerPersonalDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			Customer customer = logic.getCustomerPersonalInfo((int) request.getSession().getAttribute("userId"));
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/jsp/Customer UI/CustomerPersonalDetails.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void getCustomerIdPage(HttpServletRequest request, HttpServletResponse response) {
		try {

			request.getRequestDispatcher("/jsp/Employee UI/GetCustomerId.jsp").forward(request, response);

		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getAccountNumPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Employee UI/GetAccountNum.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void miniStatement(HttpServletRequest request, HttpServletResponse response) {
		try {
			int pageNum = 0;
			int i = 0;

			if (request.getSession().getAttribute("i") == null) {
				i = 1;

			} else {
				i = (int) request.getSession().getAttribute("i");

			}
			do {
				pageNum += 1;
				List<Transaction> transactionsList = logic
						.getTransactionDetails((int) request.getSession().getAttribute("userId"), pageNum);
				request.setAttribute("transactionList", transactionsList);
				request.getRequestDispatcher("/jsp/User UI/MiniStatement.jsp").forward(request, response);
			} while (i == 1);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void transactionDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			int pageNum = 0;
			int i = 0;

			if (request.getSession().getAttribute("i") == null) {
				i = 1;

			} else {
				i = (int) request.getSession().getAttribute("i");

			}
			do {
				pageNum += 1;
				List<Transaction> transactionsList = logic
						.getTransactionDetails(Integer.parseInt(request.getParameter("customerId")), pageNum);
				request.setAttribute("transactionList", transactionsList);
				request.getRequestDispatcher("/jsp/User UI/MiniStatement.jsp").forward(request, response);
			} while (i == 1);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void getDepositPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Customer UI/Deposit.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getWithdrawPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Customer UI/Withdraw.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getResetPasswordPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/User UI/ResetPassword.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getMoneyTransferPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Customer UI/MoneyTransfer.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getCreateCustomerPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Employee UI/CreateCustomer.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getCreateAccountPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Employee UI/CreateAccount.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getAccountDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			int pageNum = 0;
			int i = 1;
			do {
				pageNum += 1;
				List<Account> accountList = logic.getAccounts((int) request.getSession().getAttribute("userId"),
						pageNum);
				request.setAttribute("accountList", accountList);
				request.getRequestDispatcher("/jsp/User UI/AccountDetails.jsp").forward(request, response);
			} while (i == 1);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void getCustomerAccountDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			int pageNum = 0;
			int i = 1;
			do {
				pageNum += 1;
				List<Account> accountList = logic.getAccounts(Integer.parseInt(request.getParameter("customerId")),
						pageNum);
				request.setAttribute("accountList", accountList);
				request.getRequestDispatcher("/jsp/User UI/AccountDetails.jsp").forward(request, response);
			} while (i == 1);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void blockAccount(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.blockAccount(Long.parseLong(request.getParameter("accountNumber")));
			request.setAttribute("message", "Account blocked Successfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void removeAccount(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.removeAccount(Long.parseLong(request.getParameter("accountNumber")));
			request.setAttribute("message", "Account removed Successfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void depositAmount(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.deposit((int) request.getSession().getAttribute("userId"),
					Long.parseLong(request.getParameter("accountNumber")),
					Integer.parseInt(request.getParameter("amount")));
			request.setAttribute("message", "Amount Depositted Succesfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void withdrawAmount(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.withDrawAmount((int) request.getSession().getAttribute("userId"),
					Long.parseLong(request.getParameter("accountNumber")),
					Integer.parseInt(request.getParameter("amount")));
			request.setAttribute("message", "Amount Withdrawn Succesfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);

		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void moneyTransfer(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.moneyTransfer((int) request.getSession().getAttribute("userId"),
					Integer.parseInt(request.getParameter("amount")),
					Long.parseLong(request.getParameter("senderAccountNumber")),
					Long.parseLong(request.getParameter("receiverAccountNumber")), request.getParameter("description"));
			request.setAttribute("message", "Money Transferred Succesfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);

		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (BankException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void resetPassword(HttpServletRequest request, HttpServletResponse response) {
		try {
			String password = logic.encryptPassword(request.getParameter("oldPassword"));
			if (password
					.equals(logic.login((int) request.getSession().getAttribute("userId"),
							request.getParameter("oldPassword")).getPassword())
					&& request.getParameter("1stpassword").equals(request.getParameter("2ndpassword"))) {
				logic.changePassword((int) request.getSession().getAttribute("userId"),
						request.getParameter("1stpassword"));
				request.setAttribute("message", "Password Changed Successfully!");
				request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);
			} else {
				throw new InvalidInputException("Password doesn't Match");
			}

		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (NoSuchAlgorithmException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void checkStatus(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserStatus status = logic.checkStatus((int) request.getSession().getAttribute("userId"));
			request.setAttribute("status", status);
			request.getRequestDispatcher("/jsp/User UI/CheckStatus.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getCreateEmployeePage(HttpServletRequest request, HttpServletResponse response) {
		try {
			Map<Integer,Branch> branchMap=logic.getAllBranches();
			List<String> branchList=new ArrayList<String>();
			branchMap.forEach((key,value)->{
				branchList.add(value.getName());
			});
			request.setAttribute("branchList", branchList);
			request.getRequestDispatcher("/jsp/Employee UI/CreateEmployee.jsp").forward(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(request.getParameter("userId")));
			employee.setPassword(logic.encryptPassword(request.getParameter("password")));
			employee.setName(request.getParameter("name"));
			employee.setEmail(request.getParameter("email"));
			employee.setDob(Supplement.dateToLong(request.getParameter("dob")));
			employee.setAddress(request.getParameter("address"));
			employee.setType(Integer.parseInt(request.getParameter("type")));
			employee.setStatus(0);
			employee.setContactNum(Long.parseLong(request.getParameter("contactNum")));
			employee.setDepartment(request.getParameter("department"));
			employee.setBranch(request.getParameter("branch"));
			logic.addEmployee(employee);
			request.setAttribute("message", "Employee added Succesfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (NoSuchAlgorithmException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ClassNotFoundException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void blockEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.blockEmployee(Integer.parseInt(request.getParameter("employeeId")));
			request.setAttribute("message", "Employee blocked Successfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void removeEmployee(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.removeEmployee(Integer.parseInt(request.getParameter("employeeId")));
			request.setAttribute("message", "Employee removed Succesfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);

		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ClassNotFoundException e) {
			request.setAttribute("message", "A Problem with the server");
			gotException(request, response);
		}
	}

	private void editEmployeePersonalDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employee employee = new Employee();
			employee.setId((int) request.getSession().getAttribute("userId"));
			employee.setName(request.getParameter("name"));
			employee.setEmail(request.getParameter("email"));
			employee.setDob(Supplement.dateToLong(request.getParameter("dob")));
			employee.setAddress(request.getParameter("address"));
			employee.setContactNum(Long.parseLong(request.getParameter("contactNumber")));
			logic.editEmployeePersonalInfo(employee);
			request.setAttribute("employee",
					logic.getCustomerPersonalInfo((int) request.getSession().getAttribute("userId")));
		request.getRequestDispatcher("/jsp/User UI/Icon.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void getEmployeePersonalDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employee employee = logic.getEmployeePersonalInfo((int) request.getSession().getAttribute("userId"));
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("/jsp/Employee UI/EmployeePersonalDetails.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void getEmployeeIdPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Employee UI/GetEmployeeId.jsp").forward(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getEmployeeDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			Employee employee = logic.getEmployeePersonalInfo(Integer.parseInt(request.getParameter("employeeId")));
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("/jsp/Employee UI/EmployeePersonalDetails.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void getCustomerDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			Customer customer = logic.getCustomerPersonalInfo(Integer.parseInt(request.getParameter("customerId")));
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("/jsp/Customer UI/CustomerPersonalDetails.jsp").forward(request, response);
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {

			request.setAttribute("message", "Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void createAccount(HttpServletRequest request, HttpServletResponse response) {
		try {
			Account account = new Account();
			account.setAccountNum(Long.parseLong(request.getParameter("accountNumber")));
			account.setCustomerId(Integer.parseInt(request.getParameter("userId")));
			account.setType(Integer.parseInt(request.getParameter("accountType")));
			account.setBalance(Integer.parseInt(request.getParameter("initialBalance")));
			account.setStatus(Integer.parseInt(request.getParameter("accountStatus")));
			account.setBranchId(Integer.parseInt(request.getParameter("branchId")));
			logic.addAccount(account);

			request.setAttribute("message", "Account Created Succesfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);

		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}

	}

	private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(request.getParameter("userId")));

			customer.setPassword(logic.encryptPassword(request.getParameter("password")));
			customer.setName(request.getParameter("name"));
			customer.setEmail(request.getParameter("email"));
			customer.setDob(Supplement.dateToLong(request.getParameter("dob")));
			customer.setAddress(request.getParameter("address"));
			customer.setType(2);
			customer.setStatus(0);
			customer.setContactNum(Long.parseLong(request.getParameter("contact")));
			customer.setAadharNum(Long.parseLong(request.getParameter("aadhaarNumber")));
			customer.setPanNum(request.getParameter("panNumber"));
			customer.setCreatedOn(Supplement.currentTimeInMillis());
			customer.setCreatedBy((int)request.getSession().getAttribute("userId"));
			logic.addCustomer(customer);
			request.setAttribute("message", "Customer added Succesfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);

		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (NoSuchAlgorithmException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void removeCustomer(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.removeCustomer(Integer.parseInt(request.getParameter("customerId")));
			request.setAttribute("message", "Customer removed Successfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getCreateBranchPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Employee UI/CreateBranch.jsp").forward(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void createBranch(HttpServletRequest request, HttpServletResponse response) {
		try {
			Branch branch = new Branch();
			branch.setBranchId(Integer.parseInt(request.getParameter("branchId")));
			branch.setName(request.getParameter("name"));
			branch.setiFSCcode(request.getParameter("ifscCode"));
			branch.setAddress(request.getParameter("address"));
			branch.setNumOfActiveEmployees(Integer.parseInt(request.getParameter("numOfActiveEmployees")));
			branch.setNumOfActiveAccounts(Integer.parseInt(request.getParameter("numOfActiveAccounts")));
			logic.addBranch(branch);
			request.setAttribute("message", "Branch added Succesfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);

		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getBranchIdPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getRequestDispatcher("/jsp/Employee UI/GetBranchId.jsp").forward(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getBranchDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			Branch branch = logic.getBranchDetails(Integer.parseInt(request.getParameter("branchId")));
			request.setAttribute("branch", branch);
			request.getRequestDispatcher("/jsp/Employee UI/BranchDetails.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void removeBranch(HttpServletRequest request, HttpServletResponse response) {
		try {
			logic.removeBranch(Integer.parseInt(request.getParameter("customerId")));
			request.setAttribute("message", "Customer removed Successfully!");
			request.getRequestDispatcher("/jsp/User UI/EndOfOperation.jsp").forward(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ClassNotFoundException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

	private void getIconPage(HttpServletRequest request, HttpServletResponse response) {
		try {
			int userType = (int) request.getSession().getAttribute("userType");
			if (userType == 0 || userType == 1) {
				request.setAttribute("employee",
						logic.getEmployeePersonalInfo((int) request.getSession().getAttribute("userId")));
			} else if (userType == 2) {
				request.setAttribute("customer",
						logic.getCustomerPersonalInfo((int) request.getSession().getAttribute("userId")));
			}
			request.getRequestDispatcher("/jsp/User UI/Icon.jsp").forward(request, response);
		} catch (IOException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (InvalidInputException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (SQLException e) {
			request.setAttribute("message","Sorry! An error has been Occured");
			gotException(request, response);
		}
	}

	private void gotException(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			request.getRequestDispatcher("/jsp/User UI/Error.jsp").forward(request, response);
			
		} catch (IOException e) {

			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		} catch (ServletException e) {
			request.setAttribute("message", e.getMessage());
			gotException(request, response);
		}
	}

}
