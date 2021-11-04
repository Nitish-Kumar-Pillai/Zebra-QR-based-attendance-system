<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="shortcut icon" href="Magzter-QR-code-Gold.ico" type="image/x-icon"> -->

    <title>Login</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">



    <!-- Bootstrap core CSS -->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"

>
<meta name="theme-color" content="#7952b3">


    <style>


      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>


    <!-- Custom styles for this template -->
    <link href="login.css" rel="stylesheet">
  </head>
  <body class="text-center">



<main  class="form-signin" >
  <form  method="POST" target="_blank" action="login_code.php">

    <h1 class="h3 mb-3 fw-normal"> <b>LOGIN</b></h1><br>

    <div class="form-floating">
        <!-- <input type="text" id="username" Name="fname" class="form-control top"  placeholder="Username" required> -->
        <input type="email" Name="email" class="form-control top" id="floatingInput" placeholder="Email Address" required>
        <input type="password" id="password" Name="password" class="form-control bottom"  placeholder="password" required>


    </div>

  <br><a href="registration.php" type="submit" target="_blank">New User ? Register Here</a><br>
    <br><button class="w-100 btn btn-lg btn-danger" type="submit" >Log in</button><br>

  </form>
</main>


<!-- <script src="login.js"></script> -->
  </body>
</html>
