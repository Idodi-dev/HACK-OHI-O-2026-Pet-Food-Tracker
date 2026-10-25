var PopupOpen; 

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
    