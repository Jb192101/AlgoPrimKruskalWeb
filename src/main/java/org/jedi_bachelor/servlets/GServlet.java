package org.jedi_bachelor.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import org.jedi_bachelor.logic.Model;

public class GServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            int size = Integer.parseInt(request.getParameter("matrixSize"));
            
            if (size < 1 || size > 10) {
                throw new IllegalArgumentException("Размер матрицы должен быть от 1 до 10");
            }
            
            int[][] matrix = new int[size][size];
            
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    String paramName = "matrix_" + i + "_" + j;
                    matrix[i][j] = Integer.parseInt(request.getParameter(paramName));
                }
            }
            
            Model model = new Model();
            model.setMatrix(matrix);
            model.algoPrimaKraskala();
            ArrayList<Integer> result = (ArrayList) model.getArcs();
            
            request.setAttribute("result", result.toString());
            
        } catch (Exception e) {
            request.setAttribute("result", "Ошибка: " + e.getMessage());
        }
        
        request.getRequestDispatcher("primKruskal.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
