import {DiagramElement, DiagramElementStateWithSize} from "../../logic/DiagramElement";
import {ElementType} from "../../logic/ElementType";

export class UmlClassState extends DiagramElementStateWithSize {

    constructor(
        public name: string,
        id: number,
        startX: number, startY: number, width: number, height: number
    ) {
        super(id, startX, startY, width, height);
    }
}

export class UmlClass extends DiagramElement<UmlClassState>{

    constructor(state: UmlClassState, updateState: (s: UmlClassState) => void) {
        super(ElementType.UML_CLASS, state, updateState);
    }

}