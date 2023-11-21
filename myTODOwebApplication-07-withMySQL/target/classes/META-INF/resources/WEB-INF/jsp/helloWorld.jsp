<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My First View</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background: linear-gradient(to bottom, #3498db, #bdc3c7);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            text-align: center;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            animation: fadeInUp 1s ease-out;
        }

        h1 {
            color: #3498db;
            margin-bottom: 40px;
            animation: rotateColor 9s infinite alternate;
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes rotateColor {
            0% {
                color: #3498db;
                transform: rotate(0deg);
            }
            50% {
                color: #e74c3c;
                transform: rotate(10deg);
            }
            100% {
                color: #e74c3c;
                transform: rotate(12deg);
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1><a href="http://localhost:8080/say-hello-using-jsp" style="text-decoration: none; color: inherit;">Welcome, TODO-Manager</a></h1>
        <!-- Add more content or features as needed -->
    </div>
</body>
</html>
