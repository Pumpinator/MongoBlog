document.addEventListener('DOMContentLoaded', function() {
    const signUpButton = document.getElementById('signUp');
    const signInButton = document.getElementById('signIn');
    const container = document.getElementById('container');

    function showRegisterMenu() {
        container.classList.add("right-panel-active");
    }

    // Función para mostrar el menú de inicio de sesión
    function showLoginMenu() {
        container.classList.remove("right-panel-active");
    }

    // Asignar eventos a los botones
    signUpButton.onclick = showRegisterMenu;
    signInButton.onclick = showLoginMenu;
});