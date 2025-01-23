<!DOCTYPE html>
<html>
<head>
    <title>G17 Parser</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(45deg, #ff9a9e, #fad0c4, #fad0c4, #ff9a9e, #fbc2eb, #a18cd1, #fad0c4, #ff9a9e);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
            flex-direction: column;
            color: #fff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
        .container {
            display: flex;
            gap: 20px;
            justify-content: center;
            align-items: stretch;
        }
        .glass {
            background: rgba(255, 255, 255, 0.1);
            border-radius: 10px;
            box-shadow: 0 4px 30px rgba(0, 0, 0, 0.1);
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            border: 1px solid rgba(255, 255, 255, 0.3);
            padding: 20px;
            max-width: 400px;
            width: 100%;
            display: flex;
            flex-direction: column;
            color: #fff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
        .form-control {
            background: rgba(255, 255, 255, 0.1);
            border: 1px solid rgba(255, 255, 255, 0.3);
            color: #fff;
        }
        .form-control::placeholder {
            color: rgba(255, 255, 255, 0.7);
        }
        .title {
            margin-bottom: 20px;
            text-align: center;
            color: #fff;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }
    </style>
</head>
<body>
    <h1 class="title w3-text-white">MiniProject CSC569</h1>
    <%
        String input = (String) request.getAttribute("input");
        String result = (String) request.getAttribute("result");
    %>
    <div class="container">
        <div class="glass w3-container">
            <h1 class="w3-center">G17 Parser</h1><hr>
            <form action="ParserServlet" method="post">
                <div class="form-group">
                    <label for="expression">Enter an arithmetic expression:</label>
                    <input type="text" class="form-control" id="expression" name="expression" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Parse</button>
            </form>
        </div>
        <div class="glass w3-container">
            <h1 class="w3-center">Parser Result</h1><hr>
            <p>Input: <%=input%></p>
            <p>Result: <%=result%></p>
        </div>
    </div>
</body>
</html>
