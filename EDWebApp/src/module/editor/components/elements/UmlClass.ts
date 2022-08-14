import {DiagramElement, DiagramElementState} from "../../logic/DiagramElement";
import {ElementType} from "../../logic/ElementType";

export class UmlClassState extends DiagramElementState{


    constructor(
        public name: string,

        startX: number, startY: number, width: number, height: number
    ) {
        super(startX, startY, width, height);
    }
}

export class UmlClass extends DiagramElement<UmlClassState>{


    constructor(state: UmlClassState, updateState: (s: UmlClassState) => any) {
        super(ElementType.UML_CLASS, state, updateState);
    }
}