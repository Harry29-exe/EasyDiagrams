<script lang="ts">
    import {goto} from "$app/navigation"

    let themeIcon = '🌣';
    const toggleDarkMode = () => {
        if (document.documentElement.classList.contains("dark")) {
            document.documentElement.classList.remove('dark');
            themeIcon = '🌣';
            localStorage.theme = 'light'
        } else {
            document.documentElement.classList.add('dark');
            themeIcon = '☽'
            localStorage.theme = 'dark'
        }
    }

    let panelExtended = true;
    const toggleExtended = () => {
      panelExtended = !panelExtended;
    }
</script>


<div class={`navbar bg-color-l3 text-primary-500 dark:text-primary-400 shadow-dark-lg
        ${panelExtended? ' ': 'rounded-br-2xl'} app-navbar`}
    style={`min-width: ${panelExtended? '100%': '20%'}; width: min-content`}>

    <p class="link pl-2" on:click={() => goto('/')}>Home</p>
    <p class="mx-3">/</p>
    <p class="link" on:click={() => goto('/editor')}>Editor</p>

    <div class="min-w-[3em] flex-grow"></div>


    <button class="mx-1 px-1 hover:bg-color-l2 rounded-full"
            on:click={toggleExtended}
    >
        {panelExtended? '<': '>'}
    </button>
    <button class="mx-1 px-1 hover:bg-color-l2 rounded-full"
            on:click={toggleDarkMode}
    >
        {themeIcon}
    </button>
</div>

<style>
    .app-navbar {
        transition: 0.6s min-width;
    }

    button {
        @apply mx-1;
    }
</style>