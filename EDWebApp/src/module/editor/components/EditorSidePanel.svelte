<script lang="ts">
    import {preferencesStore} from "../../../shared/stores/PreferencesStore";

    const max = 340;
    const min = 100;
    export let position: 'l' | 'r' = 'l';
    let width = 160;
    let hidden = false;

    const resizeStart = (ev: MouseEvent) => {
        let startWidth = width;
        let startPosition = ev.x;
        const resize = (ev: MouseEvent) => {
            if (position === 'l' && ev.x < window.innerWidth * 0.05 || position === 'r' && ev.x > window.innerWidth * 0.95) {
                hidden = true;
                return;
            } else {
                hidden = false;
            }

            let diff: number = position == "l"?
                ev.x - startPosition :
                startPosition - ev.x;

            width = Math.min(Math.max(startWidth + diff, min), max);
        };
        window.addEventListener('pointermove', resize);
        window.addEventListener('mouseup', () => window.removeEventListener('pointermove', resize));
    }

    const getTopOffset = () => {
        return position === 'r' && $preferencesStore.minimalNavbar? '10px': '60px';
    }

</script>

{#if !hidden}
<div class={`side-panel fixed top-0 bg-primary-400 ${position === 'r'? 'right-0': ''}`}  style={`width: ${width}px; padding-top: ${getTopOffset()}`}>
    <slot></slot>
    <div on:mousedown={resizeStart}
        class={`h-full w-4 bg-color-l2 absolute top-0 hover:cursor-w-resize center ${position === 'r'? 'left-0': 'right-0'}`}>
        <p class="select-none text-sm text-black dark:text-white font-extrabold">&GT;</p>
    </div>
</div>
{:else}
    <div on:mousedown={resizeStart}
         class={`h-full w-4 bg-color-l2 absolute top-0 hover:cursor-w-resize center ${position === 'r'? 'right-0': 'left-0'}`}>
        <p class="select-none text-sm text-black dark:text-white font-extrabold">&GT;</p>
    </div>
{/if}

<style>

    div {
        height: 100vh;
    }

</style>