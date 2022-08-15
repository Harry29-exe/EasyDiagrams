<script lang="ts">
    import EditorSidePanel from "../../module/editor/components/EditorSidePanel.svelte";
    import Editor from "../../module/editor/components/Editor.svelte";
    import {DiagramElement} from "../../module/editor/logic/DiagramElement";
    import {UmlClass, UmlClassState} from "../../module/editor/components/elements/UmlClass";

    let elements: DiagramElement<any>[] = [
        new UmlClass(new UmlClassState('Class 2', 0, 0, 100, 80), s => {})
    ]
</script>

<div class="background-color bg-gray-200 dark:bg-gray-800"></div>
<div class="background"></div>

<div class="z-10">
    <EditorSidePanel>
        <div class="text-2xl">Hello world</div>
    </EditorSidePanel>
</div>

<Editor editorId="0" elements={elements}></Editor>

<div class="z-10">
    <EditorSidePanel position="r">
        <div class="text-2xl">Hello world</div>
    </EditorSidePanel>
</div>

<style>
    .background {
        @apply fixed w-[100vw] h-[100vh] top-0 left-0;
        background-image: url('/Circuit Board.svg');
        background-size: 140%;
        opacity: 0.25;
        z-index: -10;
    }

    .background-color {
        @apply fixed w-[100vw] h-[100vh] top-0 left-0;
        z-index: -11;
    }
</style>