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


    onMount(() => {
        if (localStorage.theme === 'dark' || (!('theme' in localStorage) && window.matchMedia('(prefers-color-scheme: dark)').matches)) {
            document.documentElement.classList.add('dark')
        } else {
            document.documentElement.classList.remove('dark')
        }
    })

</script>

<div class="relative h-[100%] ">
    <Navbar></Navbar>

    <slot></slot>
    <div class="w-1 h-[2000px]"></div>
</div>