<script lang="ts">
    import {beforeUpdate, onMount} from "svelte";

    let width = 160;

    const resizeStart = (ev: MouseEvent) => {
        let startWidth = width;
        let startPosition = ev.x;
        const resize = (ev: MouseEvent) => {
            width = Math.min(Math.max(startWidth + ev.x- startPosition, 20), 280);
        };
        window.addEventListener('pointermove', resize);
        window.addEventListener('mouseup', () => window.removeEventListener('pointermove', resize));
    }

</script>

<div class="side-panel bg-primary-400" style={`width: ${width}px`}>
    <slot></slot>
    <div on:mousedown={resizeStart}
        class="h-full w-4 bg-color-l2 absolute right-0 top-0 hover:cursor-w-resize center">
        <p class="select-none text-sm text-black dark:text-white font-extrabold">&GT;</p>
    </div>
</div>

<style>

    div {
        height: calc(100vh - 56px);
    }

</style>