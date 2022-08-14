<script lang="ts">
    import {UmlClass} from "./UmlClass";

    export let element: UmlClass;
    console.log(element.state.toCSS());
</script>

<div class="elem-wrapper bg-accent-l4 center" style={element.state.toCSS()}>

    <div class="center text-xl">{element.type}</div>

</div>

<style>
    .elem-wrapper {
        @apply absolute;
        @apply rounded-lg border-2 border-primary-400;
    }
</style>