import {AbstractStore} from "./AbstractStore";

const preferencesCookieName = 'properties';

export class Preferences {
    private _theme: 'dark' | 'light'
    private _minimalNavbar: boolean

    constructor(theme: "dark" | "light", minimalNavbar: boolean) {
        this._theme = theme;
        this._minimalNavbar = minimalNavbar;
    }

    static preferencesFromCookie(): Preferences {
        let cookie = document.cookie
            .split(';')
            .find(s => s.trimLeft().startsWith(preferencesCookieName+"="));

        if (!cookie) {
            return new Preferences('light', false);
        }

        let preferences = JSON.parse(cookie.trimLeft()
            .substring((preferencesCookieName+"=").length)) as Preferences
        console.log(preferences)
        return new Preferences(preferences._theme, preferences._minimalNavbar);
    }

    updateCookie() {
        document.cookie = `${preferencesCookieName}=${JSON.stringify(this)}`
    }

    set theme(value: "dark" | "light") {
        this._theme = value;
        if (value !== 'dark') {
            document.documentElement.classList.remove('dark');
        } else {
            document.documentElement.classList.add('dark');
        }
        this.updateCookie();
    }

    set minimalNavbar(value: boolean) {
        this._minimalNavbar = value;
        this.updateCookie();
    }


    get theme(): "dark" | "light" {
        return this._theme;
    }

    get minimalNavbar(): boolean {
        return this._minimalNavbar;
    }
}

export class PreferencesStore extends AbstractStore<Preferences> {

    constructor(value: Preferences) {
        super(value);
    }

    public switchTheme() {
        if (this.value.theme === 'dark') {
            this.value.theme = 'light';
        } else {
            this.value.theme = 'dark';
        }
        this.update();
    }

    public switchNavbar() {
        this.value.minimalNavbar = !this.value.minimalNavbar;
        this.update();
    }

    public reloadPreferences() {
        this.set(Preferences.preferencesFromCookie());
        this.update();
    }

}

export const preferencesStore: PreferencesStore = new PreferencesStore(new Preferences('light', false))