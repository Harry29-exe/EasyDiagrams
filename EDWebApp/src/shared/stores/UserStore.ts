import {AbstractStore} from "./AbstractStore";
import {UserApi} from "../../generated";
import {UserApiClient} from "../apiClient/UserApi";

export class UserHolder {

    public isLogged: boolean

    constructor(isLogged: boolean) {
        this.isLogged = isLogged;
    }



}

export class UserStore extends AbstractStore<UserHolder> {

    constructor(value: UserHolder) {
        super(value);
    }

    private tryLogin() {
        console.log()
    }

}