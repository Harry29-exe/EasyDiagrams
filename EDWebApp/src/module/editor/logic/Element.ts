import type {ElementType} from "./ElementType";

export abstract class Element<STATE> {

    protected constructor(
        public readonly type: ElementType,
        public readonly state: STATE
    ) {
    }

}