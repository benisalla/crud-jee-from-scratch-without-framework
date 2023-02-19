package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;

import org.apache.tomcat.util.json.JSONParser;

import com.mysql.cj.conf.url.SingleConnectionUrl;
import com.mysql.cj.xdevapi.JsonParser;

import DAOLayer.IUserDao;
import DAOLayer.SinglotonContext;
import DAOLayer.UserImp;
import MetierLayer.User;
import Models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Servlet", urlPatterns = {"/","/index"})
public class Servlet extends HttpServlet {
//	Connection connection = new SinglotonContext().getConnection();
	IUserDao userResource;
	
	@Override
	public void init() throws ServletException {
		userResource = new UserImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		System.out.println(path);
		UserModel userModel = new UserModel();
		
		switch (path) {
		case "/index": {
			userModel.setUsers(userResource.getUsers());
			request.setAttribute("userModel", userModel);
			request.getRequestDispatcher("/View/default.jsp").forward(request, response);
			break;
		}
		case "/delete":{
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userResource.getUser(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/View/delete.jsp").forward(request, response);
			break;
		}
		case "/edit":{
			int id = Integer.parseInt(request.getParameter("id"));
			User user = userResource.getUser(id);
			request.setAttribute("user", user);
			request.getRequestDispatcher("/View/edit.jsp").forward(request, response);
			break;
		}
		case "/add":{
			request.getRequestDispatcher("/View/add.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		switch (path) {
		case "/delete": {
			int id = Integer.parseInt(request.getParameter("user_id"));
			int result = userResource.deleteUser(id);
			response.sendRedirect("index");
			break;
		}
		case "/edit": {
			int id = Integer.parseInt(request.getParameter("id"));
			User user = new User();
			user.setId(id);
			user.setGender(request.getParameter("gender"));
			user.setEmail(request.getParameter("email"));
			user.setName(request.getParameter("name"));
			user.setProfession(request.getParameter("profession"));
			User updatedUser = userResource.UpdateUser(user);
			request.setAttribute("user", updatedUser);
			request.getRequestDispatcher("/View/updated.jsp").forward(request, response);
			break;
		}
		case "/add": {
			User user = new User();
			user.setGender(request.getParameter("gender"));
			user.setEmail(request.getParameter("email"));
			user.setName(request.getParameter("name"));
			user.setProfession(request.getParameter("profession"));
			User updatedUser = userResource.save(user);
			request.setAttribute("user", updatedUser);
			request.getRequestDispatcher("/View/updated.jsp").forward(request, response);
			break;
		}
		case "/search": {
			String hint = "%"+request.getParameter("hint")+"%";
			UserModel userModel = new UserModel();
			userModel.setUsers(userResource.SearchByHint(hint));
			request.setAttribute("userModel", userModel);
			request.getRequestDispatcher("/View/default.jsp").forward(request, response);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + path);
		}
	}
}
