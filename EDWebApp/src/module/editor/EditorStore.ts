import {AbstractStore} from "../../shared/stores/AbstractStore";
import type {DiagramElement} from "./logic/DiagramElement";

export class EditorState {

    constructor(
        public editorId: number,
        public elements: Map<number, DiagramElement<any>>
    ) {

    }
}

export class EditorStore extends AbstractStore<EditorState> {

    constructor(value: EditorState) {
        super(value);
    }

    addElement(element: DiagramElement<any>) {

    }

    removeElement(elementId: number) {

    }

}

