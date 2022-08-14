<script lang="ts">
    import {goto} from "$app/navigation"
    import {preferencesStore} from "../stores/PreferencesStore";

    const toggleDarkMode = () => {
        preferencesStore.switchTheme();
    }

    let panelExtended;
    $: {
        panelExtended = !$preferencesStore.minimalNavbar
    }
    const toggleExtended = () => {
      preferencesStore.switchNavbar()
    }
</script>


<div class={`navbar bg-color-l3 text-primary-500 dark:text-primary-400 shadow-dark-lg
        ${panelExtended? ' ': 'rounded-br-2xl'} app-navbar`}
    style={`min-width: ${panelExtended? '100%': '10%'}; width: min-content`}>

    <p class="link pl-2" on:click={() => goto('/')}>Home</p>
    <p class="mx-3">/</p>
    <p class="link" on:click={() => goto('/editor')}>Editor</p>

    {#if panelExtended}
        <div class="min-w-[3em] flex-grow"></div>
    {:else}
        <div class="w-8"></div>
    {/if}


    <button on:click={toggleExtended} class="hover:bg-color-l2">
        {panelExtended? '<': '>'}
    </button>
    <button on:click={toggleDarkMode} class="hover:bg-color-l2">
        {$preferencesStore.theme === 'dark'? '☽': '🌣'}
    </button>
</div>

<style>
    .app-navbar {
        transition: 0.6s min-width;
    }

    button {
        @apply mx-0.5 px-1.5 rounded-full;
    }
</style>