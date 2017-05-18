import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {RouterModule} from "@angular/router";
import {ROUTES} from "./app.routes";
import {App} from "./components/App.component";
import {HelloWorld} from "./components/HelloWorld.component";

@NgModule({
    declarations: [
        App,
        HelloWorld
    ],
    imports: [
        BrowserModule,
        RouterModule.forRoot(ROUTES, {useHash: true})
    ],
    bootstrap: [App]
})
export class AppModule {

}