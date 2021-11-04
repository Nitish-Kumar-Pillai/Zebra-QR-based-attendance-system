<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
      <!-- <link rel="shortcut icon" href="Magzter-QR-code-Gold.ico" type="image/x-icon"> -->
    <link rel="stylesheet" href="qrcode.css">
    <title>qrcode</title>
  </head>
  <body>

    <div class="container">
      <div class="heading">
        <p>
    SCAN QR CODE TO MARK YOUR ATTENDENCE !
        </p>
      </div>
      <div class="inputGroup">
          <label for="qrText"> <h3><b>Select Lecture </b></h3>  </label><br><br>



<select id="dropdown">
  <option value="lecture_01">lecture_01</option>
  <option value="lecture_02">lecture_02</option>
  <option value="lecture_03">lecture_03</option>
  <option value="lecture_04">lecture_04</option>
  <option value="lecture_05">lecture_05</option>
  <option value="lecture_06">lecture_06</option>
  <option value="lecture_07">lecture_07</option>
  <option value="lecture_08">lecture_08</option>
  <option value="lecture_09">lecture_09</option>
  <option value="lecture_10">lecture_10</option>
</select>
<input type="text" id="qrText" placeholder="eg: lecture_01 " /><br><br>
      </div>

      <button class="qrBtn" onclick="generateQRCode();">
        Generate QR Code
      </button>
      <br><br><br>
      <canvas id="qrCode"></canvas>
      <br><br><a href="index.php"> DONE ? CLICK HERE TO GO HOME </a>
    </div>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/qrious/4.0.2/qrious.min.js" ></script>
      <script src="qrcode.js" charset="utf-8"></script>
  </body>
</html>
