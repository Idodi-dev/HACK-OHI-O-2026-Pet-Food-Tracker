var PopupOpen; 

async function createUser(Username, Password) {
  const url = 'http://localhost:8080/api/users';
  const payload = { 
    username: Username, 
    password: Password 
  };

  try {
    const response = await fetch(url, {
      method: 'POST', // Specifies the request type
      headers: {
        'Content-Type': 'application/json' // Tells the server to expect JSON
      },
      body: JSON.stringify(payload) // Converts JavaScript object to a JSON string
    });

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json(); // Parses the JSON response body
    console.log('Success:', data);
  } catch (error) {
    console.error('Error:', error);
  }
}


function SignIn() { 

        let user1 = "Glenn"; 

        let password1 = "1234"; 

        let usertest1 = document.getElementById("username").value; 

        let paswordtest1 = document.getElementById("password").value; 

        let visibility = document.getElementById("SignInPanel"); 

        PopupOpen = 0; 

    

        if (usertest1 == user1 && paswordtest1 == password1){ 

            document.getElementById("SignInPlease").innerHTML = "correct"; 

            visibility.style.display = "none"; 

            createUser(user1, password1);

        } 

        else{ 

            document.getElementById("SignInPlease").innerHTML = "Username or password incorrect"; 

        } 

    } 

    

    // BEGIN ADD PET FUNCTIONS 

    // When the user clicks on div, open the popup 

    function AddPetPopup() { 

        var popup = document.getElementById("myPopup"); 

        if (PopupOpen == 0){ 

            popup.classList.toggle("show") 

            PopupOpen = 1; 

        } 

    } 

    function InputPetInfo(){ 

        var popup = document.getElementById("myPopup"); 

        if (PopupOpen == 1){ 

            popup.classList.toggle("show") 

            PopupOpen = 0; 

        } 

    } 

    // END ADD PET FUNCTIONS 
    