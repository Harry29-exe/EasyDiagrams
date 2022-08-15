import type {ElementType} from "./ElementType";

export class DiagramElementState {

    public id: number = 0;

    constructor(
        public startX: number,
        public startY: number,
        public width: number,
        public height: number
    ) {
    }

    toCSS(): string {
        return `width: ${this.width}px; height: ${this.height}px;
        top: ${this.startY}px; left: ${this.startX}px;`;
    }

}

export abstract class DiagramElement<STATE extends DiagramElementState> {

    protected constructor(
        public readonly type: ElementType,
        public readonly state: STATE,
        public readonly updateState: (s: STATE) => any
    ) {
    }

}