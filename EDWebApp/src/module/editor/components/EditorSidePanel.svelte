<script lang="ts">
    import {preferencesStore} from "../../../shared/stores/PreferencesStore";

    let wrapper: HTMLDivElement;
    const max = 1000;
    const min = 100;
    export let position: 'l' | 'r' = 'l';
    let width = 160;
    let hidden = false;

    const resizeStart = (ev: MouseEvent) => {
        let startWidth = width;
        let startPosition = ev.x;
        let lastTime = Date.now();
        const resize = (ev: MouseEvent) => {
            if (Date.now() - lastTime < 16) {
                return;
            }
            lastTime = Date.now();
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
<div bind:this={wrapper} class={`side-panel fixed top-0 bg-color-l4 select-none ${position === 'r'? 'right-0': ''}`} style={`width: ${width}px; padding-top: ${getTopOffset()};`}>
    <slot></slot>
    <div on:mousedown={resizeStart} class={`h-full w-5 absolute top-0 hover:cursor-w-resize center ${position === 'r'? '-left-2': '-right-2'}`}>
        <div class="bg-color-l3 h-full w-1 mx-2 hover:bg-color-l2 center"></div>
    </div>
</div>
{:else}
    <div on:mousedown={resizeStart}
         class={`h-full w-3 bg-color-l2 hover:bg-color-l1 absolute top-0 hover:cursor-w-resize center ${position === 'r'? 'right-0': 'left-0'}`}>
        <p class="select-none text-sm text-black dark:text-white font-extrabold">&GT;</p>
    </div>
{/if}

<style>

    div {
        height: 100vh;
        transition: all 0s linear 0s;
    }

</style>