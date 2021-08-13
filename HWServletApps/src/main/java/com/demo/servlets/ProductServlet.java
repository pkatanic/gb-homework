package com.demo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.entities.Product;
/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/demo")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("p01", "name 1",  20));
		products.add(new Product("p02", "name 2",  3));
		products.add(new Product("p03", "name 3",  11));
		products.add(new Product("p04", "name 4",  13));
		products.add(new Product("p05", "name 5",  1));
		products.add(new Product("p06", "name 6",  5));
		products.add(new Product("p07", "name 7",  8));
		products.add(new Product("p08", "name 8",  112));
		products.add(new Product("p09", "name 9",  95));
		products.add(new Product("p010", "name 10",  89));
		request.setAttribute("products", products);
		request.getRequestDispatcher("demo/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}