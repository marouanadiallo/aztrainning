// Alpine est déjà global, pas d'import !
document.addEventListener('alpine:init', () => {
    Alpine.data('tasksModule', () => ({
        users: [],
        init() {
            console.log('Users module initialized');
        }
    }));
});