<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<head>
    <title>Алгоритм Прима-Краскала</title>
    <style>
        table {
            border-collapse: collapse;
            margin: 10px 0;
        }
        table, th, td {
            border: 1px solid black;
            padding: 5px;
        }
        input[type="number"] {
            width: 50px;
        }
    </style>
    <script>
        function updateMatrix() {
            const size = document.getElementById("matrixSize").value;
            const matrixDiv = document.getElementById("matrixContainer");
            let html = '<table>';
            
            html += '<tr><th></th>';
            for (let j = 0; j < size; j++) {
                html += '<th>' + (j + 1) + '</th>';
            }
            html += '</tr>';
            
            for (let i = 0; i < size; i++) {
                html += '<tr><th>' + (i + 1) + '</th>';
                for (let j = 0; j < size; j++) {
                    html += '<td><input type="number" name="matrix_' + i + '_' + j + '" value="0" min="0"></td>';
                }
                html += '</tr>';
            }
            html += '</table>';
            
            matrixDiv.innerHTML = html;
        }
    </script>
</head>
</head>
<body>
    <h1>Алгоритм Прима-Краскала</h1>
    <form action="/algo-p-k/algo-servletg" method="post">
        <div>
            <label for="matrixSize">Размер матрицы (1-10):</label>
            <input type="number" id="matrixSize" name="matrixSize" min="1" max="10" value="3" 
                   onchange="updateMatrix()" required>
        </div>
        
        <div id="matrixContainer">
            
        </div>
        
        <input type="submit" value="Рассчитать">
    </form>
    
    <script>
        window.onload = updateMatrix;
    </script>
</body>
</html>