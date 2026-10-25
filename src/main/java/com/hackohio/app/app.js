import PetFoodAPI from "./api.js";

document.addEventListener("DOMContentLoaded", async () => {
    const petListenerContainer = document.getElementById("pet-list");

    try {
        const pets = await PetFoodAPI.getAllPets();
        
        // Render the data into HTML
        petListContainer.innerHTML = pets.map(pet => `
            <div class="pet-card">
                <h3>${pet.name}</h3>
                <p>Type: ${pet.type}</p>
            </div>
        `).join('');
    } catch (error) {
        petListenerContainer.innerHTML = '<p class="error">Could not load pet data.</p>'
    }
});