import {DiagramElement, DiagramElementState} from "../../logic/DiagramElement";

export class LinkState extends DiagramElementState {


    constructor(
        id: number,
        private elem1: DiagramElement<DiagramElementState>,
        private elem2: DiagramElement<DiagramElementState>
    ) {
        super(id);
    }
}

export class Link extends DiagramElement<LinkState>{

}