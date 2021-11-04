
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- <link rel="shortcut icon" href="Magzter-QR-code-Gold.ico" type="image/x-icon"> -->


    <title>Sign Up</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta name="theme-color" content="#7952b3">


    <style>

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>


    <!-- Custom styles for this template -->
    <link href="registration.css" rel="stylesheet">
  </head>
  <body class="text-center">

<main  class="form-signin" >
  <form action="registration_code.php" method="POST" target="_blank">
    <h1 class="h3 mb-3 fw-normal"> <b>SIGN UP</b></h1><br>
    <div class="form-floating">
        <input type="text" name="firstname" class="form-control top"  placeholder="Enter FirstName">
          <input type="text" name="lastname" class="form-control middle"  placeholder="Enter LastName">
        <input type="email" Name="email" class="form-control middle" id="floatingInput" placeholder="Email Address">
          <input type="text" Name="subject" class="form-control middle"  placeholder="Enter Subject">
            <input type="password" name="password" class="form-control bottom"  placeholder="Set password">


    </div>


    <br><button class="w-100 btn btn-lg btn-warning" type="submit" >Sign Up</button><br>

  </form>
</main>



  </body>
</html>
