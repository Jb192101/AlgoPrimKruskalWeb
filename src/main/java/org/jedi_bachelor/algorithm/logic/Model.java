package org.jedi_bachelor.algorithm.logic;

import java.util.*;

public class Model {
	private boolean[] b;
    private int countOfComplete = 0;
    private boolean isFull = false;
    private int[][] matrix;
    private Set<Integer> indexes;
    private List<Integer[]> arcs;
    private int L = 0;

    public Model() {
    	
    }
    
    public void setMatrix(int[][] _matrix) {
    	this.b = new boolean[_matrix.length];
        for(int i = 0; i < _matrix.length; i++) {
            b[i] = false;
        }


        this.matrix = _matrix;
        this.arcs = new ArrayList<>();
        this.indexes = new HashSet<>();
    }

    // Реализация алгоритма Прима-Краскала
    public void algoPrimaKraskala() {
    	if(this.matrix != null) {
		    // Шаг 1
		    b[0] = true;
		    indexes.add(0);
		    countOfComplete++;
		
		    // Шаг 2-3-4
		    while(!isFull) {
		        int min = Integer.MAX_VALUE;
		        int ind1 = -1, ind2 = -1;
		        for(int i : indexes) {
		            for(int j = 0; j < matrix.length; j++) {
		                if(!indexes.contains(j) && matrix[i][j] != Integer.MAX_VALUE && min > matrix[i][j]) {
		                    min = matrix[i][j];
		                    ind1 = i;
		                    ind2 = j;
		                }
		            }
		        }
		
		        arcs.add(new Integer[] {ind1, ind2});
		        indexes.add(ind2);
		        countOfComplete++;
		        b[ind2] = true;
		        L += matrix[ind1][ind2];
		        matrix[ind1][ind2] = Integer.MAX_VALUE;
		        matrix[ind2][ind1] = Integer.MAX_VALUE;
		        if(countOfComplete == matrix.length) {
		            isFull = true;
		        }
		    }
    	}

    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    public List<Integer[]> getArcs() {
        return this.arcs;
    }

    public int getL() {
        return this.L;
    }
}
