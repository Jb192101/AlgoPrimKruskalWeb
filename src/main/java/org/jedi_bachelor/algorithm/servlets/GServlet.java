package org.jedi_bachelor.algorithm.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jedi_bachelor.algorithm.logic.Model;

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
            
            List<Integer[]> result = processingResult(matrix);
            request.setAttribute("result", result);
            
        } catch (Exception e) {
            request.setAttribute("result", "Ошибка: " + e.getMessage());
        }
		
		// создание куки
		
		// переход на страницу с результатом
        forwardToResult(request, response);
	}
	
	// метод для перевода на страницу с результатом
	private void forwardToResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/result").forward(request, response);
	}
	
	// метод для работы с моделью
	private List<Integer[]> processingResult(int[][] matrix) {
	    Model model = new Model();
	    model.setMatrix(matrix);
	    model.algoPrimaKraskala();
	    return model.getArcs();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
