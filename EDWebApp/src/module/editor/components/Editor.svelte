<script lang="ts">
    import {DiagramElement} from "../logic/DiagramElement.js";
    import {ElementType} from "../logic/ElementType.js";
    import UmlClassView from "./elements/UmlClassView.svelte"; ;

    export let editorId = 0;


    export let elements: DiagramElement<any>[]
</script>

<div class="absolute top-0 bottom-0 z-0 top-[50vh] left-[50vw]">
    {#each elements as elem}
        {#if elem.type === ElementType.UML_CLASS}
            <UmlClassView element={elem}></UmlClassView>
        {:else if elem.type === ElementType.STANDARD_NODE}
        {/if}
    {/each}
</div>