const BASE_URL = "http://localhost:5432/api";

const PetFoodAPI = {

    async getAllPets() {
        try {
            const response = await fetch("${BASE_URL}/pets")
            if (!response.ok) throw new Error("Failed to fetch pets");
            return await response.json();
        } catch (error) {
            console.error("API Error: ", error);
            throw error;
        }
    },
    
    async createPet(petData) {
        try {
            const response = await fetch("${BASE_URL}/pets", {
                method: "POST",
                headers: {
                    "content-type": "application/json"
                },
                body: JSON.stringify(perData)
            });
            if (!response.ok) throw new Error("Failed to fetch pets");
            return await response.json();
        } catch (error) {
            console.error("API Error: ", error);
            throw error;
        }
    }
}