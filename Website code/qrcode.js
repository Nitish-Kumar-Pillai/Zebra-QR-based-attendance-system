

var mytextbox = document.getElementById('qrText');
    var mydropdown = document.getElementById('dropdown');

    mydropdown.onchange = function(){
          mytextbox.value = mytextbox.value  + this.value;

    }



let qr;
(function () {
  qr = new QRious({
    element: document.querySelector("#qrCode"),
    size: 200,
    value: "ZEBRA",
     // background:"red",
    // foreground:"red",
  });
})();

const generateQRCode = () => {
  const qrText = document.querySelector("#qrText").value;
  qr.set({
    value: qrText,
  });
};
