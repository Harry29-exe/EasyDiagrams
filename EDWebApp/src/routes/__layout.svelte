<script lang="ts">
    import '../shared/styles/app.css';
    import "../shared/styles/base/colors.css"
    import "../shared/styles/base/text.css"
    import "../shared/styles/components/containers.css"
    import "../shared/styles/components/inputs.css"
    import "../shared/styles/components/text.css"
    import "../shared/styles/components/molecules.css"
    import "../shared/styles/utils/shadows.css"
    import {onMount} from "svelte";
    import Navbar from "../shared/components/Navbar.svelte";
    import {preferencesStore} from "../shared/stores/PreferencesStore";


    onMount(() => {
        preferencesStore.reloadPreferences();
        console.log($preferencesStore)
        if ($preferencesStore.theme === 'dark') {
            document.documentElement.classList.add('dark')
        } else {
            document.documentElement.classList.remove('dark')
        }
    })

    let navbarEnabled = true;
</script>

<div class="relative h-full">
    {#if navbarEnabled}
    <Navbar></Navbar>
    {/if}

    <slot></slot>
</div>