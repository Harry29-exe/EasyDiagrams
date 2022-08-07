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

<div class="h-stack">
    <div class={`navbar bg-color-l3 text-primary-500 dark:text-primary-400 shadow-dark-lg
            ${panelExtended? 'flex-grow': 'minimal-panel'}`}>

        <p class="link pl-2" on:click={() => goto('/')}>Home</p>
        <p class="mx-3">/</p>
        <p class="link" on:click={() => goto('/editor')}>Editor</p>

        <div class="flex-grow min-w-[3em]"></div>

        <button on:click={toggleExtended}>&Lt;</button>
        <button on:click={toggleDarkMode}>{themeIcon}</button>
    </div>
</div>

<style>
    .minimal-panel {
        width: min-content;
        @apply rounded-br-2xl;
    }
</style>