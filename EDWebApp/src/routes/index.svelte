<script lang="ts">
    import '../shared/styles/app.css';
    import "../shared/styles/base/colors.css"
    import "../shared/styles/components/containers.css"
    import "../shared/styles/components/inputs.css"
    import "../shared/styles/components/text.css"
    import "../shared/styles/components/molecules.css"
    import {onMount} from "svelte";

    onMount(() => {
        if (localStorage.theme === 'dark' || (!('theme' in localStorage) && window.matchMedia('(prefers-color-scheme: dark)').matches)) {
            document.documentElement.classList.add('dark')
        } else {
            document.documentElement.classList.remove('dark')
        }
    })

    let themeIcon = '🌣';
    const toggleDarkMode = () => {
        if (document.documentElement.classList.contains("dark")) {
            document.documentElement.classList.remove('dark');
            themeIcon = '🌣';
        } else {
            document.documentElement.classList.add('dark');
            themeIcon = '☽'
            localStorage.theme = 'dark'
        }
    }

</script>

<!--<div class="fixed bg-accent-l4 rotate-[28deg] w-[100vw] h-[200vh] left-[-45vw] top-[-100vh]"></div>-->
<div class="navbar-light">

    <p class="link pl-2">Home</p>

    <div class="flex-grow"></div>

    <button on:click={toggleDarkMode}>{themeIcon}</button>
</div>
