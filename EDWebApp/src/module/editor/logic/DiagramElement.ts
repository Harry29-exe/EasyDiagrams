import type {ElementType} from "./ElementType";

export class DiagramElementState {

    public id = 0;

    constructor(id: number) {
        this.id = id;
    }
}

export class DiagramElementStateWithSize extends DiagramElementState {

    constructor(
        id: number,
        public startX: number,
        public startY: number,
        public width: number,
        public height: number
    ) {
        super(id)
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
        public readonly updateState: (s: STATE) => void
    ) {
    }

}