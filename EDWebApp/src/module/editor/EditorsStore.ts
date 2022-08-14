import {AbstractStore} from "../../shared/stores/AbstractStore";

export class EditorsState {

    editors: Map<number, EditorsState> = new Map<number, EditorsState>();

    constructor(
    ) {
    }
}

export class EditorsStore extends AbstractStore<EditorsState> {

    constructor(value: EditorsState) {
        super(value);
    }

    getStateById(editorId: number): EditorsState {
        let editor = this.value.editors.get(editorId);
        if (!editor) {
            throw new Error("");
        }

        return editor;
    }

    

}

export const editorStore: EditorsStore = new EditorsStore(new EditorsState());
