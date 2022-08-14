<script lang="ts">
    import EditorSidePanel from "../../module/editor/components/EditorSidePanel.svelte";
    import Editor from "../../module/editor/components/Editor.svelte";
    import {DiagramElement} from "../../module/editor/logic/DiagramElement";
    import {UmlClass, UmlClassState} from "../../module/editor/components/elements/UmlClass";
    import {ElementType} from "../../module/editor/logic/ElementType";

    let elements: DiagramElement<any>[] = [
        new UmlClass(new UmlClassState('Class 2', 0, 0, 100, 80), s => {})
    ]
</script>

<div class="z-10">
    <EditorSidePanel/>
</div>

<Editor editorId="0" elements={elements}></Editor>