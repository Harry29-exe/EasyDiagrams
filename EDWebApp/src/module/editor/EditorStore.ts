import {AbstractStore} from "../../shared/stores/AbstractStore";

export class EditorState {

}

export class EditorStore extends AbstractStore<EditorState> {

    constructor(value: EditorState) {
        super(value);
    }

}

export const editorStore: EditorStore = new EditorStore(new EditorState());