const BASE_URL = "http://localhost:8080/api/v1"; // Updated port and added /v1

const PetFoodAPI = {

    async getAllPets(userId) {
        try {
            // Using backticks for string interpolation
            const response = await fetch(`${BASE_URL}/users/${userId}/pets`); 
            if (!response.ok) throw new Error("Failed to fetch pets");
            return await response.json();
        } catch (error) {
            console.error("API Error: ", error);
            throw error;
        }
    },
    
    async createPet(userId, petData) {
        try {
            const response = await fetch(`${BASE_URL}/users/${userId}/pets`, {
                method: "POST",
                headers: {
                    "content-type": "application/json"
                },
                body: JSON.stringify(petData) // Fixed typo: perData -> petData
            });
            if (!response.ok) throw new Error("Failed to create pet");
            return await response.json();
        } catch (error) {
            console.error("API Error: ", error);
            throw error;
        }
    },

    // Renamed from getAllPets to getAllUsers
    async getAllUsers() { 
        try {
            const response = await fetch(`${BASE_URL}/users`);
            if (!response.ok) throw new Error("Failed to fetch users");
            return await response.json();
        } catch (error) {
            console.error("API Error: ", error);
            throw error;
        }
    }
}