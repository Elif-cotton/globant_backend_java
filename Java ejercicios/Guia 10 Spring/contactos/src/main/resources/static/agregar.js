    document.getElementById('email').addEventListener('input', function () {
          var emailInput = this.value;
          var emailError = document.getElementById('email-error');

          if (!/@/.test(emailInput)) {
                emailError.textContent = 'El email debe contener el símbolo "@"';
          } else {
                emailError.textContent = '';
          }
    });

    document.getElementById('tu-formulario').addEventListener('submit', function (event) {
         var emailInput = document.getElementById('email').value;

         if (!/@/.test(emailInput)) {
              event.preventDefault(); // Evita que el formulario se envíe
              document.getElementById('email-error').textContent = 'El email debe contener el símbolo "@"';
         }
    });