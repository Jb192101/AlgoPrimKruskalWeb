package org.jedi_bachelor.logic;

public class Converter {
	private int[][] convertedMatrix;
	
	public void convertMatrix(int[][] _matrix) {
		convertedMatrix = new int[_matrix.length][_matrix[0].length];
		for(int i = 0; i < _matrix.length; i++) {
			for(int j = 0; j < _matrix[0].length; j++) {
				if(_matrix[i][j] == -1) {
					convertedMatrix[i][j] = Integer.MAX_VALUE;
				} else {
					convertedMatrix[i][j] = _matrix[i][j];
				}
			}
		}
	}
	
	public int[][] getConvertedMatrix() {
		return convertedMatrix;
	}
}
