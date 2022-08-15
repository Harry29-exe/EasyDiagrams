<script lang="ts">
    import {UmlClass} from "./UmlClass";

    export let element: UmlClass;

    const onMouseDown = (event: MouseEvent) => {
        let lastPosition = [event.x, event.y];
        const onMouseMove = (event: MouseEvent) => {
            element.state.startX += event.x - lastPosition[0]
            element.state.startY += event.y - lastPosition[1]
            lastPosition = [event.x, event.y]
        }
        window.addEventListener('mousemove', onMouseMove)
        window.addEventListener('mouseup', () => {
            window.removeEventListener('mousemove', onMouseMove);
            window.removeEventListener('mouseup', this)
        })
    }
    let startPosition: [number, number] = [0, 0]
    const onDragStart = (event: DragEvent) => {
        startPosition = [event.x, event.y];
    }

    const onDragEnd = (event: DragEvent) => {
        element.state.startX += event.x - startPosition[0];
        element.state.startY += event.y - startPosition[1];
    }
</script>

<div class="elem-wrapper bg-accent-l4 center"
     draggable="true" on:dragend={onDragEnd} on:dragstart={onDragStart}
     style={`width: ${element.state.width}px; height: ${element.state.height}px; top: ${element.state.startY}px; left: ${element.state.startX}px`}
>
<!--on:mousedown={onMouseDown}-->

    <div class="center text-xl">{element.type}</div>

</div>

<style>
    .elem-wrapper {
        @apply relative overflow-hidden;
        @apply rounded-lg border-2 border-primary-400;
        transform: translate(0, 0);
    }
</style>