import {ComponentFixture, ComponentFixtureAutoDetect, TestBed} from "@angular/core/testing";
import {By} from "@angular/platform-browser";
import {HelloWorld} from "../../src/components/HelloWorld.component";

describe("Component: HelloWorld", () => {
    let fixture: ComponentFixture<HelloWorld>;

    beforeEach(() => {
        TestBed.configureTestingModule({
            declarations: [HelloWorld],
            providers: [
                {provide: ComponentFixtureAutoDetect, useValue: true}
            ]
        });

        fixture = TestBed.createComponent(HelloWorld);
    });

    it("should render 'Hello World!'", () => {
        const mainText = fixture.debugElement.query(By.css("[data-test='welcome']")).nativeElement.textContent;
        expect(mainText).toEqual("Hello World!");
    })
});